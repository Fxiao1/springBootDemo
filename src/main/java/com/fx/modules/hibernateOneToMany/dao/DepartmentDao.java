package com.fx.modules.hibernateOneToMany.dao;

import com.fx.modules.hibernateOneToMany.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author fxiao
 * @date 2019/2/1 11:47
 */
public interface DepartmentDao extends JpaRepository<Department,Long> {
}
