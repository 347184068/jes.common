package com.lizhivscaomei.jes.common.service;

import com.lizhivscaomei.jes.common.exception.AppException;

import java.util.List;

public interface EntityService<T> {
    /*增加*/
    void add(T t) throws AppException;
    /*修改*/
    void update(T t) throws AppException;
    /*删除*/
    void delete(String id) throws AppException;
    /*获取明细*/
    T getById(String id);
    /*获取全部*/
    List<T> queryAll();
}
