package com.ssjy.bean;

import lombok.Data;
import org.hibernate.annotations.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity(name = "role")
@Table(appliesTo = "role", comment = "权限")
@EntityListeners(AuditingEntityListener.class)
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//strategy = GenerationType.IDENTITY 自增策略数据库中自动生成hibernate_sequence表
    @Column(name = "role_id",columnDefinition="BIGINT COMMENT '权限编号'")
    private Long roleId;
    @Column(name = "role_name",columnDefinition="VARCHAR(256) NOT NULL COMMENT '权限名称'")
    private String roleName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_permission",
            joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "role_id")},
            inverseJoinColumns = {@JoinColumn(name = "permission_id", referencedColumnName = "permission_id")})
    private Set<Permission> permissions;


}
