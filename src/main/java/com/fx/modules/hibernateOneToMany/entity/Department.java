package com.fx.modules.hibernateOneToMany.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fx.modules.common.entity.BaseDataEntity;

import javax.persistence.*;
import java.util.Set;

/**
 * TODO:部门表，验证多对一的关系
 *
 * @author fxiao
 * @date 2019/2/1 9:40
 */
@Entity
@JsonIgnoreProperties(value = "hibernateLazyInitializer")
public class Department extends BaseDataEntity {
    private String name;
    //员工
    @OneToMany(fetch = FetchType.LAZY
            , mappedBy = "department"
            , targetEntity = Employee.class
            , cascade = CascadeType.ALL
//            ,orphanRemoval = true
    )
    @JsonBackReference//部门不显示员工
    private Set<Employee> employeeSet;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }
}
