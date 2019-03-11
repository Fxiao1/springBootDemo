package com.fx.modules.hibernateManyToMany.dao;

import com.fx.modules.hibernateManyToMany.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author fxiao
 * @date 2019/2/2 17:11
 */
public interface UserDao extends JpaRepository<User,Long> {
}
