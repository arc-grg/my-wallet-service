package com.wallet.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wallet.entity.AccountEntity;
@SpringBootTest
class AccountRepositoryTest {

	@Autowired
 private AccountRepository accountRepository;
	@Test
	void testFindUserByUserName() {
		AccountEntity user=new AccountEntity(2001,"sumit","male",2000.0f);
		accountRepository.save(user);
		AccountEntity actualresult = accountRepository.findUserByUserName(user.getUserName());
		assertThat(actualresult.getAccountNumber()).isEqualTo(user.getAccountNumber());
	}

}
