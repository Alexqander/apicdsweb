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
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MainSecurity extends WebSecurityConfigurerAdapter {
    @Autowired
    AuthService service;
    @Autowired
    JwtEntryPoint entryPoint;

    @Bean
    public JwtTokenFilter jwtTokenFilter(){
        return new JwtTokenFilter();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Override
    public void configure(AuthenticationManagerBuilder auth)throws Exception{
        auth.userDetailsService(service).passwordEncoder(passwordEncoder());
    }
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean()throws Exception{
        return super.authenticationManagerBean();
    }
    @Override
    public AuthenticationManager authenticationManager()throws Exception{
        return super.authenticationManager();
    }
    @Override
    public void configure(HttpSecurity http)throws Exception{
        http.cors().and().csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.POST,"/cds/auth/login").permitAll()
                .antMatchers(HttpMethod.GET,"/cds/skills/").permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(entryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }


}
