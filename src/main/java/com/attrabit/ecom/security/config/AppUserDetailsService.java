package com.attrabit.ecom.security.config;

import com.attrabit.ecom.model.Roles;
import com.attrabit.ecom.model.Users;
import com.attrabit.ecom.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AppUserDetailsService implements UserDetailsService {
    private final UsersRepository appUserRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Roles roles = new Roles();
//        roles.setPermissions("ROLE_USER");
//        List<Roles> rolesList = new ArrayList<>();
//        rolesList.add(roles);
        final Users user = appUserRepository.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException("Username not found"));
        final String permissions = user.getPermissions();
        final String[] split = permissions.split(",");

        return new User(user.getEmail(), user.getPassword(), mapToRoleAuthority(List.of(split)));
//        return null;
    }
    private Collection<GrantedAuthority> mapToRoleAuthority(List<String> roles){
//        return null;
        roles.forEach(System.out::println);
        return roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
//        return new SimpleGrantedAuthority(roles);
    }

//    "{USER.VIEW.TRUE}"
//    "{MEMBER.BUY.TRUE, MEMBER.ACCESS_DASHBOARD.TRUE}"


}
