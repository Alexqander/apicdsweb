package com.cds.mx.apicds.security.jwt;

import com.cds.mx.apicds.security.model.AuthUser;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {
    public final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private int expiration;

    public String generatedToken(Authentication authentication){
        AuthUser authUser =(AuthUser) authentication.getPrincipal();
        return Jwts.builder().setSubject(authUser.getUsername()).setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime()+expiration*1000L))
                .signWith(SignatureAlgorithm.HS512,secret).compact();
    }
    public String getUsernameFromToken(String token){
        return Jwts.parser().setSigningKey(secret)
                .parseClaimsJws(token).getBody().getSubject();
    }
    public boolean validateToken(String token){
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
        }catch (MalformedJwtException e){
            logger.error("Token mal formado" + e);
        }catch (UnsupportedJwtException e){
            logger.error("Token no soportado" + e);
        }catch (ExpiredJwtException e){
            logger.error("Token Expirado" + e);
        }catch (IllegalArgumentException e){
            logger.error("Token no provisto" + e);
        }catch (SignatureException e){
            logger.error("Token en la forma del token" + e);
        }
        return false;
    }

}
