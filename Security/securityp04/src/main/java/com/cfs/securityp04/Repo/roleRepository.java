package com.cfs.securityp04.Repo;

import com.cfs.securityp04.Entity.roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface roleRepository extends JpaRepository<roles, Long> {

Optional<roles> findByName(String name);
}
