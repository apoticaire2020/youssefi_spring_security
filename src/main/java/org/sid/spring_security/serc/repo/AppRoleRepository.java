package org.sid.spring_security.serc.repo;

import org.sid.spring_security.serc.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface AppRoleRepository extends JpaRepository<AppRole , Long> {
    AppRole findByRoleName (String roleName);
}
