package com.fx.modules.hibernateOneToMany.controller;

import com.fx.modules.common.controller.BaseDataController;
import com.fx.modules.common.tools.DataPack;
import com.fx.modules.common.tools.EntityUtils;
import com.fx.modules.hibernateOneToMany.entity.Department;
import com.fx.modules.hibernateOneToMany.service.DepartmentSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * TODO:“部门”对象controller
 * @author fxiao
 * @date 2019/2/2 11:29
 */
@RestController
public class DepartmentController implements BaseDataController<Department,Long> {
   @Autowired
   private DepartmentSer ser;
    /**
     * 保存
     * @param department json请求体
     * @return
     */
    @PostMapping("depart")
    @Override
    public DataPack<Department> save(Department department) {
       return ser.save(department);
    }

    /**
     * 删除
     * @param id
     */
    @DeleteMapping("department/{id}")
    @Override
    public DataPack deleteById(@PathVariable("id") Long id) {
        ser.deleteById(id);
        return EntityUtils.succ(null);
    }

    /**
     * 查一个
     * @param id
     * @return
     */
    @GetMapping("department/{id}")
    @Override
    public DataPack<Department> findById(@PathVariable("id") Long id) {
        return ser.findById(id);
    }

    /**
     * 查到所有
     * @return
     */
    @GetMapping("department")
    @Override
    public DataPack<List<Department>> findAll() {
        return ser.findAll();
    }

    /**
     * 改数据
     * @param department
     * @return
     */
    @PutMapping("department")
    @Override
    public DataPack<Department> updata(Department department) {
       return ser.update(department);
    }
}
