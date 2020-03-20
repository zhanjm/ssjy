package com.ssjy.bean;

import lombok.Data;
import org.hibernate.annotations.Table;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name = "systoken")
@Table(appliesTo = "systoken", comment = "systoken")
public class SysToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id",columnDefinition="BIGINT COMMENT '用户编号'")
    private Long userId;
    @Column(name = "token",columnDefinition="VARCHAR(256) NOT NULL COMMENT 'token字符串'")
    private String token;
    @CreatedDate
    @Column(name = "expire_time",columnDefinition="DATETIME NOT NULL COMMENT 'expire_time'")
    private Date expireTime;
    @CreatedDate
    @Column(name = "update_time",columnDefinition="DATETIME NOT NULL COMMENT 'update_time'")
    private Date updateTime;

}
