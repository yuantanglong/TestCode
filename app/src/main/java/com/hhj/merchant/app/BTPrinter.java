package com.hhj.merchant.app;

import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Base64;
import android.view.View;
import android.widget.TextView;

import com.baseapp.common.view.DialogWrapper;
import com.baseapp.common.view.Global;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.gprinter.aidl.GpService;
import com.gprinter.command.EscCommand;
import com.gprinter.command.GpCom;
import com.gprinter.io.PortParameters;
import com.gprinter.save.PortParamDataBase;
import com.gprinter.service.GpPrintService;
import com.hhj.merchant.bean.OrdersBean;
import com.hhj.merchant.ui.main.activity.MainActivity;
import com.hhj.merchant.ui.order.adapter.OrderListAdapter;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class BTPrinter {
    private final BluetoothAdapter mBluetoothAdapter;
    private Context context;
    private OrdersBean.OrdersListBean bean;
    private int rel;
    private Dialog dialog;
    private Disposable disposable;
    private int count = 1;
    private String deliver_type;
    private int mPrinterIndex = 0;
    public PrinterServiceConnection conn;
    public GpService gpService;
    private PortParameters mPortParam[] = new PortParameters[GpPrintService.MAX_PRINTER_CNT];
    public interface ConnectState {
        void getIsConnectSuccess(boolean isSuccess);
    }

    private static ConnectState connectState;
    class PrinterServiceConnection implements ServiceConnection {
        @Override
        public void onServiceDisconnected(ComponentName name) {
            gpService = null;
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            gpService = GpService.Stub.asInterface(service);
        }
    }

    private void connection() {
        conn = new PrinterServiceConnection();
        Intent intent = new Intent(context, GpPrintService.class);
        context.bindService(intent, conn, Context.BIND_AUTO_CREATE); // bindService
    }

    public BTPrinter(Context context) {
        this.context = context;
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        connection();
    }

    public void setDataBean(OrdersBean.OrdersListBean bean) {
        this.bean = bean;
    }

    public int getPortStatus(boolean isToast) {
        try {
            if (mBluetoothAdapter.isEnabled()) {
                String address_print = SPUtils.getInstance().getString(Global.ADDRESS_PRINT);
                int printerId = SPUtils.getInstance().getInt(Global.PRINTERID,0);
                rel = gpService.openPort(printerId, 4, address_print, 0);
                GpCom.ERROR_CODE errorCode = GpCom.ERROR_CODE.values()[rel];
                if (errorCode != GpCom.ERROR_CODE.SUCCESS) {
                    getPrinterStatusClicked(isToast);
                }
                return gpService.queryPrinterStatus(mPrinterIndex, 500);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void print() {
        try {
            if (mBluetoothAdapter.isEnabled()) {
                getPortStatus(true);
                if (getPortStatus(false) == GpCom.STATE_NO_ERR) {
                    showDialog("打印数据传送中");
                    disposable = Flowable.intervalRange(1, count, 3, 1, TimeUnit.SECONDS)
                            .observeOn(AndroidSchedulers.mainThread())
                            .doOnNext(new Consumer<Long>() {
                                @Override
                                public void accept(Long aLong) throws Exception {
                                    if (dialog != null) {
                                        dialog.dismiss();
                                        dialog = null;
                                    }
                                    int status = gpService.queryPrinterStatus(mPrinterIndex, 500);
                                    if (status == GpCom.STATE_NO_ERR) {
                                        sendReceipt();
                                    }
                                }
                            })
                            .subscribe();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendReceipt() {
        if ("0".equals(bean.getIsSelfLifting())) {
            deliver_type = "送货上门";
            count = Integer.parseInt(SPUtils.getInstance().getString(Global.PRINT_SONGHUO_NUM, "1"));
        } else if ("1".equals(bean.getIsSelfLifting())) {
            deliver_type = "到店自提";
            count = Integer.parseInt(SPUtils.getInstance().getString(Global.PRINT_DAODIAN_NUM, "1"));
        }
        String orderSn = bean.getOrderSn();
        String isTransferOrder = bean.getIsTransferOrder();
        String sortOrder = bean.getSortOrder();
        String orderType = bean.getOrderType();
        String sellername = SPUtils.getInstance().getString(Global.SELLERNAME);
        String telephone = SPUtils.getInstance().getString(Global.TELEPHONE);
        String memberRemark = bean.getMemberRemark();
        String moneyProduct = bean.getMoneyProduct();
        String moneyDiscount = bean.getMoneyDiscount();
        String moneyLogistics = bean.getMoneyLogistics();
        String moneyOrder = bean.getMoneyOrder();
        String createTime = bean.getCreateTime();
        String bookTime = bean.getBookTime();
        String address = bean.getAddressAll() + bean.getAddressInfo();
        String name = bean.getName();
        String mobile = bean.getMobile();
        String adminRemark = bean.getAdminRemark();
        String sellerRemark = bean.getSellerRemark();
        List<OrdersBean.OrdersListBean.OrderProductListBean> orderProductList = bean.getOrderProductList();
        EscCommand esc = new EscCommand();
        esc.addPrintAndFeedLines((byte) 3);
        esc.addSelectJustification(EscCommand.JUSTIFICATION.CENTER);// 设置打印居中
        esc.addSelectPrintModes(EscCommand.FONT.FONTA, EscCommand.ENABLE.OFF, EscCommand.ENABLE.OFF, EscCommand.ENABLE.OFF, EscCommand.ENABLE.OFF);// 设置为倍高倍宽
        esc.addText("\n", "GB2312"); // 打印文字
        esc.addPrintAndLineFeed();
        int printOrderCount = SPUtils.getInstance().getInt(Global.PRINTORDERCOUNT + orderSn, 0);
        printOrderCount++;
        SPUtils.getInstance().put(Global.PRINTORDERCOUNT + orderSn, printOrderCount);
        /* 打印文字 */
        if (printOrderCount > 0) {
            esc.addText("****** 重打小票 ******" + "\n\n", "GB2312");
            esc.addText("****** 第" + printOrderCount + "次重新打印 ******" + "\n\n", "GB2312");
        }
        esc.addSelectPrintModes(EscCommand.FONT.FONTA, EscCommand.ENABLE.OFF, EscCommand.ENABLE.ON, EscCommand.ENABLE.ON, EscCommand.ENABLE.OFF);
        esc.addSelectJustification(EscCommand.JUSTIFICATION.LEFT);// 设置打印左对齐
        String text = "";
        if (StringUtils.isEmpty(isTransferOrder) && isTransferOrder.equals("1")) {
            text = "ZD_";
        } else if (orderType.equals("1")) {
            text = "PT_";
        } else if (orderType.equals("2")) {
            text = "YS_";
        } else if (orderType.equals("3")) {
            text = "TG_";
        }
        esc.addText(text + sortOrder + "\n\n", "GB2312");
        esc.addSelectPrintModes(EscCommand.FONT.FONTA, EscCommand.ENABLE.OFF, EscCommand.ENABLE.OFF, EscCommand.ENABLE.OFF,
                EscCommand.ENABLE.OFF);// 取消倍高倍宽
        esc.addText("------------------------------\r\n"); // 打印结束
        esc.addSelectJustification(EscCommand.JUSTIFICATION.CENTER);// 设置打印居中
        esc.addText(sellername + "\n", "GB2312");
        esc.addSelectJustification(EscCommand.JUSTIFICATION.LEFT);// 设置打印左对齐
        esc.addText("------------------------------\r\n"); // 打印结束
        esc.addSelectPrintModes(EscCommand.FONT.FONTA, EscCommand.ENABLE.OFF, EscCommand.ENABLE.ON, EscCommand.ENABLE.OFF,
                EscCommand.ENABLE.OFF);// 设置为倍高倍宽
        int ii = 0;
        if (StringUtils.isEmpty(memberRemark) && memberRemark.length() > 0) {
            esc.addText("客户留言：" + memberRemark + "\n", "GB2312");
            ii++;
        }
        esc.addSelectPrintModes(EscCommand.FONT.FONTA, EscCommand.ENABLE.OFF, EscCommand.ENABLE.OFF, EscCommand.ENABLE.OFF, EscCommand.ENABLE.OFF);// 取消倍高倍宽
        if (ii > 0) {
            esc.addText("------------------------------\r\n"); // 打印结束
        }
        esc.addText("商品名称            数量  金额\n\n", "GB2312"); // 打印文字
        int number = 0;
        for (int j = 0; j < orderProductList.size(); j++) {
            number += Integer.valueOf(orderProductList.get(j).getNumber());
            String goodName = orderProductList.get(j).getProductName() + "" + orderProductList.get(j).getSpecInfo();
            String goodCount = orderProductList.get(j).getNumber();
            double goodPrice1 = Double.valueOf(orderProductList.get(j).getMoneyPrice()) * Integer.valueOf(orderProductList.get(j).getNumber());
            String goodPrice = String.format("%.2f", goodPrice1);
            int length_name = goodName.length();
            if (length_name <= 2) {
                esc.addText(goodName + "                  " + goodCount + "   " + goodPrice + "\n", "GB2312");
            } else if (length_name == 3) {
                esc.addText(goodName + "                " + goodCount + "   " + goodPrice + "\n", "GB2312");
            } else if (length_name == 4) {
                esc.addText(goodName + "              " + goodCount + "   " + goodPrice + "\n", "GB2312");
            } else if (length_name == 5) {
                esc.addText(goodName + "            " + goodCount + "   " + goodPrice + "\n", "GB2312");
            } else if (length_name == 6) {
                esc.addText(goodName + "          " + goodCount + "   " + goodPrice + "\n", "GB2312");
            } else if (length_name == 7) {
                esc.addText(goodName + "        " + goodCount + "   " + goodPrice + "\n", "GB2312");
            } else if (length_name == 8) {
                esc.addText(goodName + "      " + goodCount + "   " + goodPrice + "\n", "GB2312");
            } else if (length_name > 8) {
                esc.addText(goodName.substring(0, 8) + "      " + goodCount + "   " + goodPrice + "\n", "GB2312");
                esc.addText(goodName.substring(8) + "\n", "GB2312");
            }
        }
        esc.addText("------------------------------\r\n");
        esc.addText("合计数量：              " + number + "\n", "GB2312"); // 打印文字
        esc.addText("商品金额：              " + moneyProduct + "\n", "GB2312");
        esc.addText("优惠金额：              " + moneyDiscount + "\n", "GB2312");
        esc.addText("本次运费：              " + moneyLogistics + "\r\n", "GB2312");
        esc.addSelectPrintModes(EscCommand.FONT.FONTA, EscCommand.ENABLE.OFF, EscCommand.ENABLE.ON, EscCommand.ENABLE.OFF, EscCommand.ENABLE.OFF);// 设置为倍高倍宽
        esc.addText("              合计支付：" + moneyOrder + "\n\n", "GB2312");
        esc.addSelectPrintModes(EscCommand.FONT.FONTA, EscCommand.ENABLE.OFF, EscCommand.ENABLE.OFF, EscCommand.ENABLE.OFF, EscCommand.ENABLE.OFF);// 取消倍高倍宽
        esc.addText("订单编号：" + orderSn + "\n", "GB2312");
        esc.addText("下单时间：" + createTime + "\n", "GB2312");
        esc.addText("-------------------------------\r\n");
        esc.addSelectPrintModes(EscCommand.FONT.FONTA, EscCommand.ENABLE.OFF, EscCommand.ENABLE.ON, EscCommand.ENABLE.OFF, EscCommand.ENABLE.OFF);// 设置为倍高倍宽
        esc.addText("" + deliver_type + "\n", "GB2312");
        esc.addText("配送时间：" + bookTime + "\n\n", "GB2312");
        esc.addText("地址：" + address + "\n\n", "GB2312");
        esc.addText(name + "\n", "GB2312");
        esc.addText("" + mobile + "\n", "GB2312");
        esc.addSelectPrintModes(EscCommand.FONT.FONTA, EscCommand.ENABLE.OFF, EscCommand.ENABLE.OFF, EscCommand.ENABLE.OFF, EscCommand.ENABLE.OFF);// 取消倍高倍宽
        /* 打印文字 */
        esc.addSelectJustification(EscCommand.JUSTIFICATION.CENTER);// 设置打印左对齐
        esc.addText("\n", "GB2312"); // 打印文字
        esc.addText("---手机端哈哈镜便捷购订单!---\r\n", "GB2312");
        esc.addText("店内电话：" + telephone + " \r\n", "GB2312");
        esc.addSelectJustification(EscCommand.JUSTIFICATION.LEFT);
        esc.addSelectPrintModes(EscCommand.FONT.FONTA, EscCommand.ENABLE.OFF, EscCommand.ENABLE.ON, EscCommand.ENABLE.OFF, EscCommand.ENABLE.OFF);// 设置为倍高倍宽
        if (StringUtils.isEmpty(adminRemark) && adminRemark.length() > 0) {
            esc.addText("客服备注：" + adminRemark + "\n", "GB2312");
        }
        if (StringUtils.isEmpty(sellerRemark) && sellerRemark.length() > 0) {
            esc.addText("商家备注：" + sellerRemark + "\n", "GB2312");
        }
        // 打印结束
        esc.addPrintAndFeedLines((byte) 8);
        Vector<Byte> datas = esc.getCommand(); // 发送数据
        Byte[] Bytes = datas.toArray(new Byte[datas.size()]);
        byte[] bytes = toPrimitive(Bytes);
        String str = Base64.encodeToString(bytes, Base64.DEFAULT);
        int rel;
        try {
            rel = gpService.sendEscCommand(mPrinterIndex, str);
            GpCom.ERROR_CODE errorCode = GpCom.ERROR_CODE.values()[rel];
            if (errorCode != GpCom.ERROR_CODE.SUCCESS) {
                ToastUtils.showShort(GpCom.getErrorText(errorCode));
            }
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void printTestPageClicked(int i) {
        EscCommand esc = new EscCommand();
        esc.addPrintAndFeedLines((byte) 3);
        esc.addSelectJustification(EscCommand.JUSTIFICATION.CENTER);//设置打印居中
        esc.addSelectPrintModes(EscCommand.FONT.FONTA, EscCommand.ENABLE.OFF, EscCommand.ENABLE.ON, EscCommand.ENABLE.ON, EscCommand.ENABLE.OFF);//设置为倍高倍宽
        esc.addText("哈哈镜旗舰店\n", "GB2312");   //  打印文字
        esc.addPrintAndLineFeed();
        /*打印文字*/
        esc.addSelectPrintModes(EscCommand.FONT.FONTA, EscCommand.ENABLE.OFF, EscCommand.ENABLE.OFF, EscCommand.ENABLE.OFF, EscCommand.ENABLE.OFF);//取消倍高倍宽
        esc.addSelectJustification(EscCommand.JUSTIFICATION.LEFT);//设置打印左对齐
        esc.addText("店铺电话：4000175886\n", "GB2312");   //  打印文字
        esc.addText("订单编号：358730033396\n", "GB2312");   //  打印文字
        esc.addText("送货地址：湖北武汉市周黑鸭市场部\n", "GB2312");   //  打印文字
        esc.addText("配送方式：顺丰\n", "GB2312");   //  打印文字
        esc.addText("订单类型：线上订单\n", "GB2312");   //  打印文字
        esc.addText("客户电话：13429806567\n", "GB2312");   //  打印文字
        esc.addSelectJustification(EscCommand.JUSTIFICATION.CENTER);//设置打印左对齐
        esc.addText("---------------\r\n");   //  打印结束
        esc.addSelectJustification(EscCommand.JUSTIFICATION.LEFT);//设置打印左对齐
        esc.addText("商品   名称    口味    数量金额\n", "GB2312");   //  打印文字
        esc.addText("鸭脖       微辣       4  18.9\n", "GB2312");   //  打印文字
        esc.addText("鸭翅       微辣       4  18.9\n", "GB2312");   //  打印文字
        esc.addText("鸭爪       微辣       4  18.9\n", "GB2312");   //  打印文字
        esc.addText("---------------\r\n");   //  打印结束
        esc.addText("赠品：随机赠品  6\n", "GB2312");   //  打印文字
        esc.addText("合计：226.8\n", "GB2312");   //  打印文字
        /*打印文字*/
        esc.addSelectJustification(EscCommand.JUSTIFICATION.CENTER);//设置打印左对齐
        Vector<Byte> datas = esc.getCommand(); // 发送数据
        Byte[] Bytes = datas.toArray(new Byte[datas.size()]);
        byte[] bytes = toPrimitive(Bytes);
        String str = Base64.encodeToString(bytes, Base64.DEFAULT);
        int rel;
        try {
            rel = gpService.sendEscCommand(i, str);
            GpCom.ERROR_CODE r = GpCom.ERROR_CODE.values()[rel];
            if (r != GpCom.ERROR_CODE.SUCCESS) {
                ToastUtils.showShort(GpCom.getErrorText(r));
            }
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public byte[] toPrimitive(Byte[] array) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return new byte[0];
        } else {
            byte[] result = new byte[array.length];

            for (int i = 0; i < array.length; ++i) {
                result[i] = array[i];
            }

            return result;
        }
    }

    public String getPrinterStatusClicked(boolean isToast) {
        String str = "";
        int status = getPortStatus(false);
        if (status == GpCom.STATE_NO_ERR) {
            str = "打印机已连接";
        } else {
            str = "打印机 ";
            if ((byte) (status & GpCom.STATE_OFFLINE) > 0) {
                str += "未连接";
            }
            if ((byte) (status & GpCom.STATE_PAPER_ERR) > 0) {
                str += "缺纸";
            }
            if ((byte) (status & GpCom.STATE_COVER_OPEN) > 0) {
                str += "开盖";
            }
            if ((byte) (status & GpCom.STATE_ERR_OCCURS) > 0) {
                str += "出错";
            }
            if ((byte) (status & GpCom.STATE_TIMES_OUT) > 0) {
                str += "查询超时";
            }
        }
        if (isToast) {
            ToastUtils.showShort("打印机：" + mPrinterIndex + " 状态：" + str);
        }
        return str;
    }

    private void showDialog(String message) {
        dialog = DialogWrapper.
                tipDialog().
                context(context).
                title("提示").
                message(message).
                setProcessVisible(false).
                buttonType(DialogWrapper.BUTTON_GONE).
                closeImageVisible(false).
                cancelable(true, true).
                buttonClickListener(new DialogWrapper.TipTypeButtonClickListener() {
                    @Override
                    public void onLeftButtonClicked(TextView view) {
                        dialog.dismiss();
                    }

                    @Override
                    public void onSingleButtonClicked(TextView view) {
                        dialog.dismiss();

                    }

                    @Override
                    public void onRightButtonClicked(TextView view) {
                        dialog.dismiss();
                    }
                }).build();
        dialog.show();
    }
    public void connectOrDisConnectToDevice(int PrinterId, String address, String name,boolean isToast,ConnectState connectState) {
        this.connectState=connectState;
        int rel = 0;
        for (int i = 0; i < GpPrintService.MAX_PRINTER_CNT; i++) {
            PortParamDataBase database = new PortParamDataBase(context);
            mPortParam[i] = new PortParameters();
            mPortParam[i] = database.queryPortParamDataBase("" + i);
            mPortParam[i].setPortOpenState(mPortParam[i].getPortOpenState());
        }
        if (!mPortParam[PrinterId].getPortOpenState()) {
            if (!StringUtils.isEmpty(mPortParam[PrinterId].getBluetoothAddr())) {
                try {
                    MainActivity.btPrinter.gpService.closePort(PrinterId);
                    rel = MainActivity.btPrinter.gpService.openPort(PrinterId, 4, address, 0);
                    SPUtils.getInstance().put(Global.PRINTERID, PrinterId);
                    GpCom.ERROR_CODE error_code = GpCom.ERROR_CODE.values()[rel];
                    if (error_code != GpCom.ERROR_CODE.SUCCESS) {
                        if (error_code == GpCom.ERROR_CODE.DEVICE_ALREADY_OPEN) {
                            // 开启成功
                            mPortParam[PrinterId].setPortOpenState(true);
                        } else {
                            ToastUtils.showShort(GpCom.getErrorText(error_code));
                        }
                    } else {
                        connectState.getIsConnectSuccess(true);
                    }
                } catch (RemoteException e) {
                    connectState.getIsConnectSuccess(false);
                }
            } else {
                connectState.getIsConnectSuccess(false);
            }
        } else {
            connectState.getIsConnectSuccess(false);
        }
    }
}
