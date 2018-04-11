package com.lizhivscaomei.jes.common.utils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * javabean属性转化
 * Created by lizhi on 2017/8/29.
 */
public class JavaBeanUtil {
    /**
     * 将javabean属性填充到map中
     * */
    public static <T extends Object> void javaBean2Map(T javabean, Map<String, Object> map) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(javabean.getClass());
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor property : propertyDescriptors) {
            String key = property.getName();
            // 过滤class属性
            if (!key.equals("class")) {
                // 得到property对应的getter方法
                Method getMethod = property.getReadMethod();
                try {
                    Object value = getMethod.invoke(javabean);
                    map.put(key, value);
                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
                } catch (InvocationTargetException e) {
//                    e.printStackTrace();
                }
            }
        }

    }
    /**
     * 将map中属性填充到map中
     * */
    public static <T extends Object> void map2JavaBean(Map<String, Object> map,T javabean) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(javabean.getClass());
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor property : propertyDescriptors) {
            String key = property.getName();
            // 过滤class属性
            if (!key.equals("class")) {
                // 得到property对应的getter方法
                Method setMethod = property.getWriteMethod();
                try {
                    setMethod.invoke(javabean,map.get(key));
                } catch (Exception e) {
//                        e.printStackTrace();
                }
            }
        }

    }
    /**
     * 将javabean属性填充到另一个javabean中
     * */
    public static <T extends Object> void javaBean2JavaBean(T src, T target) throws IntrospectionException {
        //src
        BeanInfo srcBeanInfo = Introspector.getBeanInfo(src.getClass());
        PropertyDescriptor[] srcPropertyDescriptors = srcBeanInfo.getPropertyDescriptors();
        //target
        BeanInfo targetBeanInfo = Introspector.getBeanInfo(target.getClass());
        PropertyDescriptor[] targetPropertyDescriptors = targetBeanInfo.getPropertyDescriptors();
        for (PropertyDescriptor srcproperty : srcPropertyDescriptors) {
            String key = srcproperty.getName();
            // 过滤class属性
            if (!key.equals("class")) {
                for(PropertyDescriptor targetProperty : targetPropertyDescriptors){
                    String targetKey = targetProperty.getName();
                    if(key.equals(targetKey)){
                        Method targetsetMethod = targetProperty.getWriteMethod();
                        try {
                            targetsetMethod.invoke(target,srcproperty.getReadMethod().invoke(src));
                        } catch (IllegalAccessException e) {
//                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
//                            e.printStackTrace();
                        }
                    }
                }
            }
        }

    }
}
