package com.cfs.securityp04.Entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="users")
public class appUser {

@Id
private String name ;
private String password;
    private boolean enabled;
@ManyToMany(fetch = FetchType.EAGER)
@JoinTable(
name="user-role",
joinColumns=@JoinColumn(name = "name"),
        inverseJoinColumns = @JoinColumn(name = "roleid")
)
private Set<roles> role  = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<roles> getRole() {
        return role;
    }

    public void setRole(Set<roles> role) {
        this.role = role;
    }
}
