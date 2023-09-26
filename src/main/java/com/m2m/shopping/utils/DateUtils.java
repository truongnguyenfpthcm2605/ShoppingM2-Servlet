package com.m2m.shopping.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static String dateToString(String formatDate, Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(formatDate);
        return dateFormat.format(date);
    }

    public static Date stringToDate(String formatDate, String date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(formatDate);
        return dateFormat.parse(date);
    }
}
