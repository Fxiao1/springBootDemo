package com.fx.modules.hibernateManyToMany.controller;

import com.fx.modules.common.controller.BaseDataController;
import com.fx.modules.common.tools.DataPack;
import com.fx.modules.common.tools.EntityUtils;
import com.fx.modules.hibernateManyToMany.entity.User;
import com.fx.modules.hibernateManyToMany.service.UserSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 多对多模块，用户对象controller
 *
 * @author fxiao
 * @date 2019/3/28 20:29
 */
@RestController
public class UserCon implements BaseDataController<User,Long> {
    public UserCon(){super();}
    private UserSer ser;
    @Autowired
    public UserCon(UserSer ser){
        this.ser=ser;
    }
    @Override
    @PostMapping("users")
    public DataPack<User> save(@RequestBody User user) {
        return ser.save(user);
    }

    @Override
    @DeleteMapping("users/{id}")
    public DataPack<User> deleteById(@PathVariable("id") Long id) {
        ser.deleteById(id);
        return EntityUtils.succ(null);
    }


    @Override
    @GetMapping("users/{id}")
    public DataPack<User> findById(@PathVariable("id") Long id) {
        return ser.findById(id);
    }

    @Override
    @GetMapping("users")
    public DataPack<List<User>> findAll() {
        return ser.findAll();
    }

    @Override
    public DataPack<User> updata(User user) {
        return ser.update(user);
    }
}
