package com.ssjy.controller;

import com.ssjy.bean.User;
import com.ssjy.service.ShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ShiroController {
    @Autowired
    private ShiroService shiroService;

    public Map<String,Object> login(String username,String password){
        Map<String,Object> result = new HashMap<>();

        User user = shiroService.findUserByUsername(username);
        if(user ==null||!user.getPassword().equals(password)){
            result.put("status","404");
            result.put("msg","账号或密码有误");
        }else{
            result = shiroService.createToken(user.getId());
            result.put("status","200");
            result.put("msg","登录成功");
        }
        return result;
    }
}
