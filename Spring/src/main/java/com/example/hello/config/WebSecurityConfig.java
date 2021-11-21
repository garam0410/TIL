package com.example.hello.config;

import com.example.hello.security.CustomAuthenticationFilter;
import com.example.hello.security.CustomAuthenticationProvider;
import com.example.hello.security.CustomLoginSuccessHandler;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
     
    // 정적 자언에 대해서는 Security 설정을 적용하지 않음
    @Override
    public void configure(WebSecurity web){
        web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable().authorizeRequests()
        // about 요청에 대해서 로그인 요구
        .antMatchers("/about").authenticated()
        // admin 요청에 대해서 ROLE_ADMIN 역할 가지고 있어야함
        .antMatchers("/admin").hasRole("ADMIN")
        // 나머지요청에는 로그인 요구 X
        .anyRequest().permitAll()
        .and()

    // 로그인 하는 경우
    .formLogin()
        // 로그인 페이지 제공
        .loginPage("/user/loginView")
        // 로그인 성공시 url
        .successForwardUrl("/index")
        // 로그인 실패시 url
        .failureUrl("/index")
        .permitAll()
        .and()
        .addFilterBefore(customAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CustomAuthenticationFilter customAuthenticationFilter() throws Exception{
        CustomAuthenticationFilter customAuthenticationFilter
            = new CustomAuthenticationFilter(authenticationManager());
        
        customAuthenticationFilter.setFilterProcessesUrl("/user/login");

        customAuthenticationFilter.setAuthenticationSuccessHandler(customLoginSuccessHandler());

        customAuthenticationFilter.afterPropertiesSet();

        return customAuthenticationFilter;
    }

    @Bean
    public CustomLoginSuccessHandler customLoginSuccessHandler(){
        return new CustomLoginSuccessHandler();
    }

    @Bean
    public CustomAuthenticationProvider customAuthenticationProvider(){
        return new CustomAuthenticationProvider(bCryptPasswordEncoder());
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder){
        authenticationManagerBuilder.authenticationProvider(customAuthenticationProvider());
    }
}
