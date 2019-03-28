package com.fx.modules.hibernateManyToMany.service.impl;

import com.fx.modules.common.tools.DataPack;
import com.fx.modules.common.tools.EntityUtils;
import com.fx.modules.hibernateManyToMany.dao.UserDao;
import com.fx.modules.hibernateManyToMany.entity.User;
import com.fx.modules.hibernateManyToMany.service.UserSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * TODO: 用户对象的ser层
 *
 * @author fxiao
 * @date 2019/3/28 20:10
 */
@Service
public class UserSerImpl implements UserSer {
    private UserDao dao;
    @Autowired
    public UserSerImpl(UserDao dao){
        this.dao=dao;
    }
    public UserSerImpl(){};
    @Override
    public DataPack<User> findById(Long id) {
        Optional<User> optionalUser=dao.findById(id);
        User user=new User();
        if(optionalUser.isPresent()){
            user=optionalUser.get();
            return EntityUtils.succ(user);
        }else{
            return EntityUtils.error("不知道为啥，没有获取到用户");
        }
    }

    @Override
    public DataPack<List<User>> findAll() {
        return EntityUtils.succ(dao.findAll());
    }

    @Override
    public DataPack<User> save(User user) {
        user.setId(0L);
        dao.save(user);
        return EntityUtils.succ(user);
    }

    @Override
    public DataPack<User> update(User user) {
        if(user.getId()!=null&&user.getId()>0L){
            dao.save(user);
            return EntityUtils.succ(user);
        }else{
            return EntityUtils.error("更新失败：未找到对象id");
        }
    }

    @Override
    public void deleteById(Long id) {
        dao.deleteById(id);
    }
}
