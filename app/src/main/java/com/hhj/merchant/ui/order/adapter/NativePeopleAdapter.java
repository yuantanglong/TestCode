package com.hhj.merchant.ui.order.adapter;

import android.widget.CheckBox;

import com.blankj.utilcode.util.StringUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hhj.merchant.R;
import com.hhj.merchant.bean.GetListBean;

/**
 * @ProjectName: TestCode
 * @Package: com.hhj.merchant.ui.order.adapter
 * @ClassName: DialogListAdapter
 * @Description: java类作用描述
 * @Author: yuantanglong
 * @CreateDate: 2019/5/16 19:52
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/5/16 19:52
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class NativePeopleAdapter extends BaseQuickAdapter<GetListBean.NativePeopleBean, BaseViewHolder> {

    public String id = "";
    public String type = "";
    public  int position=-1;

    public NativePeopleAdapter() {
        super(R.layout.item_dialog_list);
    }

    @Override
    protected void convert(final BaseViewHolder helper, final GetListBean.NativePeopleBean item) {
        final CheckBox checkBox = helper.getView(R.id.radioButton);
        if (position==helper.getAdapterPosition()){
            id = item.getId();
            type = item.getType();
            checkBox.setChecked(true);
        }else {
            checkBox.setChecked(false);
        }
        String name = "";
        String workOrderCount = "";
        if (!StringUtils.isEmpty(item.getWorkStatus())) {
            if ("1".equals(item.getWorkStatus())) {
                name = item.getName() + " (在店)   ";
            } else if ("2".equals(item.getWorkStatus())) {
                name = item.getName() + " (配送)    ";
            }
        } else {
            name = item.getName();
        }
        if (!StringUtils.isEmpty(item.getType()) && !"2".equals(item.getType())) {
            workOrderCount = "订单数:" + item.getWorkOrderCount();
            name += workOrderCount;
        }
        checkBox.setText(name);
    }
}
