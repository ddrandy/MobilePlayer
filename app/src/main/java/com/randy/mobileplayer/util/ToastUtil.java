package com.randy.mobileplayer.util;

import android.annotation.SuppressLint;
import android.widget.Toast;

/**
 * Author: randy(dddrandy@gmail.com)
 * Date: 2017/2/13
 * Time: 14:17
 * Description: toast util class
 */

public class ToastUtil {

    private static Toast toast;

    public static void showS(String string) {
        getToast(string, Toast.LENGTH_SHORT).show();
    }

    public static void showL(String string) {
        getToast(string, Toast.LENGTH_LONG).show();
    }

    @SuppressLint("ShowToast")
    private static Toast getToast(String string, int duration) {
        if (toast == null) {
            toast = Toast.makeText(MPApp.getInstance(), string, duration);
        } else {
            toast.setText(string);
        }
        return toast;
    }
}
