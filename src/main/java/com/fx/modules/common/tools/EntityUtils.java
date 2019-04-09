package com.fx.modules.common.tools;

import com.fx.modules.common.entity.BaseDataEntity;

/**
 * 数据实体工具类
 * @author fxiao
 * @date 2019/2/1 13:22
 */
public class EntityUtils {
    private static DataPack dataPack;

    /**
     * 获得单例的数据包装类实体
     * @return
     */
    private static DataPack getDataPack(){
        if(dataPack ==null){
            dataPack =new DataPack();
            return dataPack;
        }else{
            dataPack.initialization();
            return dataPack;
        }
    }

    /**
     * 获得成功状态的数据包装类
     * @param data
     * @param <T>
     * @return
     */
    public static<T> DataPack<T> succ(T data){
        dataPack= getDataPack();
        dataPack.setData(data);
        dataPack.setSuccess(true);
        return dataPack;
    }

    /**
     * 获得失败状态的数据包装类
     * @param message
     * @return
     */
    public static DataPack error(String message){
        dataPack=getDataPack();
        dataPack.setMessage(message);
        dataPack.setSuccess(false);
        return dataPack;
    }

    /**
     * 判断数据实体是不是新数据
     * @param t 该对象的id只能是对象类型，否则该方法不支持
     * @param <T> BaseDataEntity的子类
     * @return
     */
    public static <T extends BaseDataEntity> Boolean isNeW(T t){
        Object id=t.getId();
        if(id==null){
            return true;
        }else if(id instanceof Number){
            return ((Number) id).longValue() == 0L;
        }else if(id instanceof String){
            return id!="";
        }
        throw new IllegalArgumentException("仅支持对象类型的ID");
    }
}
