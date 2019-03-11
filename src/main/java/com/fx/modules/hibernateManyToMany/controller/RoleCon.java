package com.fx.modules.hibernateManyToMany.controller;

import com.fx.modules.common.controller.BaseDataController;
import com.fx.modules.common.tools.DataPack;
import com.fx.modules.common.tools.EntityUtils;
import com.fx.modules.hibernateManyToMany.entity.Role;
import com.fx.modules.hibernateManyToMany.service.RoleSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author fxiao
 * @date 2019/2/21 15:55
 */
@RestController
public class RoleCon implements BaseDataController<Role,Long> {

    private RoleSer ser;
    @Autowired
    public RoleCon(RoleSer ser){
        this.ser=ser;
    }
    @Override
    @PostMapping("role")
    public DataPack<Role> save(Role role) {
        return ser.save(role);
    }

    @Override
    @DeleteMapping("role/{id}")
    public DataPack<Role> deleteById(@PathVariable("id") Long id) {
        ser.deleteById(id);
        return EntityUtils.succ(null);
    }

    @Override
    @GetMapping("role/{id}")
    public DataPack<Role> findById(@PathVariable("id") Long id) {
        return ser.findById(id);
    }

    @Override
    @GetMapping("role")
    public DataPack<List<Role>> findAll() {
        return ser.findAll();
    }

    @Override
    @PutMapping("role")
    public DataPack<Role> updata(Role role) {
        ser.update(role);
        return EntityUtils.succ(role);
    }
}
