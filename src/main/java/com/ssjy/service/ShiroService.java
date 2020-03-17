package com.ssjy.service;

import com.ssjy.bean.User;
import com.ssjy.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


public interface ShiroService {

    User findUserByUsername(String username);

    Map<String,Object> createToken(Long userId);

}
