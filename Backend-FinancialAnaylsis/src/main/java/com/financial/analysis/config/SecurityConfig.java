package com.financial.analysis.config;

import com.financial.analysis.service.user.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    CustomUserService userService;


//    private static final String[] RESOURCE_LOCATIONS = { "classpath:/static/"    };
//
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry
//                .addResourceHandler("/**")
//                .addResourceLocations(RESOURCE_LOCATIONS)
//                //.setCachePeriod(3600)
//                .resourceChain(true)
//                .addResolver(new PathResourceResolver());
//    }


    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        // In-Memory
        auth.inMemoryAuthentication().withUser("yjlee").password(passwordEncoder().encode("jun1234")).authorities("USER", "ADMIN");

        // Database Auth
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    //WebSecurity가 HttpSecurity보다 우선적으로 고려됨 (인증, 인가 둘 다 검증 안함)
    @Override
    public void configure(WebSecurity web) throws Exception {
        // 정적 자원에 대해서는 Security 설정을 적용하지 않는다.
        web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }

    // antMatcher에 있는 endPoint에 대한 인증 만 무시한다.
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // cors 문제 및 csrf 인증 필요
        http.cors().and()
                .csrf().disable().authorizeRequests();

        http.authorizeRequests()
                .antMatchers("/dashboard").authenticated()
                .antMatchers("/login").permitAll()
        ;

        http.httpBasic();

        // 로그인 형태를  spring security에서 제공해 주는 폼이 아닌 새로운 form 로그인 형태로 바꾼다
        http.formLogin()
                .loginPage("/login") // 사용자 정의 로그인 페이지
                .usernameParameter("username")
                .passwordParameter("password")
                //.defaultSuccessUrl("/dashboard") // 로그인 성공 시 이동할 URL
                .failureUrl("/loginfail")
                .permitAll()
        ;

    }
}
