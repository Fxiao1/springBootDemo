package com.fx.modules.shiro.entity;

import com.fx.modules.common.entity.BaseDataEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * TODO:
 *
 * @author fxiao
 * @date 2019/4/2 16:25
 */
@Table(name="shiro_test_role")
@Entity
public class Role extends BaseDataEntity {
    private String user;
}
