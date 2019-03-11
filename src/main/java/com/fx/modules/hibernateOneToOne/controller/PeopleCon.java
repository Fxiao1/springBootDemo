package com.fx.modules.hibernateOneToOne.controller;

import com.fx.modules.hibernateOneToOne.dao.PeopleDao;
import com.fx.modules.hibernateOneToOne.entity.People;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author fxiao
 * @date 2019/1/25 23:50
 */
@RestController()
public class PeopleCon {
    private Logger log= LoggerFactory.getLogger(PeopleCon.class);
    @Autowired
    private PeopleDao peopleDao;

    /**
     * 新增
     * @param people
     * @return
     */
    @PostMapping("people")
    public People save(@RequestBody People people){
//       如果需要两者必须“同有同无”则增加下面的if语句块，如果没有这个要求，则去掉这个if语句块，没有子对象时候就不存子对象了。
//        if(people.getIdCard()==null||people.getIdCard().getPeople()==null){
//            IdCard idCard=new IdCard();
//            idCard.setPeople(people);
//            people.setIdCard(idCard);
//        }
        if(people.getIdCard()!=null){
            people.getIdCard().setPeople(people);
        }

        //防止通过保存的方法导致已有数据被修改
        if(people.getId()!=0){
            people.setId(0L);
        }
        return  peopleDao.save(people);
    }
    @GetMapping("people")
    public List<People> list(){
        return peopleDao.findAll();
    }

    @PutMapping("people")
    public People update(@RequestBody People newPeople){
        Optional<People> optionalPeople=peopleDao.findById(newPeople.getId());
        if(optionalPeople.isPresent()){
            if(newPeople.getIdCard()!=null){
//                关联外键，设置主键一步都不能少，少前者外键id会被设置null，少后者会因为无id而改更新为存储，从而会出现重复的外键id
                newPeople.getIdCard().setPeople(newPeople);
                newPeople.getIdCard().setId(optionalPeople.get().getIdCard().getId());
            }
            peopleDao.save(newPeople);
        }else{
            log.error("未更新数据");
            throw new RuntimeException("未找到对应实体，id="+newPeople.getId());
        }
        return null;
    }
    @DeleteMapping("people")
    public void delete(Long id){
        peopleDao.deleteById(id);

    }
}
