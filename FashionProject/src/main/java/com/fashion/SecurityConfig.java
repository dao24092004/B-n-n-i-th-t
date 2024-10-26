package com.fashion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.fashion.sevice.CustomUserDetailSevice;



@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private CustomUserDetailSevice customUserDetailService;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(csrf -> csrf.disable())
            .authorizeHttpRequests((auth) -> auth
                .requestMatchers("/**").permitAll()
                .requestMatchers("/admin/**").permitAll()
             //  .requestMatchers("/admin/**").hasAuthority("ADMIN")
                .anyRequest().authenticated())
            .formLogin(login -> login
                .loginPage("/logon")  // Add the leading slash to indicate the correct path
                .loginProcessingUrl("/logon")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/admin", true)).logout(logout -> logout.logoutUrl("/admin-logout").logoutSuccessUrl("/logon"))
            .logout(logout->logout.logoutUrl("/admin-logout").logoutSuccessUrl("/logon"));

        return httpSecurity.build();
    }
    
    @Bean
    WebSecurityCustomizer webSecurityCustomizer() {
    	return(web)->web.ignoring().requestMatchers("/static/**","/fe/**","/assets/**","uploads/**") ;
    }
    
    @Bean
    BCryptPasswordEncoder passwordEncoder() {
    	return new BCryptPasswordEncoder();
    }

	public CustomUserDetailSevice getCustomUserDetailService() {
		return customUserDetailService;
	}

	public void setCustomUserDetailService(CustomUserDetailSevice customUserDetailService) {
		this.customUserDetailService = customUserDetailService;
	}
}
