package com.example.demo.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenUtil {
    private static final long EXPIRE_DATE = 30 * 60 * 100000;

    private static final String TOKEN_SECRET = "ZCEQIUBFKSJBFJH2020BQWE";

    public static String token(String email, String pwd){

        Date date = new Date(System.currentTimeMillis() + EXPIRE_DATE);
        Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
        Map<String, Object> header = new HashMap<>();
        header.put("typ","JWT");
        header.put("alg","HS256");
        return JWT.create()
                .withHeader(header)
                .withClaim("email",email)
                .withClaim("pwd",pwd)
                .sign(algorithm);
    }

    public static boolean verify(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public static String getEmail(String token){
        if (verify(token)) {
            String email = "";
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            email = jwt.getClaim("email").asString();
            return email;
        }
        else return "";
    }

}
