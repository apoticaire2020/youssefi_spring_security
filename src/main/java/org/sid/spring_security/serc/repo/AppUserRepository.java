package org.sid.spring_security.serc.repo;

import org.sid.spring_security.serc.entities.AppRole;
import org.sid.spring_security.serc.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface AppUserRepository extends JpaRepository<AppUser , Long> {
    AppUser findByUserName (String usename);
}
