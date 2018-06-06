package com.lizhivscaomei.jes.common.utils;

import org.apache.commons.lang3.ArrayUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lizhi on 2017/10/31.
 */
public class DateUtils {
    public static String strOfDateTime(Date date){
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sf.format(date);
    }
    public static String strOfDate(Date date){
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
        return sf.format(date);
    }
    public static String strOfTime(Date date){
        SimpleDateFormat sf=new SimpleDateFormat("HH:mm:ss");
        return sf.format(date);
    }
}
