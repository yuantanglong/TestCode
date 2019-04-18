package com.baseapp.common.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.baseapp.common.base.BaseApplication;
import com.baseapp.common.utils.SecuritySharedPreference;

import java.util.Iterator;
import java.util.Map;


/**
 * 对SharedPreference文件中的各种类型的数据进行存取操作
 * @author Administrator
 */
public class EncryptSPUtils {

    private static SharedPreferences sp;

    private static void init(Context context) {
        if (sp == null) {
            sp = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getAppContext());
        }
    }

    private static void initSecuritySp() {
        if (sp == null) {
            sp = new SecuritySharedPreference(BaseApplication.getAppContext(), "yhyy_SecuritySharedPreference", Context.MODE_PRIVATE);
        }
    }

    public static void setSharedIntData(Context context, String key, int value) {
        if (sp == null) {
            init(context);
        }
        sp.edit().putInt(key, value).commit();
    }

    public static int getSharedIntData(Context context, String key) {
        if (sp == null) {
            init(context);
        }
        return sp.getInt(key, 0);
    }

    public static int getSharedIntData2(Context context, String key) {
        if (sp == null) {
            init(context);
        }
        return sp.getInt(key, 1);
    }

    public static void setSharedlongData(Context context, String key, long value) {
        if (sp == null) {
            init(context);
        }
        sp.edit().putLong(key, value).commit();
    }

    public static long getSharedlongData(Context context, String key) {
        if (sp == null) {
            init(context);
        }
        return sp.getLong(key, 0L);
    }

    public static void setSharedFloatData(Context context, String key,
                                          float value) {
        if (sp == null) {
            init(context);
        }
        sp.edit().putFloat(key, value).commit();
    }

    public static Float getSharedFloatData(Context context, String key) {
        if (sp == null) {
            init(context);
        }
        return sp.getFloat(key, 0f);
    }

    public static void setSharedBooleanData(Context context, String key,
                                            boolean value) {
        if (sp == null) {
            init(context);
        }
        sp.edit().putBoolean(key, value).commit();
    }

    public static Boolean getSharedBooleanData(Context context, String key) {
        if (sp == null) {
            init(context);
        }
        return sp.getBoolean(key, false);
    }

    public static void setSharedStringData(Context context, String key, String value) {
        if (sp == null) {
            init(context);
        }
        //单独对token 做加密处理
        if ("token".equals(key) || "userPhone".equals(key)) {
            sp.edit().putString(encryptPreference(key), encryptPreference(value)).commit();
        } else {
            sp.edit().putString(key, value).commit();
        }
    }

    public static String getSharedStringData(Context context, String key) {
        if (sp == null) {
            init(context);
        }
        if ("token".equals(key) || "userPhone".equals(key)) {
            String encryptValue = sp.getString(encryptPreference(key), null);
            return encryptValue == null ? "" : decryptPreference(encryptValue);
        }
        return sp.getString(key, "");
    }

    /**
     * 清除所有数据
     */
    public static void clear() {
        if (sp == null) {
            init(BaseApplication.getAppContext());
        }
        sp.edit().clear().commit();
    }

    /**
     * 处理加密过渡 遍历原先存储在sp的值 map形式，如果存在token则替换成加密形式，并把明文的token删掉
     */
    @Deprecated
    public static void isEncryption() {
        try {
            Map<String, ?> oldMap = sp.getAll();
            Iterator<? extends Map.Entry<String, ?>> iterator = oldMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, ?> next = iterator.next();
                if (next.getKey().equals("token")) {
                    String token = sp.getString("token", "");
                    setSharedStringData(BaseApplication.getAppContext(), "token", token);
                    sp.edit().remove("token").commit();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * encrypt function
     *
     * @return cipherText base64 加密
     */
    private static String encryptPreference(String plainText) {
        return EncryptUtil.getInstance(BaseApplication.getAppContext()).encrypt(plainText);
    }

    /**
     * decrypt function
     *
     * @return plainText 解密
     */
    private static String decryptPreference(String cipherText) {
        return EncryptUtil.getInstance(BaseApplication.getAppContext()).decrypt(cipherText);
    }


}
