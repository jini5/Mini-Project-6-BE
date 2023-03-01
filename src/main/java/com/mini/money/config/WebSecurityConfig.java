package com.mini.money.config;


import com.mini.money.jwt.JwtFilter;
import com.mini.money.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Collections;
import java.util.List;


@RequiredArgsConstructor
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfig {

  private static final String[] PUBLIC_URLS = { //이 URL은 권한 검사안함
          "**/signup", "**/login" , "**/logout", "/finance/loan", "/finance/recommend/loan",
          "/finance/itemlist/**", "/finance/loan/detail", "/swagger-resources/**", "/swagger-ui.html","/swagger-ui/**",
          "/v2/api-docs", "/webjars/**","/v3/api-docs**"
  };

  private final JwtProvider jwtProvider;
  private final JwtFilter jwtFilter;//시큐리티 필터는 보호막같은 것.

  @Bean
  public PasswordEncoder passwordEncoderParser() {
    //회원 insert 서비스에서 비밀번호 암호화/복호화에 사용됨
    //DB에 비밀번호를 plain text 그대로 저장한다면 보안상 위험이 따름으로 암호화해서 저장해야한다.
    //PasswordEncoder는 BCryptPasswordEncoder가 사용되며 앞에 {id}로 PasswordEncoder 유형이 정의된다.
    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http)throws Exception{

    return http
            .cors()
            .and()

            .authorizeRequests()// 다음 리퀘스트에 대한 사용권한 체크
            .mvcMatchers(PUBLIC_URLS).permitAll() // 가입 및 인증 주소는 누구나 접근가능

            .and()

            .authorizeRequests()// 다음 리퀘스트에 대한 사용권한 체크
            .anyRequest().authenticated()// 그외 나머지 요청은 모두 인증된 회원만 접근 가능
            .and()
            .csrf().disable() // rest api이므로 csrf 보안이 필요없으므로 disable처리
            .httpBasic().disable() // 기본설정 사용안함. 기본설정은 비인증시 로그인폼 화면으로 리다이렉트 된다.
//            .formLogin().loginPage("/index").permitAll()//로그인 기본 url 설정
//            .and()

            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // jwt token으로 인증할것이므로 세션필요없으므로 생성안함.

            .and()

            .addFilterBefore(
            jwtFilter,
            UsernamePasswordAuthenticationFilter.class).build();
            //인증을 처리하는 기본필터 UsernamePasswordAuthenticationFilter 대신 별도의 인증 로직을 가진 필터를 생성하고 사용하고 싶을 때 아래와 같이 필터를 등록하고 사용
  }

  @Bean
  public WebSecurityCustomizer webSecurityCustomizer() { //시큐리티 filter 제외, 그러나 OncePerRequestFilter는 시큐리티 필터가 아니라서 로직실행
    //WebSecurityConfigurerAdapter 가 사용되지 않기 떄문에 SecurityFilterChain, WebSecurityCustomizer Bean으로 등록하여 Security 설정을 진행하였다.
    //- WebSecurityCustomizer 부분은 PUBLIC_URLS 가 필터 적용이 제외되도록 하는 코드이다.
    return (web) -> web.ignoring().mvcMatchers(PUBLIC_URLS);
  }

  @Bean
  public CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration configuration = new CorsConfiguration();

    configuration.setAllowedOriginPatterns(Collections.singletonList("*")); // 모든 Origin에서의 요청을 허용
    configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")); // 해당 Http Methods를 사용하는 요청을 허용
    configuration.setAllowedHeaders(List.of("authorization", "content-type", "x-auth-token")); // 해당 헤더를 사용하는 요청을 허용
    configuration.setExposedHeaders(Collections.singletonList("x-auth-token")); // 헤더에 CSRF 토큰이 있는 요청에 대해 모든 응답 헤더를 노출
    configuration.setAllowCredentials(true); // 사용자 자격 증명(쿠키, 인증키) 사용을 허용할 것

    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration); // 모든 URL에 대해 위의 설정을 사용해 CORS 처리를 할 것
    return source;
  }


}
