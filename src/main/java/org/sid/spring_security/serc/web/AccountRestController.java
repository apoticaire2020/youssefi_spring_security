package org.sid.spring_security.serc.web;

import lombok.Data;
import org.sid.spring_security.serc.entities.AppRole;
import org.sid.spring_security.serc.entities.AppUser;
import org.sid.spring_security.serc.service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    @PostMapping(path = "/users")
    public  AppUser saveUser(@RequestBody AppUser user){
        return  service.addNewUser(user);
    }
    @PostMapping(path = "/roles")
    public AppRole saveUser(@RequestBody AppRole role){
        return  service.addNewRole(role);
    }
    @PostMapping(path = "/addRoleToUser")
    public void addRoleToUser(@RequestBody RoleUserForm roleUserForm){
          service.addRoleToUser(roleUserForm.getUsername(),roleUserForm.getRoleName());
    }
}
@Data
class RoleUserForm{
    private String username;
    private  String roleName;
}
