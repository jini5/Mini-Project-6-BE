package com.mini.money.jwt;

import com.mini.money.dto.LogInReqDTO;
import com.mini.money.entity.Customer;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtProvider {
    //토큰을 발급하거나, 토근을 유저 객체로 바꾸는 클래스
    private final JwtProperties jwtProperties;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    //토큰 발급, 로그인 서비스에서 사용
    public String makeToken(Customer customer){
        //토큰 발급 시기를 생각해보면 토큰은 로그인하고나서 (findByEmailAndPassword) 실행후이므로 실행 결과값은 Optional<entity>가 나온다.
        // 그것을 넣어야 하기 때문에 entity 인 Customer객체가 매개변수로 들어간다.
        // 토큰은 문자열이므로 반환값은 String 이 된다.
        Date date=new Date();

        return Jwts.builder()
                .setHeaderParam("typ","JWT")
                .setIssuer(jwtProperties.getIssuer()) //발급자
                .setIssuedAt(date) //토큰 발급 시간
                .setExpiration(new Date(date.getTime() + Duration.ofMinutes(30).toMillis())) //토큰유지기간
                .claim("email",customer.getEmail()) //entity정보
                .signWith(SignatureAlgorithm.HS256,jwtProperties.getSecretKey())
                .compact();
    }


    //토큰에서 userDTO로 바꿈, jwt필터에서 사용, 유효성검사 해야한다
    public LogInReqDTO tokenToUser(String token){
        Claims claims= null;

        if(token!=null) {
            try{
                if(validationAuthorizationHeader(token)){

                    token = extractToken(token);
                    claims = parsingToken(token);
                    return new LogInReqDTO(claims);
            }

            }catch (Exception e){
                return null;
            }
        }else{
            return null;
        }

        return null;
    }
    private Claims parsingToken(String token) {
        //Token 값을 claims로 바꿔주는 메서드
        //jwt필터에서 시큐리티 필터로 넘어가기전에 토큰을 시큐리티 필터가 알수 있게 바꿔준다고 생각
        return Jwts.parser()
                .setSigningKey(jwtProperties.getSecretKey())
                .parseClaimsJws(token)
                .getBody();
    }
    private boolean validationAuthorizationHeader(String header) { //헤더값이 유효한지 검증하는 메서드

        if (header == null || !header.startsWith(jwtProperties.getTokenPrefix())) {
            return false;
        }
        return true;
    }

    private String extractToken(String authorizationHeader) { //토큰 (Bearer) 떼고 토큰값만 가져오는 메서드
        return authorizationHeader.substring(jwtProperties.getTokenPrefix().length());
    }

}
