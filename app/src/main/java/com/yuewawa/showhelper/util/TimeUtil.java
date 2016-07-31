package com.yuewawa.showhelper.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yuewawa on 2016-07-31.
 */
public class TimeUtil {

    // 七天时间毫秒数
    public static final long SEVEN_DAYS_MILLIS = 7 * 24 * 60 * 60 * 1000;
    // 1天时间毫秒数
    public static final long ONE_DAY_MILLIS = 24 * 60 * 60 * 1000;

    /**
     * 获得当前时间
     * @param pattern 时间格式
     * @return
     * */
    public static String getCurrentTime(String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String currentTime = sdf.format(new Date());
        return currentTime;
    }

    /**
     * 获取今天是星期几
     * @return
     * */
    public static String getCurrentWeek() {
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        String currentWeek = sdf.format(new Date());
        return currentWeek;
    }

    /**
     * 毫秒转日期
     *
     * @param mills
     *            毫秒数
     * @param pattern
     *            日期格式
     * @return 返回日期
     * */
    public static String millsToDate(long mills, String pattern) {
        String dateStr = "";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date date = new Date(mills);
        dateStr = sdf.format(date);
        return dateStr;
    }

    /**
     * 日期转毫秒
     *
     * @param dateStr
     *            日期字符串
     * @param pattern
     *            日期格式
     * @return 返回毫秒数
     * */
    public static long dateToMillis(String dateStr, String pattern) {
        long millis = 0;
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = sdf.parse(dateStr);
            millis = date.getTime();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return millis;
    }

    /**
     * 获取7天后的日期
     * @param date
     * @param pattern
     * @return 返回7天后的日期
     * */
    public static String getSevenDaysLater(String date, String pattern){
        long mills = dateToMillis(date, "yyyy-MM-dd HH:mm");
        long sevenDays = mills + SEVEN_DAYS_MILLIS;
        String sevenDaysLater = millsToDate(sevenDays, pattern);
        return sevenDaysLater;
    }

    /**
     * 获取1天前的日期
     * @param date 当前时间的毫秒数
     * @param pattern 日期格式
     * @return 返回1天前的日期
     * */
    public static String getOneDayAgo(String date, String pattern) {
        long mills = dateToMillis(date, "yyyy-MM-dd HH:mm");
        long oneDay = mills - ONE_DAY_MILLIS;
        String oneDayAgo = millsToDate(oneDay, pattern);
        return oneDayAgo;
    }
}
