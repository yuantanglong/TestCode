package com.hhj.merchant.jpush;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.RemoteViews;

import com.baseapp.common.utility.ActivityManager;
import com.baseapp.common.view.Global;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.google.gson.Gson;
import com.hhj.merchant.R;
import com.hhj.merchant.bean.JPushBean;
import com.hhj.merchant.ui.main.activity.MainActivity;
import com.hhj.merchant.ui.order.activity.OrderRefundActivity;
import com.hhj.merchant.ui.shop.activity.SellerMessageActivity;

import java.io.IOException;

import cn.jpush.android.api.JPushInterface;

/**
 * @ProjectName: TestCode
 * @Package: com.hhj.merchant.jpush
 * @ClassName: JPushReceiver
 * @Description: java类作用描述
 * @Author: yuantanglong
 * @CreateDate: 2019/5/23 16:36
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/5/23 16:36
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class JPushReceiver extends BroadcastReceiver {

    private Bundle bundle;
    private Gson mGson;
    public static final String TAG = "JPush";
    private MediaPlayer mp;
    private Uri no;
    private Uri uri;

    @Override
    public void onReceive(Context context, Intent intent) {
        bundle = intent.getExtras();
        // 获取普通通知 标题
        String title = bundle.getString(JPushInterface.EXTRA_NOTIFICATION_TITLE);
        // 获取普通通知 内容
        String content = bundle.getString(JPushInterface.EXTRA_ALERT);
        // 获取普通通知 extra 在这里根据 JPushInterface.EXTRA_EXTRA跳转到不同的Activity
        String extra = bundle.getString(JPushInterface.EXTRA_EXTRA);
        // 输出普通通知信息
        System.out.println("极光  1  Title : " + title + "  " + "Content : " + content + "---extra:" + extra);
        if (JPushInterface.ACTION_REGISTRATION_ID.equals(intent.getAction())) {
            String regId = bundle.getString(JPushInterface.EXTRA_REGISTRATION_ID);
            // 你的服务器发送的注册ID
            System.out.println("极光    ： 接收Registration Id : " + regId);
        } else if (JPushInterface.ACTION_MESSAGE_RECEIVED.equals(intent.getAction())) {
            System.out.println("极光  接收到推送下来的自定义消息 EXTRA_EXTRA: " + bundle.getString(JPushInterface.EXTRA_EXTRA));
            System.out.println("极光  ：接收到推送下来的自定义消息: " + bundle.getString(JPushInterface.EXTRA_MESSAGE));
            System.out.println("极光  ：接收到推送下来的自定义消息id: " + bundle.getString(JPushInterface.EXTRA_MSG_ID));
            String uri = "android.resource://" + context.getPackageName() + "/" + R.raw.mp3;
            sendNotificationByMessage(context, bundle, uri);
        } else if (JPushInterface.ACTION_NOTIFICATION_RECEIVED.equals(intent.getAction())) {
            // 有推送信息啦
            mGson = new Gson();
            JPushBean mMessage = mGson.fromJson(bundle.getString(JPushInterface.EXTRA_EXTRA), JPushBean.class);
            playSound(context, mMessage.getType());
        } else if (JPushInterface.ACTION_NOTIFICATION_OPENED.equals(intent.getAction())) {
            analysisBundle(context, bundle);
        }
    }

    private void sendNotificationByMessage(Context context, Bundle bundle, String raw) {
        String extra_message = bundle.getString(JPushInterface.EXTRA_MESSAGE);
        Gson mGson = new Gson();
        JPushBean mMessage = mGson.fromJson(bundle.getString(JPushInterface.EXTRA_EXTRA), JPushBean.class);
        boolean showNotificate = true; //是否应当发送通知
        RemoteViews mRemoteViews = new RemoteViews(context.getPackageName(), R.layout.notification);
        mRemoteViews.setTextViewText(R.id.content, extra_message);
        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if (showNotificate) {
            int mCurrentNotificationId = SPUtils.getInstance().getInt(Global.NOTIFICATION_COUNT, 0);
            SPUtils.getInstance().put(Global.NOTIFICATION_COUNT, mCurrentNotificationId + 1);
            if (Build.VERSION.SDK_INT >= 26) { //Android 8.0
                LogUtils.e(TAG + "Android8.0");
                NotificationChannel channel = new NotificationChannel("notification_channel", "CoolBit", NotificationManager.IMPORTANCE_HIGH);
                if (null != raw) {
                    if (6 == mMessage.getType()) {
                        Uri uri = RingtoneManager.getActualDefaultRingtoneUri(context,
                                RingtoneManager.TYPE_NOTIFICATION);
                        RingtoneManager.getRingtone(context, uri).getTitle(context);// 获取名字
                        channel.setSound(uri, Notification.AUDIO_ATTRIBUTES_DEFAULT);
                    } else {
                        channel.setSound(Uri.parse("android.resource://" + context.getPackageName() + "/" + R.raw.mp3), Notification.AUDIO_ATTRIBUTES_DEFAULT);
                    }
                    channel.enableLights(true);
                }

                mNotificationManager.createNotificationChannel(channel);
                Notification.Builder mBuilder = new Notification.
                        Builder(context, "notification_channel")
                        .setContentTitle("哈哈镜来订单啦")
                        .setContentText(extra_message)
                        .setSmallIcon(R.mipmap.hhj)
                        .setAutoCancel(true)
                        .setCustomContentView(mRemoteViews);
                mNotificationManager.notify(mCurrentNotificationId, mBuilder.build());
            } else {
                LogUtils.e(TAG + "小于Android8.0");
                NotificationCompat.Builder mNotificationBuilder = new NotificationCompat.Builder(context, "1");
                mNotificationBuilder.
                        setAutoCancel(true).
                        setSmallIcon(R.mipmap.hhj).
                        setContentTitle("哈哈镜来订单啦").
                        setContentText(extra_message).
                        setContent(mRemoteViews);
                if (null != raw) {
                    if (6 == mMessage.getType()) {
                        Uri uri = RingtoneManager.getActualDefaultRingtoneUri(context,
                                RingtoneManager.TYPE_NOTIFICATION);
                        RingtoneManager.getRingtone(context, uri).getTitle(context);// 获取名字
                        mNotificationBuilder.setSound(uri);
                    } else {
                        mNotificationBuilder.setSound(Uri.parse("android.resource://"
                                + context.getPackageName() + "/" + R.raw.mp3));
                    }
                }
                mNotificationManager.notify(mCurrentNotificationId, mNotificationBuilder.build());
            }
        }
    }
    private void analysisBundle(Context context, Bundle bundle) {
        Gson mGson = new Gson();
        JPushBean mMessage = mGson.fromJson(bundle.getString(JPushInterface.EXTRA_EXTRA), JPushBean.class);
        Intent mIntent = null;
        switch (mMessage.getType()) {
            case 1://消息
                mIntent = new Intent(context, SellerMessageActivity.class);
                mIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                break;
            case 2: //订单
                mIntent = new Intent(context, MainActivity.class);
                mIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                break;
            case 6: //退款
                mIntent = new Intent(context, OrderRefundActivity.class);
                mIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                break;
        }
        Intent[] intents = new Intent[2];
        Intent intent1 = new Intent(context, MainActivity.class);
        intents[0] = intent1;
        intents[1] = mIntent;
        if (null!=mIntent){
            boolean existMainActivity = ActivityManager.getInstance().isExistMainActivity(context, MainActivity.class);
            if (!existMainActivity) {
                PendingIntent mPendingIntent = PendingIntent.getActivities(context, 0, intents, 0);
                try {
                    mPendingIntent.send();
                } catch (PendingIntent.CanceledException e) {
                    e.printStackTrace();
                }
            } else {
                context.startActivity(mIntent);
            }
        }
    }
    public void playSound(Context context, int type) {
        try {
            mp = new MediaPlayer();
            String raw = "android.resource://" + context.getPackageName() + "/" + R.raw.mp3;
            switch (type) {
                case 1:
                    raw = "android.resource://" + context.getPackageName() + "/" + R.raw.mp3;
                    break;
                case 2:
                    raw = "android.resource://" + context.getPackageName() + "/" + R.raw.shsm;
                    break;
                case 3:
                    raw = "android.resource://" + context.getPackageName() + "/" + R.raw.ddzt;
                    break;
                case 4:
                    raw = "android.resource://" + context.getPackageName() + "/" + R.raw.mtps;
                    break;
                case 5:
                    raw = "android.resource://" + context.getPackageName() + "/" + R.raw.tixing;
                    break;
                case 6:
                    raw = "android.resource://" + context.getPackageName() + "/" + R.raw.refund;
                    break;
            }
            uri = Uri.parse(raw);
            mp = MediaPlayer.create(context, uri);
            mp.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (SPUtils.getInstance().getBoolean(Global.OPEN_VIBRATE, false)) {
            vibrate(context, 2000);
        }
    }

    public void vibrate(Context context, long milliseconds) {
        Vibrator vib = (Vibrator) context.getSystemService(Service.VIBRATOR_SERVICE);
        vib.vibrate(milliseconds);
    }
}
