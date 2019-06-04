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
     * 将日期转为字符串
     * @author Hacra
     * @date 2019-03-09 21:42
     * @param date 日期
     * @return java.lang.String
     */
    public static String formatDate(Date date) {
        return formatDate(date, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 将日期按照指定格式转为字符串
     * @author Hacra
     * @date 2019-03-09 21:44
     * @param date 日期
     * @param pattern 格式化字符串
     * @return java.lang.String
     */
    public static String formatDate(Date date, String pattern) {
        if (date == null) {
            return null;
        }
        DateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }
}
