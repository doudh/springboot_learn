package com.doudh.utils;

import io.jsonwebtoken.*;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.Base64;
import java.util.Date;

/**
 * JWT 工具类
 */
@Configuration
public class JwtUtil {

    @Value("${jwt.expire}")
    private int expire;
    @Value("${jwt.key}")
    private String key;

    /**
     * 密钥加密token
     *
     * @param id  登录用户的id    username   登录名
     * @param priKey
     * @param expire
     * @return
     * @throws Exception
     */
    public String createToken(String id,String username){
        JwtBuilder builder = Jwts.builder().setId(id)
                .setSubject(username)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS512, Base64.getEncoder().encodeToString(key.getBytes()));
        if (expire > 0) {
            builder.setExpiration(DateTime.now().plusSeconds(expire).toDate());
        }
        return builder.compact();
    }

    /**
     * 获取用户id
     * @param token
     * @param key
     * @return
     * @throws Exception
     */
    public String getDoctorId(String token){
        Jws<Claims> claimsJws = parserToken(token);
        Claims body = claimsJws.getBody();
        return String.valueOf(body.getId());
    }

    /**
     * 获取登陆名
     * @param token
     * @param key
     * @return
     * @throws Exception
     */
    public String getUserName(String token){
        Jws<Claims> claimsJws = parserToken(token);
        Claims body = claimsJws.getBody();
        return String.valueOf(body.getSubject());
    }

    /**
     * 解析token
     * @param token
     * @return
     * @throws Exception
     */
    private Jws<Claims> parserToken(String token){
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(Base64.getEncoder().encodeToString(key.getBytes())).parseClaimsJws(token);
        return claimsJws;
    }


}
