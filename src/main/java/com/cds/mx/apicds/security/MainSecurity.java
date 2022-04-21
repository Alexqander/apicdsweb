package com.cds.mx.apicds.security;

import com.cds.mx.apicds.security.controller.AuthService;
import com.cds.mx.apicds.security.jwt.JwtEntryPoint;
import com.cds.mx.apicds.security.jwt.JwtTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MainSecurity extends WebSecurityConfigurerAdapter {
    @Autowired
    AuthService authService;
    @Autowired
    JwtEntryPoint entryPoint;

    @Bean
    public JwtTokenFilter jwtTokenFilter() {
        return new JwtTokenFilter();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authService).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public AuthenticationManager authenticationManager() throws Exception{
        return super.authenticationManager();
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/cds/auth/**").permitAll()
                .antMatchers(HttpMethod.POST, "/cds/user/**").permitAll()
                .antMatchers(HttpMethod.GET, "/cds/convocatorias/**").permitAll()
                .antMatchers(HttpMethod.GET, "/cds/proyectos/").permitAll()
                .antMatchers(HttpMethod.POST, "/cds/proyectos/").permitAll()
                .antMatchers(HttpMethod.GET, "/cds/convocatorias/").permitAll()
                .antMatchers(HttpMethod.GET, "/cds/exportCv/**").permitAll()
                .antMatchers(HttpMethod.GET, "/cds/person/**").permitAll()
                .antMatchers(HttpMethod.POST, "/cds/person/").permitAll()
                .antMatchers(HttpMethod.PUT, "/cds/person/**").permitAll()
                .antMatchers(HttpMethod.POST, "/cds/assets/upload").permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(entryPoint)
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }

}
