package com.example.hello.service;

import com.example.hello.VO.UserDetailsVO;
import com.example.hello.exception.UserNotFoundException;
import com.example.hello.repository.MemberRepository;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    private final UserRepository userResository;

    @Override
    public UserDetailsVO loadUserByUsername(String userEmail) {
        return userResository.fiindByUserEmail(userEmail).map(u -> 
        new UserDetailsVO(
            u,Collections.singleton(
                new SimpleGrantedAuthority(u.getRole().getValue())
            )
        )).orElseThrow(() -> 
        new UserNotFoundException(userEmail));
    }
    
}
