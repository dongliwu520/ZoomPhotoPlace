package com.zoom.photoplace.carousellayout.util;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TimeUtils {
    private Calendar c;
    private SimpleDateFormat format;

    /**
     * 字符串日期转换为毫秒
     *
     * @param inVal
     * @return
     */
    @SuppressLint("SimpleDateFormat")
    public static long dateToMillisecond(String inVal) {
        Date date = null;
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            date = inputFormat.parse(inVal);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date.getTime();
    }

    /**
     * 字符串日期转换为毫秒
     *
     * @param inVal
     * @return
     */
    @SuppressLint("SimpleDateFormat")
    public static long palyDateToMillisecond(String inVal) {
        Date date = null;
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            date = inputFormat.parse(inVal);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date.getTime();
    }

    /**
     * 字符串日期转换为毫秒
     *
     * @param inVal
     * @return
     */
    @SuppressLint("SimpleDateFormat")
    public static long palyDateTosecond(String inVal) {
        Date date = null;
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
            date = inputFormat.parse(inVal);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date.getTime();
    }

    /**
     * 秒转为分钟
     *
     * @param time
     * @return
     */
    public static int secondsToMinutes(long time) {
        return (int) (time / 60);
    }

    /**
     * 秒转为小时
     *
     * @param time
     * @return
     */
    public static int secondsTohours(long time) {
        return (int) (time / 3600);
    }

    /**
     * 小时转为天
     *
     * @param time
     * @return
     */
    public static int hoursTodays(long time) {
        return (int) (time / 24);
    }

    /**
     * 三天时间
     *
     * @param
     * @return
     */
    public static long getThreeDays() {
        long times = 3 * 24 * 60 * 60 * 1000;
        return times;
    }


    public static String longTimeToDate(long inVal) {
        Date date = new Date(inVal);
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
        return inputFormat.format(date);
    }

    /**
     * 剩余时间
     *
     * @param time
     */
    public static String getCountDownTime(long time) {
        int day = (int) (time / 1000 / 60 / 60 / 24);
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");// 初始化formatter的转换格式
        formatter.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
        String hms = formatter.format(time);
        String[] str = hms.split(":");
        StringBuilder stringBuilder = new StringBuilder();

        if (day > 0) {
            int totalHour;
            day = day * 24;
            int hour = Integer.parseInt(str[0]);
            totalHour = day + hour;
            stringBuilder.append(totalHour).append("小时").append(str[1]).append("分").append(str[2]).append("秒");
        } else {
            stringBuilder.append(str[0]).append("小时").append(str[1]).append("分").append(str[2]).append("秒");
        }

        return stringBuilder.toString();
    }

    /**
     * 剩余时间
     *
     * @param time
     */
    public static String longTime2String(long time) {
        time= time/1000;
        int day = (int) (time / 60 / 60 / 24);
        long hourTime = time - (day * 24 * 60 * 60 );
        int hourCount = (int) (hourTime / ( 60 * 60));
        long minuteTime = hourTime - (hourCount * 60 * 60);
        int minuteCount = (int) (minuteTime / 60);
        int secondCount =(int) (minuteTime - minuteCount * 60);
//        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");// 初始化formatter的转换格式
//        formatter.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
//        String hms = formatter.format(time);
//        String[] str = hms.split(":");
        StringBuilder stringBuilder = new StringBuilder();

        if (day > 0 || hourCount > 0) {
            int totalHour;
            day = day * 24;
//            int hour = Integer.parseInt(str[0]);
            totalHour = day + hourCount;
            stringBuilder.append(totalHour).append("小时").append(minuteCount).append("分").append(secondCount).append("秒");
        } else if (minuteCount > 0) {
            stringBuilder.append/*(str[0]).append("小时").append*/(minuteCount).append("分").append(secondCount).append("秒");
        } else if (secondCount > 0) {
            stringBuilder.append(secondCount).append("秒");
        }

        return stringBuilder.toString();
    }


    /**
     * 判断当前日期是星期几
     *
     * @param
     * @return dayForWeek 判断结果
     * @Exception 发生异常
     */

    // String pDate = "2012-03-12";
    public static String getWeek(String pTime) {

        String Week = "周";

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(format.parse(pTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 1) {
            Week += "日";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 2) {
            Week += "一";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 3) {
            Week += "二";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 4) {
            Week += "三";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 5) {
            Week += "四";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 6) {
            Week += "五";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 7) {
            Week += "六";
        }

        return Week;
    }

    //获得当前月份 必须2016-04-06
    public static String getFilmMonth(String time) {
        String[] times = time.split("-");
        if (times.length == 3) {
            if (times[1].startsWith("0")) {
                return times[1].substring(1);
            }
            return times[1];
        }
        return "";
    }

    //获得当前月份 必须2016-04-06
    public static String getFilmDay(String time) {
        String[] times = time.split("-");
        if (times.length == 3) {
            if (times[2].startsWith("0")) {
                return times[2].substring(1);
            }
            return times[2];
        }
        return "";
    }

    //计算两个日期的时间差
    public static int daysBetween(String small, String big) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date smdate = sdf.parse(small);
        Date bdate = sdf.parse(big);
        smdate = sdf.parse(sdf.format(smdate));
        bdate = sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);
        return Integer.parseInt(String.valueOf(between_days));
    }

    // 必须传2016-01-06 14:30 返回 这样的格式 1月6日  周日  14:30
    public static String getFilmOrderDetailTime(String detail_time) {
        if (detail_time.contains(" ")) {
            String time = detail_time.replace(" ", "#");
            String[] times = time.split("#");
            if (times.length == 2) {
                String month = TimeUtils.getFilmMonth(times[0]);
                String day = TimeUtils.getFilmDay(times[0]);
                String week = TimeUtils.getWeek(times[0]);
                String showtime = month + "月" + day + "日" + "  " + week + "  " + times[1];
                return showtime;
            }
        }
        return detail_time;
    }

    // 必须传2016-01-06 14:30 返回 这样的格式 1月6日   14:30
    public static String getXfXqTime(String detail_time) {
        if (detail_time.contains(" ")) {
            String time = detail_time.replace(" ", "#");
            String[] times = time.split("#");
            if (times.length == 2) {
                String month = TimeUtils.getFilmMonth(times[0]);
                String day = TimeUtils.getFilmDay(times[0]);
//				String week=TimeUtils.getWeek(times[0]);
                String showtime = month + "月" + day + "日" + "  " + times[1];
                if (times[1].contains(":")) {
                    String[] minute = times[1].split(":");
                    if (minute.length == 3) {
                        showtime = month + "月" + day + "日" + "  " + minute[0] + ":" + minute[1];
                        return showtime;
                    }
                }
                return showtime;
            }
        }
        return detail_time;
    }

    // 必须传2016-01-06 14:30:00 返回 这样的格式 2016-01-06 00:00:00
    public static String getXfXqLingChengTime(String detail_time) {
        if (detail_time.contains(" ")) {
            String time = detail_time.replace(" ", "#");
            String[] times = time.split("#");
            if (times.length == 2) {
//				String month=TimeUtils.getFilmMonth(times[0]);
//				String day=TimeUtils.getFilmDay(times[0]);
//				String week=TimeUtils.getWeek(times[0]);
                String showtime = times[0] + "  " + "00:00:00";
                return showtime;
            }
        }
        return detail_time;
    }

    /**
     * 掉此方法输入所要转换的时间输入例如（"2014年06月14日16时09分00秒"）返回时间戳
     *
     * @param time
     * @return
     */
    public static String data(String time) {
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
        Date date;
        String times = null;
        try {
            date = sdr.parse(time);
            long l = date.getTime();
            String stf = String.valueOf(l);
            times = stf.substring(0, 10);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return times;
    }

    /**
     * 时间戳转化为日期
     *
     * @param time       时间戳
     * @param dateformat 时间格式
     * @return
     */
    public static String data(long time, String dateformat) {
        SimpleDateFormat format = new SimpleDateFormat(dateformat);
        String d = format.format(time);
        return d;
    }

    @NonNull
    public static String getNowData() {
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
//        String str = formatter.format(curDate);
        String time = String.valueOf(System.currentTimeMillis() / 1000);
        return time;
    }

}
