package com.esme.auth.service;

import com.esme.auth.entity.UserAccount;
import com.esme.auth.repository.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserAccountRepository userRepository;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return userAccountRepository.findByUsername(username)
//                .map(SecurityUser::new)
//                .orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserAccount> optionalUserAccount = userRepository.findByUsername(username);
        if (optionalUserAccount.isEmpty()) {
            throw new UsernameNotFoundException("Access Denied");
        }
        UserAccount user = optionalUserAccount.get();
        Collection<GrantedAuthority> authorities = new HashSet<>();
        user.getAuthorities().forEach(auth -> authorities.add(new SimpleGrantedAuthority(auth.getName())));
        return new User(user.getUsername(), user.getPassword(), user.getEnabled(), user.getAccountNonExpired(),
                user.getCredentialsNonExpired(), user.getAccountNonLocked(), authorities);
    }
}
