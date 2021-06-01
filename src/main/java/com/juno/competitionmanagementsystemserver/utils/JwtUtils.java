package com.juno.competitionmanagementsystemserver.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.juno.competitionmanagementsystemserver.model.Tokens;
import com.juno.competitionmanagementsystemserver.model.User;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.Date;

public class JwtUtils {
    /**
     * 加密密码
     *
     * @param {String} password
     * @return {String} result
     */
    public static String hash(String password) {
        String salt = BCrypt.gensalt(10);
        return BCrypt.hashpw(password, salt);
    }

    /**
     * 验证加密密码
     *
     * @param {String} password
     * @param {String} hashPassword
     * @returns {Boolean}
     */
    public static boolean verifypw(String password, String hashPassword) {
        return BCrypt.checkpw(password, hashPassword);
    }

    /**
     * 创建 Token 串
     *
     * @param {tokenPayload} payload
     */
    public static String getToken(User user) {
        return JWT.create()
                .withClaim("userId", user.getId())
                .withClaim("role", user.getManageId())
                .withExpiresAt(new Date(System.currentTimeMillis() + 3600 * 24 * 14))
                .sign(Algorithm.HMAC256("99bd68c7-1da2-4cfc-809b-d1661e96579d"));
    }

    /**
     * 创建 PreToken 串
     *
     * @param {tokenPayload} payload
     */
    public static String getPreToken(User user) {
        return JWT.create()
                .withClaim("userId", user.getId())
                .withClaim("isPreLogin", "true")
                .withExpiresAt(new Date(System.currentTimeMillis() + 3600000))
                .sign(Algorithm.HMAC256("99bd68c7-1da2-4cfc-809b-d1661e96579d"));
    }

    /**
     * 解析 Token
     *
     * @param {tokenPayload} token
     */
    public static DecodedJWT verifyToken(String token) throws JWTVerificationException, IllegalArgumentException {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256("99bd68c7-1da2-4cfc-809b-d1661e96579d")).build();
        return verifier.verify(token);
    }
}
