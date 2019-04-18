package com.baseapp.common.view;

import com.baseapp.common.BuildConfig;

/**
 * @author Android-Dev04
 * @date 2018/4/14
 * description:全局常量类
 */

public class Global {
//-------------------------------------------app组------------------------------------------------------------
    /**
     * 前往WelcomeActivity
     */
    public static final String GO_WELCOME_ACTIVITY = "/app/WelcomeActivity";
    /**
     * 前往ManinActivity
     */
    public static final String GO_MAIN_ACTIVITY = "/app/MainActivity";
    /**
     * 前往用户设置实名认证的界面
     */
    public static final String GO_APP_USERINFO_ACTIVITY = "/app/UserInfoActivity";
    /**
     * 前往用户设置实名认证的界面
     */
    public static final String GO_APP_WEBCOMMON_ACTIVITY = "/app/WebCommonActivity";


//-------------------------------------------login组------------------------------------------------------------

    /**
     * 前往登录界面
     */
    public static final String GO_LOGIN_ACTIVITY = "/login/LoginActivity";

//-------------------------------------------servicecenter组------------------------------------------------------------
    /**
     * 前往服务中心
     */
    public static final String GO_SERVICECENTERACTIVITY = "/servicecenter/ServiceCenterActivity";
    /**
     * 前往周边服务中心
     */
    public static final String GO_SERVICECENTERAMBITUSACTIVITY = "/servicecenter/ServiceCenterAmbitusActivity";
    /**
     * 前往我的辅导店铺
     */
    public static final String GO_MYCOACHSHOPACTIVITY = "/userinfo/MyCoachShopActivity";
    /**
     * 前往会员升级
     */
    public static final String GO_MEMBERSHIPPROMOTIONACTIVITY = "/userinfo/MembershipPromotionActivity";
    public static final String GO_PAYPOPCHOOSEACTIVITY = "/assets/PayPopChooseActivity";
    public static final String GO_DETAILSMESSAGEACTIVITY = "/assets/DetailsMessageActivity";

//-------------------------------------------assets组------------------------------------------------------------
    /**
     * 前往资产
     */
    public static final String GO_ASSETSACTIVITY = "/assets/AssetsActivity";
    /**
     * 活转冻
     */
    public static final String GO_DRAINAGEGIVEPOINTS = "/assets/DrainageGivePointsActivity";

    /**
     * 前往钱包首页
     */
    public static final String GO_WALLETDETAIL_ACTIVITY = "/assets/WalletDetailActivity";
    /**
     * 前往复引设置
     */
    public static final String GO_RESETSETTING_ACTIVITY = "/assets/ResetsettingActivity";

    /**
     * 前往活积分转账
     */
    public static final String GO_VITALINTEGRALTRANSFERACCOUNTS_ACTIVITY = "/assets/VitalIntegralTransferAccountsActivity";
    /**
     * 前往冻积分转账
     */
    public static final String GO_TRANSFERFREEZEINTEGRAL_ACTIVITY = "/assets/TransferFreezeIntegralActivity";

    /**
     * 前往消息
     */
    public static final String GO_MESSAGELIST_ACTIVITY = "/assets/MessageListActivity";

    /**
     * 前往设置资金密码
     */
    public static final String GO_SAFETY_ACTIVITY = "/app/SafetyActivity";

//-------------------------------------------userinfo组------------------------------------------------------------
    /**
     * 前往个人信息
     */
    public static final String GO_USER_INFO_ACTIVITY = "/userinfo/UserinfoActivity";
    /**
     * 文件提供路径
     */
    public static final String FILEPROVIDER_PATH = "com.coolbit.wallet.servicecenter";
    /**
     * 服务中心申请协议
     */
    public static final String FUZHONGXIN_XIEYI = BuildConfig.HOST_SERVER + "/appAgreement?name=servcenter";
    /**
     * 前往身份证认证
     */
    public static final String GO_SECURITY_AUTH_ACTIVITY = "/userinfo/SecurityAuthActivity";
    /**
     * 前往用户输入实名认证信息的界面
     */
    public static final String GO_USERINFO_CERTIFICATION_ACTIVITY = "/userinfo/CertificationActivity";
    /**
     * 前往用户输入实名认证结果的界面
     */
    public static final String GO_USERINFO_CERTIFICATIONED_ACTIVITY = "/userinfo/CertificationedActivity";
    /**
     * 前往用户输入实名认证审核的界面
     */
    public static final String GO_USERINFO_CERTIFICATIONAUDIT_ACTIVITY = "/userinfo/CertificationAuditActivity";
    /**
     * 前往 活体检测前一个界面 LivingActivity
     */
    public static final String GO_USERINFO_LIVINGACTIVITY_ACTIVITY = "/userinfo/LivingActivity";
    /**
     * 前往 联网授权界面
     */
    public static final String GO_NETWORKING_AUTHORIZATION_ACTIVITY = "/userinfo/NetworkingAuthorizationActivity";


//-------------------------------------------公共常量区域---------------------------------------------

    /**
     * 验证码位数
     */
    public static final int CODE_SIZE = 6;
    /**
     * 图文验证码位数
     */
    public static final int IMAGE_TEXT_CODE_SIZE = 4;

