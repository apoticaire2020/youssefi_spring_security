package org.sid.spring_security.serc.service;

import org.sid.spring_security.serc.entities.AppRole;
import org.sid.spring_security.serc.entities.AppUser;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AccountService {
    AppUser addNewUser (AppUser appUser);
    AppRole addNewRole (AppRole appRole);
    void addRoleToUser(String username , String rolename);
    AppUser loadUserByUserName(String username);
    List<AppUser> listUsers ();

}
