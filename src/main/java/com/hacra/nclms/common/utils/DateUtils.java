package com.hacra.nclms.common.utils;

import org.apache.commons.lang.time.DateFormatUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 *
 * @author Hacra
 * @version 1.0
 * @date 2019-03-02 17:15
 */
public class DateUtils extends org.apache.commons.lang.time.DateUtils {

    /**
     * 获取当前日期
     * @author Hacra
     * @date 2019-03-02 17:18
     * @return java.util.Date
     **/
    public static Date newDate() {
        return new Date();
    }

    /**
     * 获取指定格式的日期
     * @author Hacra
     * @date 2019-03-02 17:53
     * @param pattern 格式化字符串
     * @return java.util.Date
     **/
    public static Date newDate(String pattern) {
        return parseDate(getDate(pattern), pattern);
    }

    /**
     * 获取指定格式的日期字符串
     * @author Hacra
     * @date 2019-03-02 17:51
     * @param pattern 格式化字符串
     * @return java.lang.String
     **/
    public static String getDate(String pattern) {
        return DateFormatUtils.format(newDate(), pattern);
    }

    /**
     * 字符串转日期
     * @author Hacra
     * @date 2019-03-02 17:48
     * @param date 日期字符串
     * @param pattern 格式化字符串
     * @return java.util.Date
     **/
    public static Date parseDate(String date, String pattern) {
        DateFormat format = new SimpleDateFormat(pattern);
        try {
            return format.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }
}
