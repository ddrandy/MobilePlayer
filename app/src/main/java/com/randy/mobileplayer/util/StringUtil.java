package com.randy.mobileplayer.util;

import java.util.Locale;

/**
 * Author: randy(dddrandy@gmail.com)
 * Date: 2017/2/15
 * Time: 20:58
 * Description: string util .. parse duration
 */

public class StringUtil {
    private static final int HOUR = 60 * 60 * 1000;
    private static final int MINUTE = 60 * 1000;
    private static final int SECOND = 1000;

    public static String parseDuration(long duration) {
        int hour = ((int) (duration / HOUR));
        int minute = (int) (duration % HOUR / MINUTE);
        int second = (int) (duration % MINUTE / SECOND);
        if (0 == hour) {
            return String.format(Locale.US, "%2d:%2d", minute, second);
        } else {
            return String.format(Locale.US, "%2d:%2d:%2d", hour, minute, second);
        }
    }
}
