package com.ssjy.dao;

import com.ssjy.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String name);

    User findByUserId(Long userId);
}
