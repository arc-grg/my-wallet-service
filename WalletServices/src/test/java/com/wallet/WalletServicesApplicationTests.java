package com.wallet;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WalletServicesApplicationTests {

	Calculator c = new Calculator();
	int expected = 15;

	@Test
	public void testSum() {

		int actual = c.sum(5, 10);
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	public void testMul() {
		int expected = 50;
		int actual = c.mul(5, 10);
		assertThat(expected).isEqualTo(actual);
	} 
	@Test
	@Disabled//To skip for testing
	public void testCompare() {
		boolean compare = c.compare(10, 10);
		assertThat(compare).isTrue();
	}
	
	
	
	
	@BeforeEach
	private void tearDown() {
		// TODO Auto-generated method stub
		System.out.println("Started");
	}

	@AfterEach
	private void setUp() {
		// TODO Auto-generated method stub
System.out.println("Done");
	}

}
