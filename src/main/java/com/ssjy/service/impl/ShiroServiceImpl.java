package com.ssjy.service.impl;

import com.ssjy.auth.TokenGenerator;
import com.ssjy.bean.User;
import com.ssjy.dao.UserDao;
import com.ssjy.service.ShiroService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class ShiroServiceImpl implements ShiroService {

    private Logger logger = LoggerFactory.getLogger(ShiroServiceImpl.class);

    //30分钟过期
    private final static int EXPIRE = 1800;

    @Autowired
    private UserDao userDao;

    @Override
    public User findUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }

    @Override
    /**
     * 生成一个token
     */
    public Map<String, Object> createToken(Long id) {
        Map<String,Object> result = new HashMap<>();
        //生成token
        String token = TokenGenerator.generateValue();
        //当前时间
        Date now = new Date();

        //过期时间
        Date expireTime = new Date(now.getTime() + EXPIRE * 1000);

        //判断是否生成token

        return null;
    }
}
