package org.sid.spring_security.serc;

import org.sid.spring_security.serc.entities.AppRole;
import org.sid.spring_security.serc.entities.AppUser;
import org.sid.spring_security.serc.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private  AccountService accountService;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().frameOptions().disable(); //  POUR DATABASE  H2
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
      //  http.authorizeRequests().anyRequest().permitAll();
      //  http.formLogin();
        http.authorizeRequests().antMatchers("/h2console/**").permitAll();
        http.authorizeRequests().anyRequest().authenticated();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.userDetailsService(new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                AppUser appUser = accountService.loadUserByUserName(username);
                Collection<GrantedAuthority> authorities = new ArrayList<>();
                Consumer<AppRole> appRoleConsumer = r -> {
                    authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
                };
                appUser.getAppRoles().forEach(appRoleConsumer);
                return new User(appUser.getUserName(),appUser.getPassword(),authorities);

            }
        });
    }
}
