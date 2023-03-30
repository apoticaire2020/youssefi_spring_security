package org.sid.spring_security.serc.web;

import org.sid.spring_security.serc.entities.AppUser;
import org.sid.spring_security.serc.service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountRestController {
    private AccountService service;

    public AccountRestController(AccountService service) {
        this.service = service;
    }
@GetMapping(path = "/users")
    public List<AppUser> userList(){
       return service.listUsers();
    }
}
