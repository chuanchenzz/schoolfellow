package com.chuanchen.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by chuanchenwine on 2017/4/20.
 */
public class CommonUtil {
    private static final String datePattern = "\\d{4}-\\d{2}-\\d{2}";

    public static Date strToDate(String strDate){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(strDate.trim());
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
    public static boolean isDatePattern(String str){
        String strDate = str.trim();
        return Pattern.matches(datePattern,strDate);
    }
    public static String dateToStr(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(date);
    }
    public static String md5Password(String password){
        return password;
    }
}
