package com.fx.modules.hibernateManyToMany.entity;

import com.fx.modules.common.entity.BaseDataEntity;

import javax.persistence.*;
import java.util.Set;

/**
 * TODO:系统用户表，用来测试多对多
 * @author fxiao
 * @date 2019/2/2 16:18
 */
@Entity
public class User extends BaseDataEntity {
    private String name;
    @ManyToMany(fetch = FetchType.LAZY,targetEntity = Role.class,mappedBy = "userSet",cascade = CascadeType.ALL)//期待两表不级联
    private Set<Role> roleSet;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }
}
