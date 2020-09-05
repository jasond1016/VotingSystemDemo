package vsd.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import vsd.enums.Constants;

import java.util.Date;

/**
 * @author JasonW
 * @date 2020/8/31
 */
public class JwtUtils {
    private static final Logger log = LoggerFactory.getLogger(JwtUtils.class);

    public static String createToken(String username) {
        String token = Strings.EMPTY;
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            token = JWT.create()
                    .withIssuer("auth0")
                    .withSubject(username)
                    .withIssuedAt(new Date())
                    .withExpiresAt(new Date(System.currentTimeMillis() + (5 * 60 * 1000)))
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            //Invalid Signing configuration / Couldn't convert Claims.
            log.warn("error in creating jwt token.");
        }
        return token;
    }

    public static DecodedJWT verifyAndDecodeToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256("secret");
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("auth0")
                .acceptExpiresAt(300L)
                .build(); //Reusable verifier instance
        if (StringUtils.startsWithIgnoreCase(token, Constants.JWT_PRIFIX)) {
            token = token.replace(Constants.JWT_PRIFIX, Strings.EMPTY);
        }
        DecodedJWT jwt = verifier.verify(token);
        return jwt;
    }

    public static DecodedJWT decodeToken(String token) {
        return JWT.decode(token);
    }
}
