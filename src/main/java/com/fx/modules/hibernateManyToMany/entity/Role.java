package com.fx.modules.hibernateManyToMany.entity;

import com.fx.modules.common.entity.BaseDataEntity;

import javax.persistence.*;
import java.util.Set;

/**
 * 权限表
 * @author fxiao
 * @date 2019/2/2 16:15
 */
@Entity
public class Role extends BaseDataEntity {
    private String name;
//    当前表维护关联关系
    @ManyToMany(fetch= FetchType.LAZY,targetEntity = User.class)
//    中间表信息
    @JoinTable(name = "tb_user_role",
            joinColumns =@JoinColumn(name="roleId")//主表所占据的列的列名。也就是当前表是主表，另一张表（匹配表）需要通过“mappedBy”参数指定到当前对象的当前属性
            ,inverseJoinColumns=@JoinColumn(name="userId")//匹配表所占据的列的列名
    )
    private Set<User> userSet;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }
}
