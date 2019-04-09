package com.fx.modules.hibernateOneToOne.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fx.modules.common.entity.BaseDataEntity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 人员表，验证一对一关系
 * @author fxiao
 * @date 2019/1/26 0:08
 */
@Entity
@JsonIgnoreProperties(value = "hibernateLazyInitializer")
public class People extends BaseDataEntity implements Serializable {
    private String name;
    //该注解应该放在不维护外键的一方，转json的时候不用注入此对象，防止陷入死循环。禁止反序列化的时候用的是另一个注解，如果反序列化，则不能通过json转换到该实体的时候，该对象会被忽视。
    @JsonBackReference
    //fetch设置为懒加载，targetEntity目标类，mappedBy：由对方的哪一个属性维护，cascade：级联方式设置为全部
    @OneToOne(fetch = FetchType.LAZY,targetEntity = IdCard.class,mappedBy = "people",cascade = CascadeType.ALL)
    private IdCard idCard;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IdCard getIdCard() {
        return idCard;
    }

    public void setIdCard(IdCard idCard) {
        this.idCard = idCard;
    }
}
