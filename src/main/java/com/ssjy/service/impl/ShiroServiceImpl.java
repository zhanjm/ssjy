package com.ssjy.service.impl;

import com.ssjy.auth.TokenGenerator;
import com.ssjy.bean.SysToken;
import com.ssjy.bean.User;
import com.ssjy.dao.SysTokenRepository;
import com.ssjy.dao.UserRepository;
import com.ssjy.service.ShiroService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class   ShiroServiceImpl implements ShiroService {

    private Logger logger = LoggerFactory.getLogger(ShiroServiceImpl.class);

    //30分钟过期
    private final static int EXPIRE = 1800;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SysTokenRepository sysTokenRepository;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
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
        SysToken sysToken = sysTokenRepository.findByUserId(id);
        if(sysToken ==null){
            sysToken = new SysToken();
            sysToken.setUserId(id);

        }
        sysToken.setToken(token);
        sysToken.setUpdateTime(now);
        sysToken.setExpireTime(expireTime);

        //保存或更新token
        sysTokenRepository.save(sysToken);

        //返回token给前端
        result.put("token",token);
        result.put("expire",EXPIRE);
        return result;
    }

    @Override
    public void logout(Long userId) {
        //生成一个token
        String token = TokenGenerator.generateValue();
        //修改token
        SysToken tokenEntity = new SysToken();
        tokenEntity.setUserId(userId);
        tokenEntity.setToken(token);
        sysTokenRepository.save(tokenEntity);
    }

    @Override
    public SysToken findByToken(String accessToken) {
        return sysTokenRepository.findByToken(accessToken);

    }

    @Override
    public User findByUserId(Long userId) {
        return userRepository.findByUserId(userId);
    }




}
