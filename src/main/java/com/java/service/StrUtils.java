package com.java.service;

import java.net.URLEncoder;
import java.util.Base64;
import java.util.UUID;

public class StrUtils {
	public static String encode64(String text) {
		return Base64.getEncoder().encodeToString(text.getBytes());
	}

	public static String decode64(String encodedText) {
		return new String(Base64.getDecoder().decode(encodedText));
	}

	public static String encodeUrl(String queryString) {
		try {
			return URLEncoder.encode(queryString, "utf-8");
		} catch (Exception e) {
			return queryString;
		}
	}

	public static String getId() {
		return Integer.toHexString(UUID.randomUUID().hashCode());
	}
}
