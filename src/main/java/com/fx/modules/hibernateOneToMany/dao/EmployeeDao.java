package com.fx.modules.hibernateOneToMany.dao;

import com.fx.modules.hibernateOneToMany.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author fxiao
 * @date 2019/2/1 11:49
 */
public interface EmployeeDao extends JpaRepository<Employee,Long> {
}
