package com.lizhivscaomei.jes.common.utils;

import java.util.List;

/**
 * Created by lizhi on 2018/6/6.
 */
public class ListUtils {
    /*获取list第一个*/
    public static Object getFirst(List list){
        if(list!=null&&list.size()>0){

            return list.get(0);
        }
        return null;
    }
   /* 获取list最后一个*/
    public static Object getLast(List list){
        if(list!=null&&list.size()>0){
            return list.get(list.size()-1);
        }
        return null;
    }
}
