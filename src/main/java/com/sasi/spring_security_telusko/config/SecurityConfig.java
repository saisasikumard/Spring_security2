package com.sasi.spring_security_telusko.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //this below code we can write shortly as below....
   /*
        http.csrf(customizer->customizer.disable()); //to disable csrf validation for POST,PUT,DELETE
        http.authorizeHttpRequests(request-> request.anyRequest().authenticated()); //to authorize request
        http.httpBasic(Customizer.withDefaults()); //for security for basic validation
       // http.formLogin(Customizer.withDefaults());  //for web form loginn
        //to make stateless session(not transfer details from to another session)
        http.sessionManagement(session
                ->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();

    */
        //csrf disable code without lamdba expression.
      /*  Customizer<CsrfConfigurer<HttpSecurity>> custCsrf=new Customizer<CsrfConfigurer<HttpSecurity>>() {
            @Override
            public void customize(CsrfConfigurer<HttpSecurity> customizer) {
                customizer.disable();
            }
        };
        */
       return http.csrf(customizer-> customizer.disable())
                .authorizeHttpRequests(request->request.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }

    //for inmemeory security.
    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user1= User.withDefaultPasswordEncoder().username("kiran")
                .password("k@123")
                .build();
        UserDetails user2= User.withDefaultPasswordEncoder().username("harsh")
                .password("h@123")
                .build();
        return new InMemoryUserDetailsManager(user1,user2);
    }
}
