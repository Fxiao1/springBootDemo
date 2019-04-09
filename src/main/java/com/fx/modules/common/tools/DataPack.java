package com.fx.modules.common.tools;

/**
 * 数据包装类
 * @author fxiao
 * @date 2019/2/1 13:18
 */
public class DataPack<T>  {
    private Boolean success;
    private String message;
    private T data;
    DataPack() {//禁止其他包的类调用构造方法，该类示例只能通过“com.fx.modules.common.tools.EntityUtils”获得
        super();
    }

    /**
     * 初始化、销毁全部数据
     */
    public void initialization(){
        this.success=false;
        this.message=null;
        this.data=null;
    }


    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
