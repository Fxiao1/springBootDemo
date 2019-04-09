package com.fx.modules.common.service;

import com.fx.modules.common.entity.BaseDataEntity;
import com.fx.modules.common.tools.DataPack;
import com.fx.modules.common.tools.EntityUtils;
import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.List;
import java.util.Optional;

/**
 * TODO: 现在没做成，但是想做到能够被继承的实现。现在仅供参考
 *
 * @author fxiao
 * @date 2019/4/9 17:46
 */
/*public interface  BaseDataSer2<T extends BaseDataEntity<ID>, ID> {

    void logError(String message);
    DataPack<List<T>> findAll();
    void deleteById(Long id);
    Optional<T> daoFindById(ID id);
    T daoSave(T entity);

    default DataPack<T> findById(ID id){
        T entity= daoFindById(id).get();
        return EntityUtils.succ(entity);
    };
    default DataPack<T> save(T entity) {
        if(!EntityUtils.isNeW(entity)){
            Object objId=entity.getId();
            if(objId instanceof Long){
                entity.setId((ID)(new Long(0L)));
            }else if(objId instanceof String){
                entity.setId((ID)"");
            }else{
                logError("不支持的id类型，当前仅支持Long、String类型的id");
            }
        }
        daoSave(entity);
        return EntityUtils.succ(entity);
    }

    default DataPack<T> update(T entity) {
        String message="id不存在，请检查后重试，id="+entity.getId();
        if(EntityUtils.isNeW(entity)){
            logError(message);
            return EntityUtils.error(message);
        }
        Optional<T> entityOptional=daoFindById(entity.getId());
        if(!(entityOptional.isPresent()) ){
            logError(message);
            return EntityUtils.error(message);
        }
        return EntityUtils.succ(daoSave(entity));
    }

}*/
