package com.wallet.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/first")
public class TestEndPointImpl implements TestEndpoint {

	@Override
	public void testEndpoint() {
		System.out.println("EndPoint Tested");
		//
	}

}
