package com.hwx.Comp;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Map;

@Component
public class MyJWT {
  private  static  final  String   salt="!@GH*)#$%J(+?";
//  获取token
  public  String  GetJwt(Map<String,String> map){
      Calendar calendar=Calendar.getInstance();
      calendar.add(Calendar.DATE,7);
      JWTCreator.Builder builder= JWT.create();
      builder.withExpiresAt(calendar.getTime());
      map.forEach((k,v)->{
                  builder.withClaim(k,v);
      });
      return  builder.sign(Algorithm.HMAC256(salt));
  }

//  验证
    public DecodedJWT yanz(String token){
       DecodedJWT jwt=JWT.require(Algorithm.HMAC256(salt)).build().verify(token);
       return  jwt;
    }
}
