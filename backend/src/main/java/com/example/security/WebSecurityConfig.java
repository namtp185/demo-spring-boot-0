package com.example.security;

import com.example.security.jwt.JwtAuthenticationFilter;
import com.example.security.user.UserDetailsServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    UserDetailsServiceImpl userDetailsServiceImpl;
    
    // @Override
    // protected void configure(HttpSecurity http) throws Exception {
    //     http
    //         .authorizeRequests()
    //             .antMatchers("/", "/home").permitAll()
    //             .anyRequest().authenticated()
    //             .and()
    //         .formLogin()
    //             .loginPage("/login")
    //             .permitAll()
    //             .and()
    //         .logout()
    //             .permitAll();
    // }

    // @Override
    // protected void configure(HttpSecurity http) throws Exception {
    //     http
    //         .cors() // reject request from different domain
    //             .and().csrf().disable()
    //         // .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    //         //     .and()
    //         .authorizeRequests()
    //             // .antMatchers("/api/v2/login").authenticated()
    //             .anyRequest().permitAll();
        
    
    //     // filter to check jwt
    //     http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    // }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .cors() // reject request from different domain
                .and().csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
            .authorizeRequests()
                .antMatchers("/v2/login").permitAll()
                .antMatchers("/v2/users/register").permitAll()
                .anyRequest().authenticated();
        
    
        // filter to check jwt
        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder managerBuilder) throws Exception {
        managerBuilder.userDetailsService(userDetailsServiceImpl)
            .passwordEncoder(passwordEncoder());
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        // Get AuthenticationManager bean
        return super.authenticationManagerBean();
    }
}
