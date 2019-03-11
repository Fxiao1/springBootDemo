package com.fx.modules.common.service;


import com.fx.modules.common.entity.BaseDataEntity;
import com.fx.modules.common.tools.DataPack;

import java.util.List;

/**
 * TODO:数据实体基础Service接口
 * @author fxiao
 * @date 2019/2/1 11:53
 */
 /*   将id的类型设置为泛型的话会有时候导致Idea自动实现该接口方法的时候丢失参数名，比如下面findById的参数名“id”就丢失，而变成了“aLong”。
  * 如果需要保持这里的参数名的话，需要去掉id的泛型
  */
public  interface BaseDataSer<T extends BaseDataEntity, ID> {
    public DataPack<T> findById(ID id);
    public DataPack<List<T>> findAll();

    /**
     * 存储对象<br>
     *     对于该方法的实现类需要注意校验:id必须为空
     * @param t
     * @return
     */
    public DataPack<T> save(T t);

    /**
     * 更改对象<br>
     * 该方法实现类需要校验：<br>
     *      1、对象id不可为空<br>
     *      2、对象id必须已在库中存在，因为框架没有校验这点。否则如果没有找到待修改的记录的话，就会改为存储对象
     *      3、该方法如果调用jpa默认的save方法的话，请注意，jpa的save方法的返回值仅等于传入值，并不是数据库中当前对象的最新值，因为保存后并没有再去数据库查询。
     * @param t
     * @return
     */
    public DataPack<T> update(T t);
    public void deleteById(ID id);
}
