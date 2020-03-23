package com.ssjy.controller;

import com.ssjy.bean.User;
import com.ssjy.service.ShiroService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Controller
@Api(value = "Shiro API接口", tags = { "Shiro API接口" })
public class ShiroController {
    @Autowired
    private ShiroService shiroService;

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @ApiOperation(value="登录", notes="用户登录", produces="application/json")
    @GetMapping(value="/sys/login")
    public Map<String, Object> login(String username, String password) {
        Map<String, Object> result = new HashMap<>();

        User user = shiroService.findByUsername(username);
        if (user == null || !user.getPassword().equals(password)) {
            result.put("status", "404");
            result.put("msg", "账号或密码有误");
        } else {
            result = shiroService.createToken(user.getUserId());
            result.put("status", "200");
            result.put("msg", "登录成功");
        }
        return result;
    }

    /**
     * 退出
     */
    @PostMapping("/sys/logout")
    public Map<String, Object> logout() {
        Map<String, Object> result = new HashMap<>();
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        shiroService.logout(user.getUserId());
        result.put("status", "200");
        result.put("msg", "登陆成功");
        return result;

    }
}
