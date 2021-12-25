package com.example.hello.VO;

import java.util.Collection;

import com.example.hello.domain.Member;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Delegate;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class UserDetailsVO implements UserDetails {

    @Delegate
    private final UserVO userVO;
    private final Collection<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return authorities;
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return userVO.getUserPw();
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return userVO.getUserEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return userVO.getIsEnabled();
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return userVO.getIsEnabled();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return userVO.getIsEnabled();
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return userVO.getIsEnabled();
    }
    
}
