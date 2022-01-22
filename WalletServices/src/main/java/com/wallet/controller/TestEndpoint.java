package com.wallet.controller;

import org.springframework.web.bind.annotation.GetMapping;

public interface TestEndpoint {
		@GetMapping("/testingEndpoint")
		 void testEndpoint();
}
