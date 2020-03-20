package com.ssjy.bean;

import lombok.Data;
import org.hibernate.annotations.Table;

import javax.persistence.*;

@Data
@Entity(name = "permission")
@Table(appliesTo = "permission", comment = "permission")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "permission_id",columnDefinition="BIGINT COMMENT 'permissionId'")
    private Long permissionId;
    @Column(name = "permission_name",columnDefinition="VARCHAR(256) NOT NULL COMMENT 'permission_name'")
    private String permissionName;
    @Column(name = "permission",columnDefinition="VARCHAR(256) NOT NULL COMMENT 'permission'")
    private String permission;

}
