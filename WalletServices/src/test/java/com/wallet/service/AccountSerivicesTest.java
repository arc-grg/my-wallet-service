package com.wallet.service;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.wallet.dao.AccountRepository;
import com.wallet.entity.AccountEntity;
@ExtendWith(MockitoExtension.class)
class AccountSerivicesTest {
	@Mock
	AccountRepository accountRepository;
	
	AccountSerivices accountSerivices;
//	@Test
//	void testCreateAccount() {
//		fail("Not yet implemented"); 
//	}
	@BeforeEach
	private void setUP() {
		System.out.println("Setting up");
		this.accountSerivices=new AccountSerivices(this.accountRepository);

	}
	@Test
	public void testfindAllDetails() {
			 accountSerivices.findAllDetails();
			
		
		verify(accountRepository).findAll();
	}
	//@Test
//	public void testCreateAccount() {
//		//AcccountDto user=new AcccountDto(5, "vivek", "male", 100.0f);
//		AccountEntity user=new AccountEntity(5L, "vivek", "male", 100.0f);
//		
//		accountRepository.save(user);
//		// accountSerivices.createAccount(user);
//		// assertNotNull(accountRepository.findById(5L).get());
//	//verify(accountRepository).findById(user.getAccountNumber());
//}
//	
//	

}
