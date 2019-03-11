package com.fx.modules.hibernateOneToMany.service.impl;

import com.fx.modules.common.tools.DataPack;
import com.fx.modules.common.tools.EntityUtils;
import com.fx.modules.hibernateOneToMany.dao.DepartmentDao;
import com.fx.modules.hibernateOneToMany.entity.Department;
import com.fx.modules.hibernateOneToMany.service.DepartmentSer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


/**
 *
 * @author fxiao
 * @date 2019/2/2 11:42
 */
@Service
public class DepartmentSerImpl implements DepartmentSer {
    private String message;
    private Logger log= LoggerFactory.getLogger(DepartmentSerImpl.class);
    @Autowired
    private DepartmentDao dao;
    @Override
    public DataPack<Department> findById(Long id) {
        Optional<Department> departmentOptional = dao.findById(id);
        return EntityUtils.succ(departmentOptional.get());
    }

    @Override
    public DataPack<List<Department>> findAll() {
        return EntityUtils.succ(dao.findAll());
    }

    @Override
    public DataPack<Department> save(Department department) {
        if(!EntityUtils.isNeW(department)){
            department.setId(0L);
        }
        return EntityUtils.succ(dao.save(department));
    }

    @Override
    public DataPack<Department> update(Department department) {
        String message="id不存在，请检查后重试，id="+department.getId();
        if(EntityUtils.isNeW(department)){
            log.error(message);
            return EntityUtils.error(message);
        }
        if(!dao.findById(department.getId()).isPresent()){
            log.error(message);
            return EntityUtils.error(message);
        }
        return EntityUtils.succ(dao.save(department));
    }

    @Override
    public void deleteById(Long id) {
        dao.deleteById(id);
    }


}
