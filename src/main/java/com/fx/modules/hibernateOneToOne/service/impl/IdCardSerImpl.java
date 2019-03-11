package com.fx.modules.hibernateOneToOne.service.impl;

import com.fx.modules.hibernateOneToOne.dao.IdCardDao;
import com.fx.modules.hibernateOneToOne.entity.IdCard;
import com.fx.modules.hibernateOneToOne.service.IdCardSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author fxiao
 * @date 2019/1/26 22:44
 */
@Service
public class IdCardSerImpl implements IdCardSer {
    @Autowired
    private IdCardDao idCardDao;

    @Override
    public List<IdCard> findAll() {
        return idCardDao.findAll();
    }

    @Override
    public IdCard save(IdCard idCard) {
        return idCardDao.save(idCard);
    }

    @Override
    public Optional<IdCard> findById(Long id) {
        return idCardDao.findById(id);
    }


}
