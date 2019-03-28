package com.fx.modules.hibernateManyToMany.service.impl;

import com.fx.modules.common.tools.DataPack;
import com.fx.modules.common.tools.EntityUtils;
import com.fx.modules.hibernateManyToMany.dao.RoleDao;
import com.fx.modules.hibernateManyToMany.entity.Role;
import com.fx.modules.hibernateManyToMany.service.RoleSer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO:权限对象service
 * @author fxiao
 * @date 2019/2/2 17:09
 */
@Service
public class RoleSerImpl implements RoleSer {
    private Logger log= LoggerFactory.getLogger(RoleSerImpl.class);
    @Autowired
    private RoleDao dao;

    @Override
    public DataPack<Role> findById(Long id) {
        Role role=dao.findById(id).get();
        return EntityUtils.succ(role);
    }

    @Override
    public DataPack<List<Role>> findAll() {
        return EntityUtils.succ(dao.findAll());
    }

    @Override
    public DataPack<Role> save(Role role) {
        if(!EntityUtils.isNeW(role)){
            role.setId(0L);
        }
        dao.save(role);
        return EntityUtils.succ(role);
    }

    @Override
    public DataPack<Role> update(Role role) {
        String message="id不存在，请检查后重试，id="+role.getId();
        if(EntityUtils.isNeW(role)){
            log.error(message);
            return EntityUtils.error(message);
        }
        if(!(dao.findById(role.getId()).isPresent())){
            log.error(message);
            return EntityUtils.error(message);
        }
        return EntityUtils.succ(dao.save(role));
    }

    @Override
    public void deleteById(Long id) {
        dao.deleteById(id);
    }
}
