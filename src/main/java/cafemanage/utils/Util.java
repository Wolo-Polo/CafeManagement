package cafemanage.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Util {
	public static void main(String[] args) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		System.out.println(passwordEncoder.encode("1234"));
	}
}
