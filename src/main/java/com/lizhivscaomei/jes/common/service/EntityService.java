package com.lizhivscaomei.jes.common.service;

import com.lizhivscaomei.jes.common.entity.Page;
import com.lizhivscaomei.jes.common.exception.AppException;

import java.util.List;

public interface EntityService<T> {
    /*增加*/
    void add(T entity) throws AppException;
    /*修改*/
    void update(T entity) throws AppException;
    /*删除*/
    void delete(String id) throws AppException;
    /*获取明细*/
    T getById(String id);
    /*分页查询*/
    List<T> queryPage(T entity, Page page);
}