    /**
     * 手机号位数
     */
    public static final int PHONE_NUMBER_SIZE = 11;
    /**
     * 手机号位数
     */
    public static final int PASS_WORD_MAX_SIZE = 16;
    /**
     * 手机号位数
     */
    public static final int PASSWORD_MIN_SIZE = 6;
    /**
     * 密码加此key进行MD5方可传入后台 用户密码以MD5之后的形式保存
     */
    public static final String APP_PW_KEY = "gYG32mRkvkUBTIdUXeNYExwIrvI7O5bTKGZ9R9XkiwMWp4xmlkPZfhrnVa40h9Rs2hO6T6Ik8dNLfRL2Jw8xUFDWhry2STBFSTdJMghwLhTnQGEkJQfXTJDndoCM0Xm819rfpNYTPImTFSVlmr7JUgsw1GzMkO9c2JtyLLpRpiF9K57mxL56ZQyKAJOPyzSrSbM7ebGSn8kDeGiTlAzCiBpDTUTwCw0K0PRrhYXdjfUmJQTgR70NX2CZfwEteVBzwril7evWPOOP2OH3kBZjwN8jppMB021HbbNvRZ6jMsHYkkVKXJSrG9RHKfKtZHCD6PJxkHPJARRtWQhMo2CM5g47P45jErMkCSkDkSWsPLlwI8tm2O5ws20YugaxK7Cy8d7MG3kMFdFm1mFcQ8JxGhAsVnPr325Nz3z0nljvjmCon0OAmgFfP25djA0G4kd9eukaNwvFCyPl7DN6DPksEoelS4v2UQclAxM3Qlrx2utdneFSuE59rczXW6OczByz";

    /**
     * 登录的usercode 系统编码
     */
    public static final String APP_USER_CODE_KEY = "usercode";
    /**
     * 登录的userid  系统编码
     */
    public static final String APP_USER_ID_KEY = "userid";

    /**
     * 登录的token   令牌
     */
    public static final String APP_TOKEN_KEY = "token";
    /**
     * 登录的temptoken  临时令牌 仅供注册登录时使用
     */
    public static final String APP_TEMP_TOKEN_KEY = "temptoken";
    /**
     * 登录的盐值
     */
    public static final String APP_SALT_KEY = "salt";

    /**
     * 外网ip key值
     */
    public static final String EXTRANET_IP = "extranetIp";
    /**
     * 设备id
     */
    public static final String DEVICE_ID = "deviceId";
    /**
     * uid
     */
    public static final String APP_UID_KEY = "uid";

    /**
     * 验证码类型：手机号快捷登录
     */
    public static final String SENDCODETOPHONE_PHONELOGIN = "1";
    /**
     * 验证码类型：找回密码
     */
    public static final String SENDCODETOPHONE_CHANGEPASSWORD = "2";
    /**
     * 辅导员编号
     */
    public static final String TEACHER_CODE = "teacher_code";

    /**
     * 验证码类型：绑定手机号
     */
    public static final String SENDCODETOPHONE_PHONEBANGDING = "4";
    /**
     * 验证码类型：注册
     */
    public static final String SENDCODETOPHONE_REGISTER = "5";
    /**
     * 验证码类型：身份认证
     */
    public static final String SENDCODETOPHONE_IDAUTHENTICATION = "6";
    public static String NEWRANK = "newRank";
    /**
     * 发起类型 （例如：余额充值，新增引流积分）
     */
    public static String LAUNCHTYPE = "launchtype";
    public static String MONEY = "money";
    /**
     * 会员升级
     */
    public static final String UPGRADE_TYPE = "18";
    public static String MEMBERUPGRADE_BUSINESSTYPE = "upgrade";
    /**
     * 活积分
     */
    public static String ACTIVESCORE = "activescore";
    /**
     * 冻积分
     */
    public static String FREEZESCORE = "freezescore";
    /**
     * 不可转冻积分
     */
    public static String NONROTATIONFREEZESCORE = "nonrotationfreezescore";
    /**
     * nickName 昵称
     */
    public static String APP_NICKNAME_KEY = "nickName";
    /**
     * userNo
     */
    public static String APP_USERNO_KEY = "userNo";
    /**
     * AVATER 头像
     */
    public static String APP_AVATER_KEY = "avater";
    /**
     * LEVEL 星级
     */
    public static String APP_LEVEL_KEY = "level";
    /**
     * FinancePassword 是否设置资金密码 0 否  1 是
     */
    public static String APP_FINANCEPASSWORD_KEY = "financepassword";
    /**
     * issc 是否是服务中心  0 否  1 是
     */
    public static String APP_ISSC_KEY = "issc";


    /**
     * URL_PROTOCOL 是否是服务中心  0 否  1 是
     */
    public static String URL_PROTOCOL = "URL_PROTOCOL";

    /**
     * URL_STATEMENT 是否是服务中心  0 否  1 是
     */
    public static String URL_STATEMENT = "URL_STATEMENT";

    /**
     * URL_NOTICE 是否是服务中心  0 否  1 是
     */
    public static String URL_NOTICE = "URL_NOTICE";
    /**
     * 辅导员编号
     * */
    public static String APP_INSTRUCTORNAME = "INSTRUCTORNAME";

}
