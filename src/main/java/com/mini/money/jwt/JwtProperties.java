package com.mini.money.jwt;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Getter
@ConstructorBinding
@Component
@ToString
public class JwtProperties {
  @Value("${jwt.issuer}") //JWT 토큰 발급자를 추가하기 위한 값을 입력합니다.
  private String issuer;
  @Value("${jwt.secretKey}") //JWT 의 Signatuer 를 해싱할 때 사용되는 비밀 키이다. 영어로 원하는 단어를 적어주면 된다.
  private String secretKey;
  @Value("${jwt.tokenPrefix}") //토큰 앞에 붙는 정해진 형식이다. 꼭 Bearer 뒤에 한 칸 공백을 넣어줘야 한다.
  private String tokenPrefix;

}
