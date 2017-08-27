package com.dbtechschool.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException; 
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.dbtechschool.model.User;
import com.dbtechschool.repository.UserRepository;
import com.dbtechschool.repository.UserRolesRepository;


@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{
    private final UserRepository userRepository;
    private final UserRolesRepository userRoleRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository,UserRolesRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findByUsername(username);
        if(null == user){
            throw new UsernameNotFoundException("No user present with username: "+username);
        }else{
            List<String> userRoles= userRoleRepository.findRoleByUserName(username);
            return new CustomUserDetails(user,userRoles);
        }
    }

}


