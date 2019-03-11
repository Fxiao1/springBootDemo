package com.fx.modules.hibernateOneToMany.controller;

import com.fx.modules.common.controller.BaseDataController;
import com.fx.modules.common.tools.DataPack;
import com.fx.modules.common.tools.EntityUtils;
import com.fx.modules.hibernateOneToMany.entity.Employee;
import com.fx.modules.hibernateOneToMany.service.EmployeeSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * TODO:“员工”对象controller
 * @author fxiao
 * @date 2019/2/1 14:09
 */
@RestController
public class EmployeeController implements BaseDataController<Employee,Long> {
    @Autowired
    private EmployeeSer ser;

    /**
     * 增
     * @param employee
     * @return
     */
    @PostMapping("employee")
    @Override
    public DataPack<Employee> save(Employee employee) {
        return ser.save(employee);
    }

    /**
     * 删
     * @param id
     */
    @DeleteMapping("employee/{id}")
    @Override
    public DataPack deleteById(@PathVariable("id") Long id) {
        ser.deleteById(id);
        return EntityUtils.succ(null);
    }

    /**
     * 查单个
     * @param id
     * @return
     */
    @GetMapping("employee/{id}")
    @Override
    public DataPack<Employee> findById(@PathVariable("id") Long id) {
        return ser.findById(id);
    }

    /**
     * 查全部
     * @return
     */
    @GetMapping("employee")
    @Override
    public DataPack<List<Employee>> findAll() {
        return ser.findAll();
    }

    /**
     * 改
     * @param employee
     * @return
     */
    @PutMapping("employee")
    @Override
    public DataPack<Employee> updata(Employee employee) {
        return ser.update(employee);
    }
}
