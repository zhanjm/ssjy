package com.ssjy.bean;

import lombok.Data;
import org.hibernate.annotations.Table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity(name = "permission")
@Table(appliesTo = "permission", comment = "permission")
public class Permission {

    @Id
    @GeneratedValue
    private Long permissionId;
    private String permissionName;
    private String permission;

}
