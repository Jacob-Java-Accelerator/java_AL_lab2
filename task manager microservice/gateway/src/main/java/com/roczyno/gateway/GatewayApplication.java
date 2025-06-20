package com.roczyno.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import reactor.core.publisher.Mono;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.time.LocalDateTime;

@SpringBootApplication
@RestController
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	// Rate Limiting Configuration Beans
	@Bean
	public KeyResolver userKeyResolver() {
		return exchange -> {
			// Rate limit by user ID from JWT token or IP address
			String userKey = exchange.getRequest().getHeaders().getFirst("Authorization");
			if (userKey == null) {
				userKey = exchange.getRequest().getRemoteAddress().getAddress().getHostAddress();
			}
			return Mono.just(userKey);
		};
	}

	@Bean
	public KeyResolver taskKeyResolver() {
		return exchange -> {
			// Rate limit by user ID from JWT token or IP address
			String userKey = exchange.getRequest().getHeaders().getFirst("Authorization");
			if (userKey == null) {
				userKey = exchange.getRequest().getRemoteAddress().getAddress().getHostAddress();
			}
			return Mono.just(userKey);
		};
	}

	@Bean
	public KeyResolver submissionKeyResolver() {
		return exchange -> {
			// Rate limit by user ID from JWT token or IP address
			String userKey = exchange.getRequest().getHeaders().getFirst("Authorization");
			if (userKey == null) {
				userKey = exchange.getRequest().getRemoteAddress().getAddress().getHostAddress();
			}
			return Mono.just(userKey);
		};
	}

	// Fallback endpoints
	@GetMapping("/fallback/task")
	public ResponseEntity<String> taskServiceFallback(@RequestParam(required = false) String path) {
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode response = mapper.createObjectNode();
		
		response.put("timestamp", LocalDateTime.now().toString());
		response.put("status", "SERVICE_UNAVAILABLE");
		response.put("message", "Task Service is currently unavailable. Please try again later.");
		response.put("path", path != null ? path : "/api/v1/task");
		response.put("error", "Circuit Breaker Activated");
		
		return ResponseEntity
			.status(HttpStatus.SERVICE_UNAVAILABLE)
			.contentType(MediaType.APPLICATION_JSON)
			.body(response.toString());
	}

	@GetMapping("/fallback/user")
	public ResponseEntity<String> userServiceFallback(@RequestParam(required = false) String path) {
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode response = mapper.createObjectNode();
		
		response.put("timestamp", LocalDateTime.now().toString());
		response.put("status", "SERVICE_UNAVAILABLE");
		response.put("message", "User Service is currently unavailable. Please try again later.");
		response.put("path", path != null ? path : "/api/v1/user");
		response.put("error", "Circuit Breaker Activated");
		
		return ResponseEntity
			.status(HttpStatus.SERVICE_UNAVAILABLE)
			.contentType(MediaType.APPLICATION_JSON)
			.body(response.toString());
	}

	@GetMapping("/fallback/submission")
	public ResponseEntity<String> submissionServiceFallback(@RequestParam(required = false) String path) {
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode response = mapper.createObjectNode();
		
		response.put("timestamp", LocalDateTime.now().toString());
		response.put("status", "SERVICE_UNAVAILABLE");
		response.put("message", "Submission Service is currently unavailable. Please try again later.");
		response.put("path", path != null ? path : "/api/v1/submissions");
		response.put("error", "Circuit Breaker Activated");
		
		return ResponseEntity
			.status(HttpStatus.SERVICE_UNAVAILABLE)
			.contentType(MediaType.APPLICATION_JSON)
			.body(response.toString());
	}

	// Rate limit exceeded fallback
	@GetMapping("/fallback/rate-limit")
	public ResponseEntity<String> rateLimitFallback(@RequestParam(required = false) String path) {
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode response = mapper.createObjectNode();
		
		response.put("timestamp", LocalDateTime.now().toString());
		response.put("status", "TOO_MANY_REQUESTS");
		response.put("message", "Rate limit exceeded. Please try again later.");
		response.put("path", path != null ? path : "/api");
		response.put("error", "Rate Limiter Activated");
		
		return ResponseEntity
			.status(HttpStatus.TOO_MANY_REQUESTS)
			.contentType(MediaType.APPLICATION_JSON)
			.body(response.toString());
	}
}
