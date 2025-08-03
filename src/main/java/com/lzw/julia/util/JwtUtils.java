package com.lzw.julia.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

public class JwtUtils {
    private static final String SECRET = "fdasfdsa456fd123af45reajulia";

    private static final String ISSUER = "julia-official";

    private static final Algorithm ALGORITHM = Algorithm.HMAC256(SECRET);

    private static final String CREDENTIAL = "credential";

    public static final JWTVerifier VERIFIER = JWT.require(ALGORITHM).withIssuer(ISSUER).build();

    public static String createToken(String credential) {
        return JWT.create()
                .withIssuer(ISSUER)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 15)) // 有效期15天
                .withClaim(CREDENTIAL, credential)
                .sign(ALGORITHM);
    }

    public static String parseToken(String token) {
        DecodedJWT decodedJWT;
        try {
           decodedJWT = VERIFIER.verify(token);
        } catch (JWTVerificationException e) {
            return null;
        }
        // 如果JWT已失效
        if(decodedJWT.getExpiresAt().before(new Date())) {
            return null;
        }
        return decodedJWT.getClaim(CREDENTIAL).asString();
    }

    private JwtUtils() {}
}
