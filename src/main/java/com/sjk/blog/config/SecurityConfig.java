package com.sjk.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//빈등록 : 스프링 컨테이너에서 객체를 관리할 수 있게 하는것

@Configuration //이 클래스를 빈으로 등록하는데 스프링 설정으로 사용하겠다.
@EnableWebSecurity //스프링 시큐리티의 기능을 활성화 하겠다. (시큐리티 필터 추가) , 이미 스프링 시큐리티가 활성화 되어 있지만, 설정을 해당 파일에서 한다.
@EnableGlobalMethodSecurity(prePostEnabled = true) //특정 주소로 접근하면 권한 및 인증을 미리 체크하겠다.
//위의 3개의 어노테이션은 세트이다.
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/auth/**") //요청에 대하여 허락한다.
                .permitAll() // /auth/** 로 들어오는 것은 누구나 들어올 수 있다.
                .anyRequest() //다른 요청들은
                .authenticated() //인증이 되야한다.
                .and() // 그리고
                .formLogin() //인증이 필요한 곳으로 요청이 오면
                .loginPage("/auth/loginForm"); //로그인 페이지가 뜬다.(로그인 커스터마이징) -> 기본 로그인 화면 교체

    }

}