package com.fx.modules.hibernateOneToOne.entity;

import com.fx.modules.common.entity.BaseDataEntity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * “身份证”表，验证一对一关系
 * @author fxiao
 * @date 2019/1/26 15:25
 */
@Entity
public class IdCard extends BaseDataEntity implements Serializable {
    @OneToOne(fetch = FetchType.LAZY,targetEntity = People.class)
//    下面注解里的必设属性：nullable——是否允许null，unique——是否允许重复（默认为true）；非必设属性“name”属性表示该外键所指对象在当前表中显示的字段名；referencedColumnName属性表示以对方的那个属性作为本类外键的依据
    @JoinColumn(nullable = false,unique = true)
    private People people;

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }
}
