package com.cfs.securityp04.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="roles")
public class roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleid ;

    private String name ;

    public Long getRoleid() {
        return roleid;
    }

    public void setRoleid(Long roleid) {
        this.roleid = roleid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
