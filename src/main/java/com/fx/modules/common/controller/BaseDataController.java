package com.fx.modules.common.controller;

import com.fx.modules.common.tools.DataPack;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * 数据对象类的基础控制类，定义了基础增删查改操作
 * @author fxiao
 * @date 2019/2/1 14:11
 */
@Controller
public interface BaseDataController<T,I> {
    DataPack<T> save(T t);
    DataPack<T> deleteById(Long id);
    DataPack<T> findById(I id);
    DataPack<List<T>> findAll();
    DataPack<T> updata(T t);
}
