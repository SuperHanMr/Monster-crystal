package com.itheima.monstercrystal.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by hanyonghui on 2017/6/5.
 */

public class SPUtils {
    private static SharedPreferences mSharedPreferences;
    private static Context context;


    public SPUtils(Context context){
        this.context = context;
    }

    private static synchronized SharedPreferences getPreferneces() {
        if (mSharedPreferences == null) {
            // mSharedPreferences = App.context.getSharedPreferences(
            // PREFERENCE_NAME, Context.MODE_PRIVATE);
            mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        }
        return mSharedPreferences;
    }

    public static void putString(String key, String value) {
        getPreferneces().edit().putString(key, value).commit();
    }

    /**
     * 读取字符串
     *
     * @param key
     * @return
     */
    public static String getString(String key) {
        return getPreferneces().getString(key, null);

    }
}
