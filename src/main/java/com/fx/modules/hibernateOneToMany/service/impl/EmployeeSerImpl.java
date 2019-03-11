package com.fx.modules.hibernateOneToMany.service.impl;

import com.fx.modules.common.tools.DataPack;
import com.fx.modules.common.tools.EntityUtils;
import com.fx.modules.hibernateOneToMany.dao.EmployeeDao;
import com.fx.modules.hibernateOneToMany.entity.Employee;
import com.fx.modules.hibernateOneToMany.service.EmployeeSer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author fxiao
 * @date 2019/2/1 12:02
 */
@Service
public class EmployeeSerImpl implements EmployeeSer{
    @Autowired
    private EmployeeDao dao;
    private Logger log= LoggerFactory.getLogger(Employee.class);


    @Override
    public DataPack<Employee> findById(Long id) {
        Employee employee=dao.findById(id).get();
        return EntityUtils.succ(employee);
    }

    @Override
    public DataPack<List<Employee>> findAll() {
        return EntityUtils.succ(dao.findAll());
    }

    @Override
    public DataPack<Employee> save(Employee employee) {
        if(!EntityUtils.isNeW(employee)){
            employee.setId(0L);
        }
        return save(employee);
    }

    @Override
    public DataPack<Employee> update(Employee employee) {
        String message="id不存在，请检查后重试，id="+employee.getId();
        if(EntityUtils.isNeW(employee)){
            log.error(message);
            return EntityUtils.error(message);
        }
        if(!dao.findById(employee.getId()).isPresent()){
            log.error(message);
            return EntityUtils.error(message);
        }
        return EntityUtils.succ(dao.save(employee));
    }

    @Override
    public void deleteById(Long id) {
        dao.deleteById(id);
    }
}
