package com.fx.modules.hibernateOneToMany.entity;

import com.fx.modules.common.entity.BaseDataEntity;

import javax.persistence.*;

/**
 * 员工表，验证多对一
 * @author fxiao
 * @date 2019/2/1 9:38
 */
@Entity
public class Employee extends BaseDataEntity {
    private String name;
    //部门
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Department.class)
//    表示该表维护外键
    @JoinColumn(
            name = "department_id"//维护外键的字段名
            ,unique = true//不能重复
            ,nullable = false//不能为空
//            ,referencedColumnName=""//表示该字段维护的外键指向目标对象的那个属性上，默认是对方的id ，通过该注解可以将外键来源更改到对方对象的另外属性上去
    )
    private Department department;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
