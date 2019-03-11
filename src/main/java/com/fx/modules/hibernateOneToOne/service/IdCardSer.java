package com.fx.modules.hibernateOneToOne.service;

import com.fx.modules.hibernateOneToOne.entity.IdCard;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author fxiao
 * @date 2019/1/26 22:44
 */
public interface IdCardSer {
    public List<IdCard> findAll();
    public IdCard save(IdCard idCard);
    public Optional<IdCard> findById(Long id);
}
