package com.ssjy.bean;

import lombok.Data;
import org.hibernate.annotations.Table;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity(name = "systoken")
@Table(appliesTo = "systoken", comment = "systoken")
public class SysToken {

    @Id
    private Long userId;
    private String token;
    private Date expireTime;
    private Date updateTime;

}
