package cafemanage.jwt;

import java.util.Date;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JWTProvider {
	private final String JWT_SECRET = "cainaylabimatkhongaiduocbiet";//
	private final long JWT_EXPIRATION = 604800000L;// thoigianhieuluc

	// Tạo ra jwt từ thông tin user
	public String generateToken(UserDetails userDetails) {
		Date now = new Date();
		Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);
		// Tạo chuỗi json web token từ username của user.
		return Jwts.builder().setSubject(userDetails.getUsername()).setIssuedAt(now).setExpiration(expiryDate)
				.signWith(SignatureAlgorithm.HS512, JWT_SECRET).compact();
	}

	// Lấy thông tin user từ jwt
	public String getUserNameFromJWT(String token) {
		Claims claims = Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token).getBody();

		return claims.getSubject();
	}
	
	public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException ex) {
            ex.printStackTrace();
        } catch (ExpiredJwtException ex) {
        	ex.printStackTrace();
        } catch (UnsupportedJwtException ex) {
        	ex.printStackTrace();
        } catch (IllegalArgumentException ex) {
        	ex.printStackTrace();
        }
        return false;
    }
	
}
