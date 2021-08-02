package com.mallorcaWorks.service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.mallorcaWorks.model.Role;
import com.mallorcaWorks.model.User;
import com.mallorcaWorks.repository.GrandMasterRepo;
import com.mallorcaWorks.repository.TeacherRepo;
import com.mallorcaWorks.repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findById(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new CustomUserDetails(user);
    }

    static final class CustomUserDetails implements UserDetails {

        private final String username;
        private final String password;
        private final List<GrantedAuthority> roles;

        public CustomUserDetails(User user) {
            username = user.getUsername();
            password = user.getPassword();
            roles = Collections.unmodifiableList(AuthorityUtils.createAuthorityList(user.getRole().getValue()));
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return roles;
        }

        @Override
        public String getPassword() {
            return password;
        }

        @Override
        public String getUsername() {
            return username;
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }

    }

    
}
