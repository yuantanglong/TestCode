package com.baseapp.common.base.config;

/**
 * Created by Administrator on 2018/2/2 0002.
 *
 * @Desc 配置基类
 */

public class BaseConfig {

    //RxBinding点击事件间隔
    public static final int BUTTON_CLICK_INTERVAL = 1000;

    public static final int SINGLE_ITEM_TYPE = 0;

    /**
     * 默认每页加载数据条数
     */
    public static final int DEFAULT_PAGE_SIZE = 20;

    public static final String STATUS_BAR_HEIGHT = "StatusBarHeight";

    public static final String AES_PASSWORD = "哈哈镜商户";

    public static class RebackConfig {
        /**
         * 是否启用重新回到app时，检查停留时间功能
         * */
        public static boolean ENABLE_CHECK_REBACK_STATE = true;
        /**
         * <p>如果启用了ENABLE_CHECK_REBACK_STATE，那么符合条件时跳转到此activity<p/>
         * <p>此字段是存储要跳转到的activity1<p/>
         * <p>如果是空，则不会跳转<p/>
         * <p>请查看这个方法的判断条件动态修改，并配合APP_IS_NEED_TO_VERIFY_WHEN_RESTART_NEXT使用<p/>
         * @see com.baseapp.common.base.ui.BaseActivity#setBackgroundSPState(long)
         * */
        public static String REBACK_AND_JUMP_TO_SPECIAL_ACTIVITY_1 = "REBACK_AND_JUMP_TO_SPECIAL_ACTIVITY_1";
        /**
         * <p>如果启用了ENABLE_CHECK_REBACK_STATE，那么符合条件时跳转到此activity<p/>
         * <p>如果是空，则不会跳转<p/>
         * <p>请查看这个方法的判断条件动态修改，并配合APP_IS_NEED_TO_VERIFY_WHEN_RESTART_NEXT使用<p/>
         * @see com.baseapp.common.base.ui.BaseActivity#setBackgroundSPState(long)
         * */
        public static String REBACK_AND_JUMP_TO_SPECIAL_ACTIVITY_2 = "REBACK_AND_JUMP_TO_SPECIAL_ACTIVITY_2";
        /**
         * <p>停留后台最大时间<p/>
         * 默认3小时
         * */
        public static int REBACK_MAX_TIME = 10800000;
        /**
         * <p>停留后台最小时间<p/>
         * 默认5分钟
         * */
        public static int REBACK_MIN_TIME = 300000;
        /**
         * <p>是否需要去验证当下次重新打开的时候，其他页面只需获取value并判断即可。<p/>
         * <p style='color:#ff5640'>当进入到每个BaseActivity时，除了特定几个Activity，每次都需要在BaseActivity#onResume里去判断是否验证手势或者登录。<p/>
         * <p>例如：当进入到后台时，key对应的value为0，则需要在下次BaseActivity的onResume里打开手势页面，并手势验证完后置为-1。<p/>
         * <p>value == -1,0,1<p/>
         * <p>-1: 不需要启动时验证<p/>
         * <p>0: 启动手势验证<p/>
         * <p>1: 启动登录验证<p/>
         */
        public static final String APP_IS_NEED_TO_VERIFY_WHEN_RESTART_NEXT = "APP_IS_NEED_TO_VERIFY_WHEN_RESTART_NEXT";
        /**
         * 判断阿里聚安全是否验证成功
         * <h4>此字段判断优先级高于APP_IS_NEED_TO_VERIFY_WHEN_RESTART_NEXT<h4/>
         * <p>value:0,1<p/>
         * <p>0: 未验证成功<p/>
         * <p>1: 已验证<p/>
         */
        public static final String APP_IS_NEED_TO_VERIFY_WHEN_LOAD_ALI_SAFE_MODULE = "APP_IS_NEED_TO_VERIFY_WHEN_LOAD_ALI_SAFE_MODULE";
        /**
         * app进入后台时保存当时时间
         * */
        public static final String APP_TO_BACKGROUND_TIME = "APP_TO_BACKGROUND_TIME";
    }

    /**
     * <p style color='#ff461f'>请注意是否需要在退出时或者初始化时置位如下字段!<p/>
     * SharePreference的key
     */
    public static class BaseSPKey {
        /**
         * 用户token
         */
        public static final String TOKEN = "token";
        /**
         * 用户的userNo
         */
        public static final String USER_NO = "userNo";
        /**
         * 是否设置手势密码。1是0否
         */
        public static final String USER_GESTURE_BIND_STATE = "userGestureBindState";
        /**
         * 手势密码开关状态。1是0否
         */
        public static final String USER_GESTURE_STATE = "userGestureState";
        /**
         * 是否设置资金密码。1是0否
         */
        public static final String USER_FINANCE_PASSWORD_BIND_STATE = "userFinancePasswordBindState";


    }
}
