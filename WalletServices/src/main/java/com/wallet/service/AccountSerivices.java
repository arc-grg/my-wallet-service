package com.wallet.service;
//// Added this line for teting git 
// Again added for testing
import java.util.ArrayList;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wallet.dao.AccountRepository;
import com.wallet.dto.AcccountDto;
import com.wallet.entity.AccountEntity;
import com.wallet.exception.AccountException;
import com.wallet.exception.AccountNotFound;

@Service
public class AccountSerivices {
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	ModelMapper modelMpaMapper;

	public AccountEntity createAccount(AcccountDto acccountDto) {
		AccountEntity accountEntity = modelMpaMapper.map(acccountDto, AccountEntity.class);
		AccountEntity account = accountRepository.save(accountEntity);
		return account;
	}

	public AccountEntity creaditAccount(long accountNumber, float amount) {

		Optional<AccountEntity> user = accountRepository.findById(accountNumber);
		AccountEntity accountDto = user.get();
		float balance = accountDto.getBalance();
		amount += balance;
		accountDto.setBalance(amount);
		AccountEntity creaited = accountRepository.save(accountDto);
		return creaited;
	}

	public float getOldBalance(long accountNumber) {
		Optional<AccountEntity> user = accountRepository.findById(accountNumber);
		AccountEntity accountDto = user.get();
		float oldBalance = accountDto.getBalance();
		return oldBalance;

	}

	public Optional<AccountEntity> getAccountDetails(long accountNumber) {
		Optional<AccountEntity> accountDetails = accountRepository.findById(accountNumber);
		return accountDetails;
	}

	public ArrayList<AccountEntity> transferAccount(long debitFromAccount, long creditIntoAccount, float amount) {

		AccountEntity account1 = accountRepository.getById(debitFromAccount);
		AccountEntity account2 = accountRepository.getById(creditIntoAccount);
		float debitfromThisBalance = account1.getBalance();
		float creditIntoThisBalance = account2.getBalance();
		if (debitfromThisBalance < amount) {
			// return "Insufficient";
			throw new AccountException("Insufficient balance");
		} else {
			ArrayList<AccountEntity> list = new ArrayList<AccountEntity>();
			debitfromThisBalance -= amount;
			account1.setBalance(debitfromThisBalance);
			AccountEntity updatedAccount1 = accountRepository.save(account1);
			creditIntoThisBalance += amount;
			account2.setBalance(creditIntoThisBalance);
			AccountEntity updatedAccount2 = accountRepository.save(account2);
			list.add(updatedAccount2);
			list.add(updatedAccount1);
			return list;
		}

	}//

	public void deleteAccount(long accountNumber) {
		Optional<AccountEntity> account = accountRepository.findById(accountNumber);
		if (account.isPresent())
			accountRepository.deleteById(accountNumber);
		else
			throw new AccountNotFound(accountNumber+" This account number does no exist");

	}
}
