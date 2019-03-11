package com.fx.modules.common.entity;

import com.fx.modules.common.tools.StatusType;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * TODO: 数据实体基础类
 * @author fxiao
 * @date 2019/1/26 0:10
 */
@MappedSuperclass
public class BaseDataEntity {
    /*
        如果使用Table来维护主键，则
        1、必须指定sequence表名（可以指定同一个），否则将默认被维护在表名为hibernate_sequences.sequence_name='default'的字段中，如果有多个默认，将在初始化的时候因为重复而报错
        2、主键必须为纯数字
     */
    @Id
    @GeneratedValue(generator = "hibernate_sequences",strategy = GenerationType.TABLE)
    private Long id;
    //nullable表示“是否允许为null，默认是true
    @Column(nullable = false, updatable = false, columnDefinition = "timestamp default current_timestamp")
    private Timestamp createTime;
    @Column(nullable = false, columnDefinition = "timestamp default current_timestamp")
    private Timestamp updateTime;
    //创建者。测试阶段该值可为空，正式使用时应该改为false
    @Column(nullable = true,updatable = false)
    private String creator;
    //状态
    @Column(nullable = true)
    private StatusType status = StatusType.NORMAL;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }
}
