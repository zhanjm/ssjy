package com.ssjy.service;

import com.ssjy.bean.SysToken;
import com.ssjy.bean.User;

import java.util.Map;


public interface ShiroService {

    User findByUsername(String username);

    Map<String,Object> createToken(Long userId);

    public void logout(Long userId);

    SysToken findByToken(String token);

    User findByUserId(Long userId);
}
