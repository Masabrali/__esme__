package com.esme.calender.configurations;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class JwtRoleConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

    @Override
    public Collection<GrantedAuthority> convert(Jwt jwt) {
        @SuppressWarnings("unchecked")
        List<String> roles = (ArrayList<String>) jwt.getClaims().get("authorities");
        System.out.println("##### Claims : {}" + jwt.getClaims());
        if (roles == null || roles.isEmpty()) {
            return new ArrayList<>();
        }

        return roles.stream().map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}