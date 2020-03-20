package com.ssjy.bean;

import lombok.Data;
import org.hibernate.annotations.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity(name = "user")
@Table(appliesTo = "user", comment = "用户")
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id",columnDefinition="BIGINT COMMENT '用户编号'")
    private Long userId;
    @Column(name = "user_name",columnDefinition="VARCHAR(256) NOT NULL COMMENT '用户名称'")
    private String username;
    @Column(name = "password",columnDefinition="VARCHAR(256) NOT NULL COMMENT '用户密码'")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "role_id")})
    private Set<Role> roles;


}
