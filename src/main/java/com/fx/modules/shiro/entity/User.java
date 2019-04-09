package com.fx.modules.shiro.entity;

import com.fx.modules.common.entity.BaseDataEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * TODO:
 *
 * @author fxiao
 * @date 2019/4/2 16:19
 */
@Table(name="shiro_test_user")
@Entity
public class User extends BaseDataEntity {
    private String username;
    private String password;
    private String role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
