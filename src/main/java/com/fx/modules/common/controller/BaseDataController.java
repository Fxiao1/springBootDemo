package com.fx.modules.common.controller;

import com.fx.modules.common.tools.DataPack;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * TODO:数据对象类的基础控制类，定义了基础增删查改操作
 * @author fxiao
 * @date 2019/2/1 14:11
 */
@Controller
public interface BaseDataController<T,I> {
    public DataPack<T> save(T t);
    public DataPack<T> deleteById(Long id);
    public DataPack<T> findById(I id);
    public DataPack<List<T>> findAll();
    public DataPack<T> updata(T t);
}
