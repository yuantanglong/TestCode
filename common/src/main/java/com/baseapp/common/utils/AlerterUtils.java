package com.baseapp.common.utils;

import android.app.Activity;
import android.app.Dialog;

import com.baseapp.common.R;
import com.baseapp.common.alerter.Alerter;
import com.baseapp.common.alerter.OnHideAlertListener;
import com.blankj.utilcode.util.NetworkUtils;

/**
 * @company: 哈哈镜商户
 * created by {Android-Dev02} on 2018/4/8 19:51
 * @desc:
 */
public class AlerterUtils {
    public static void showSuccessAlerter(Activity activity) {
        showSuccessAlerter(activity, null);
    }

    public static void showSuccessAlerter(Activity activity, String title, OnHideAlertListener listener) {
        if (activity == null) {
            throw new IllegalStateException("Activity is null! please check it.");
        } else {
            if (title == null) {
                title = activity.getResources().getString(R.string.state_success);
            }
            Alerter.create(activity)
                    .setTitle(title)
                    .setBackgroundColorRes(R.color.color_09b25f)
                    .setIcon(R.drawable.icon_done)
                    .enableSwipeToDismiss()
                    .setDuration(1000)
                    .setOnHideListener(listener)
                    .show();
        }
    }

    public static void showSuccessAlerter(Activity activity, String title) {
        if (activity == null) {
            throw new IllegalStateException("Activity is null! please check it.");
        } else {
            if (title == null) {
                title = activity.getResources().getString(R.string.state_success);
            }
            Alerter.create(activity)
                    .setTitle(title)
                    .setBackgroundColorRes(R.color.color_09b25f)
                    .setIcon(R.drawable.icon_done)
                    .enableSwipeToDismiss()
                    .setDuration(1000)
                    .show();
        }
    }

    public static void showSuccessAlerter(Dialog dialog, String title) {
        if (dialog == null) {
            throw new IllegalStateException("dialog is null! please check it.");
        } else {
            if (title == null) {
                title = dialog.getContext().getString(R.string.state_success);
            }
            Alerter.create(dialog)
                    .setTitle(title)
                    .setBackgroundColorInt(UIUtils.getColor(R.color.color_09b25f))
                    .setIcon(R.drawable.icon_done)
                    .setDuration(1000)
                    .show();
        }
    }

    public static void showErrorAlerter(Activity activity) {
        showErrorAlerter(activity, null);
    }

    public static void showErrorAlerter(Activity activity, String title) {
        if ("9107".equals(title)) {
            return;
        }
        if (activity == null) {
            throw new IllegalStateException("Activity is null! please check it.");
        } else {
            if (title == null) {
                title = activity.getResources().getString(R.string.state_failed);
            }
            Alerter.create(activity)
                    .setTitle(title)
                    .setBackgroundColorRes(R.color.color_ff5640)
                    .setIcon(R.drawable.icon_alert)
                    .enableSwipeToDismiss()
                    .setDuration(1000)
                    .show();
        }

    }

    public static void showErrorAlerter(Activity activity, String title, OnHideAlertListener listener) {
        if (title == null) {
            title = activity.getResources().getString(R.string.state_failed);
        }
        Alerter.create(activity)
                .setTitle(title)
                .setBackgroundColorRes(R.color.color_ff5640)
                .setIcon(R.drawable.icon_alert)
                .enableSwipeToDismiss()
                .setDuration(1000)
                .setOnHideListener(listener)
                .show();
    }

    public static void showErrorAlerter(Dialog dialog, String title) {
        Alerter.create(dialog)
                .setTitle(title)
                .setBackgroundColorInt(UIUtils.getColor(R.color.color_ff5640))
                .setIcon(R.drawable.icon_alert)
                .enableSwipeToDismiss()
                .setDuration(1000)
                .show();
    }

    /**
     * @param activity
     * @return true：当前有网络   false：当前无网络
     */
    public static boolean showAlerterWhenNoNetwork(Activity activity) {

        boolean noNetwork = false;

        if (!NetworkUtils.isConnected()) {
            Alerter.create(activity)
                    .setTitle(UIUtils.getString(R.string.no_network_tip))
                    .setBackgroundColorRes(R.color.color_ff5640)
                    .setIcon(R.drawable.icon_alert)
                    .enableSwipeToDismiss()
                    .setDuration(1000)
                    .show();

            noNetwork = true;
        } else {
            noNetwork = false;
        }

        return noNetwork;

    }

    /**
     * @param dialog
     * @return true：当前有网络   false：当前无网络
     */
    public static boolean showAlerterWhenNoNetwork(Dialog dialog) {

        boolean noNetwork = false;

        if (!NetworkUtils.isConnected()) {
            Alerter.create(dialog)
                    .setTitle(UIUtils.getString(R.string.no_network_tip))
                    .setBackgroundColorInt(UIUtils.getColor(R.color.color_ff5640))
                    .setIcon(R.drawable.icon_alert)
                    .enableSwipeToDismiss()
                    .setDuration(1000)
                    .show();

            noNetwork = true;
        } else {
            noNetwork = false;
        }

        return noNetwork;

    }
}
