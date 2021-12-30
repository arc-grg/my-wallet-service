package com.wallet.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.wallet.dto.AcccountDto;
import com.wallet.entity.AccountEntity;
import com.wallet.exception.AccountNotFound;
import com.wallet.service.AccountSerivices;

@RestController
public class AccountController {
	@Autowired
	AccountSerivices accountSerivices;

	@Autowired
	AcccountDto acccountDto;

	@PostMapping("/createAccount")
	public ResponseEntity<AccountEntity> createAccount(AcccountDto acccountDto) {

		// BeanUtils.copyProperties(acccountDto, accountEntity);
		AccountEntity result = accountSerivices.createAccount(acccountDto);
		if (result == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

		}
		// To send only status code 201
		/*
		 * URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		 * .buildAndExpand(result.getAccountNumber()).toUri();
		 * 
		 * return ResponseEntity.created(location).build();
		 */

		// To send status code 200
		return ResponseEntity.of(Optional.of(result));

	}

	@PutMapping("/creditAccount")
	public ResponseEntity<AccountEntity> crditAccount(long accountNumber, float amount) {
		float oldBalance = accountSerivices.getOldBalance(accountNumber);
		AccountEntity result = accountSerivices.creaditAccount(accountNumber, amount);
		float updatedBalance = oldBalance + amount;

		if (updatedBalance != result.getBalance())
			return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
		return ResponseEntity.of(Optional.of(result));

	}

	@PutMapping("/transferAmount")
	public ResponseEntity<ArrayList<AccountEntity>> transferAmount(long debitFromAccount, long creditIntoAccount,
			float amount) {

		float oldBalance1 = accountSerivices.getOldBalance(debitFromAccount);
		float oldBalance2 = accountSerivices.getOldBalance(creditIntoAccount);
//		System.out.println("OldBalance of debit one " + oldBalance1);
//		System.out.println("Old balance of credit one " + oldBalance2);

		ArrayList<AccountEntity> result = accountSerivices.transferAccount(debitFromAccount, creditIntoAccount, amount);

		AccountEntity user1 = result.get(0);
		AccountEntity user2 = result.get(1);
		float updatedBalance1 = user1.getBalance();
		float updatedBalance2 = user2.getBalance();
		/*
		 * System.out.println("Updated balance of Debit one "+updatedBalance2);
		 * System.out.println("Updated balance of credit one "+updatedBalance1);
		 * System.out.println(">>>>>>>>>>>>");
		 * System.out.println((updatedBalance2+amount)+"This is equalto "+oldBalance1);
		 * System.out.println((updatedBalance1-amount)+"This is equalto "+oldBalance2);
		 */
		if (updatedBalance2 + amount != oldBalance1 && updatedBalance1 - amount != oldBalance2) {
			return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
		}
		return ResponseEntity.of(Optional.of(result));

//		AccountEntity user1 = result.get(0);
//		AccountEntity user2 = result.get(1);
//		System.out.println(amount);
//		System.out.println(user1);
//		System.out.println(user1.getBalance());
//		System.out.println(user2);
//		System.out.println(user2.getBalance());

//		return result;

	}

	@GetMapping(path = "getAccountDetails/{accountNumber}")
	public ResponseEntity<Optional<AccountEntity>> getAccountDetails(@PathVariable long accountNumber) {

		Optional<AccountEntity> accountDetails = accountSerivices.getAccountDetails(accountNumber);
		// System.out.println(accountDetails.isPresent());

		if (accountDetails.isPresent()) {
			return ResponseEntity.of(Optional.of(accountDetails));

		} else {

			throw new AccountNotFound("Please enter correct account number " + accountNumber);
		}
//		if(accountDetails==null) {
//			System.out.println("in if condition");
//			throw new AccountNotFound("Please check account number");
//			
//		}System.out.println("Not in if condtion");
//		return ResponseEntity.of(Optional.of(accountDetails));
	}

	@DeleteMapping(path = "/deleteAccount/{accountNumber}")
	public void deleteAccount(@PathVariable long accountNumber) {
		accountSerivices.deleteAccount(accountNumber);
	}

//	@GetMapping("/home")
//
//	public void homeRequest(HttpServletResponse rsponse) {
//
//		try {
//			rsponse.sendRedirect("http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
	@GetMapping("/")

	public RedirectView redirectToSwagger() {

		RedirectView redirectView =new RedirectView();
		//redirectView.setUrl("http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config");
		redirectView.setUrl("http://localhost:8080/swagger-ui.html");
		
		return redirectView;

	}

	//

}
