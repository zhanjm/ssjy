package com.ssjy.dao;

import com.ssjy.bean.SysToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysTokenRepository extends JpaRepository<SysToken,Long> {
    SysToken findByUserId(Long id);

    SysToken findByToken(String token);
}
