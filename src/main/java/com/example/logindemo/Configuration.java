package com.example.logindemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@org.springframework.context.annotation.Configuration
public class Configuration extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.jdbcAuthentication().dataSource(dataSource);
    }

    @Override
    protected void configure(HttpSecurity security) throws Exception{
        security.authorizeRequests().antMatchers("/h2-console/**", "/", "/login", "/css/**", "/img/**").permitAll().anyRequest()
                .authenticated().and().formLogin().loginPage("/login").defaultSuccessUrl("/startpage").permitAll().and()
                .logout().invalidateHttpSession(true).clearAuthentication(true).logoutSuccessUrl("/login").permitAll();

        security.csrf().ignoringAntMatchers("/h2-console/**");

        security.headers().frameOptions().sameOrigin();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
