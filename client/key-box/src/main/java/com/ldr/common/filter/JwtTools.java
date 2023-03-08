package com.ldr.common.filter;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @summary【JWT创建与解析】工具
 * @author 高振中
 * @date 2021-02-01 20:20:20
 **/
public class JwtTools {

	private static final Long timeLimit = 1000 * 60 * 60 * 24L;// 1天
	private static final String PRIVATE_KEY = "privateKey";// 私钥
	private static final String SUBJECT = "znk";// 私钥

	public static String createToken(String userid) {
		return createToken(userid, SUBJECT, new HashMap<>());
	}

	public static String createToken(String userid, String subject) {
		return createToken(userid, subject, new HashMap<>());
	}

	public static String createToken(String userid, String subject, Map<String, Object> map) {

		Date now = new Date();
		long expMillis = now.getTime() + timeLimit;
		Date expDate = new Date(expMillis);

		JwtBuilder builder = Jwts.builder().setId(userid)// UUID
				.setSubject(subject) // 主题
				.setIssuer("Java1234") // 签发者
				.setIssuedAt(now) // 签发时间
				.signWith(SignatureAlgorithm.HS256, generalKey()) // 签名算法以及密匙
				.setExpiration(expDate); // 过期时间
		for (String key : map.keySet()) {
			builder.claim(key, map.get(key));
		}
		return builder.compact();
	}

	public static Claims parseToken(String token) {
		return Jwts.parser().setSigningKey(generalKey()).parseClaimsJws(token).getBody();
	}

	public static Long getUserId(String token) {
		return Long.valueOf(Jwts.parser().setSigningKey(generalKey()).parseClaimsJws(token).getBody().get("jti").toString());
	}

	/**
	 * 判断token是否过期
	 */

	public static Boolean isTokenExpired(Claims claims) {
		Date date = claims.getExpiration();
		boolean result = true;
		if (date != null) {
			result = date.before(new Date());
		}
		return result;
	}

	private static SecretKey generalKey() {
		byte[] encodedKey = Base64.getDecoder().decode(PRIVATE_KEY);
		return new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
	}

}
