package com.randy.mobileplayer.util;

import android.util.Log;

/**
 * Author: randy(dddrandy@gmail.com)
 * Date: 2017/2/13
 * Time: 15:26
 * Description: TODO
 */

public class LogUtil {
    public static void logD(String tag, String msg) {
        if (Constants.DEBUG_MODE) {
            Log.d(tag, msg);
        }
    }
}
