package com.fx.modules.hibernateManyToMany.dao;

import com.fx.modules.hibernateManyToMany.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author fxiao
 * @date 2019/2/2 17:10
 */
public interface RoleDao extends JpaRepository<Role,Long> {
}
