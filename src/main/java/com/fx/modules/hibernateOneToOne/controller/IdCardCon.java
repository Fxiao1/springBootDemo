package com.fx.modules.hibernateOneToOne.controller;

import com.fx.modules.common.tools.DataPack;
import com.fx.modules.common.tools.EntityUtils;
import com.fx.modules.hibernateOneToOne.dao.PeopleDao;
import com.fx.modules.hibernateOneToOne.entity.IdCard;
import com.fx.modules.hibernateOneToOne.service.IdCardSer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author fxiao
 * @date 2019/1/26 16:05
 */
@Controller
public class IdCardCon {
    private Logger log= LoggerFactory.getLogger(IdCardCon.class);
    @Autowired
    private IdCardSer idCardSer;
    @Autowired
    private PeopleDao peopleDao;

    @PostMapping("idcard")
    @ResponseBody
    public DataPack<IdCard> save(IdCard idCard){//原来并不需要传"people_id"这个参数，我们应该离开数据表，只看到对象，所以传的时候传一下IdCard的属性"people"这个参数（值为所引用的people对象的id）就行了
//        Optional<People> optionalPeople = peopleDao.findById(card.getPeople().getId());
//        People people=null;
//        if(optionalPeople.isPresent()){
//            card.setId(0);
//            card.setPeople(optionalPeople.get());
//            return idCardSer.save(card);
//        }else{
//            throw new RuntimeException("找不到People对象，peopleId="+card.getPeople().getId());
//        }
        idCard.setId(0L);
         idCard= idCardSer.save(idCard);
         return EntityUtils.succ(idCard);
    }
    @GetMapping("idcard")
    @ResponseBody
    public Object list(){
        List<IdCard> list=idCardSer.findAll();
        return list;
    }

    @GetMapping("idcard/{id}")
    @ResponseBody
    public IdCard get(@PathVariable("id") long id) {
        Optional<IdCard> optionalIdCard = idCardSer.findById(id);
        if (optionalIdCard.isPresent()) {
            IdCard idCard = optionalIdCard.get();
            return idCard;
        } else {
            return new IdCard();
        }
    }
}
