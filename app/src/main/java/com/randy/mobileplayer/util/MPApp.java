package com.randy.mobileplayer.util;

import android.app.Application;

/**
 * Author: randy(dddrandy@gmail.com)
 * Date: 2017/2/13
 * Time: 14:14
 * Description: TODO
 */

public class MPApp extends Application {

    private static MPApp mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        if (mInstance == null) {
            mInstance = this;
        }
    }

    /**
     * get application context
     *
     * @return context instance
     */
    public static MPApp getInstance() {
        return mInstance;
    }
}
