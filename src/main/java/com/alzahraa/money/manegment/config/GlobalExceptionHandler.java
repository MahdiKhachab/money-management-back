package com.alzahraa.money.manegment.config;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Turns service exceptions into JSON responses of the form { "message": "..." }
 * so the frontend can show a meaningful error instead of a raw 500 page.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<Map<String, String>> handleAccessDenied(AccessDeniedException ex) {
		return body(HttpStatus.FORBIDDEN, "Access denied");
	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Map<String, String>> handleRuntime(RuntimeException ex) {
		String message = ex.getMessage() != null ? ex.getMessage() : "Unexpected error";
		String lower = message.toLowerCase();

		if (lower.contains("invalid credentials")) {
			return body(HttpStatus.UNAUTHORIZED, message);
		}
		if (lower.contains("not found")) {
			return body(HttpStatus.NOT_FOUND, message);
		}
		if (lower.contains("already exists")) {
			return body(HttpStatus.CONFLICT, message);
		}
		return body(HttpStatus.BAD_REQUEST, message);
	}

	private ResponseEntity<Map<String, String>> body(HttpStatus status, String message) {
		return ResponseEntity.status(status).body(Map.of("message", message));
	}
}
