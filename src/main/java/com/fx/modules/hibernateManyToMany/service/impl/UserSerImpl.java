package com.fx.modules.hibernateManyToMany.service.impl;

import com.fx.modules.common.tools.DataPack;
import com.fx.modules.hibernateManyToMany.dao.UserDao;
import com.fx.modules.hibernateManyToMany.entity.User;
import com.fx.modules.hibernateManyToMany.service.UserSer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * TODO:
 *
 * @author fxiao
 * @date 2019/3/28 20:10
 */
public class UserSerImpl implements UserSer {
    private UserDao dao;
    @Autowired
    public UserSerImpl(UserDao dao){
        this.dao=dao;

    }
    @Override
    public DataPack<User> findById(Long aLong) {
        return null;
    }

    @Override
    public DataPack<List<User>> findAll() {
        return null;
    }

    @Override
    public DataPack<User> save(User user) {
        return null;
    }

    @Override
    public DataPack<User> update(User user) {
        return null;
    }

    @Override
    public void deleteById(Long aLong) {

    }
}
