package com.fx.springbootdemo.test.controller;


import com.alibaba.fastjson.JSONObject;
import com.fx.springbootdemo.test.entity.DemoEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 *
 * @author fxiao
 * @date 2019/1/3 21:03
 */
@RestController
@RequestMapping("demo")
public class Demo {

    @PostMapping("demo1")
    public DemoEntity demo1(String name2,  @RequestBody @Valid DemoEntity demoEntity, BindingResult bindingResult){
        boolean tf=bindingResult.hasErrors();
        if (tf) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
        }

        return demoEntity;
    }
    @GetMapping("hello")
    public String hello(){
        return "hello";
    }
    @PostMapping("postHello")
    public String hello2(DemoEntity demoEntity,@RequestBody JSONObject json){

        return "hello2";
    }
}
