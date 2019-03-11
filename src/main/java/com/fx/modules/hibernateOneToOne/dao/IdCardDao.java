package com.fx.modules.hibernateOneToOne.dao;

import com.fx.modules.hibernateOneToOne.entity.IdCard;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author fxiao
 * @date 2019/1/26 16:14
 */
public interface IdCardDao extends JpaRepository<IdCard, Long> {
}
