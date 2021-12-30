package com.wallet.dto;

import org.springframework.stereotype.Component;

@Component
public class AcccountDto {
	
	private long accountNumber;
	private String userName;
	private String gender;
	private float balance;
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(Long balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "AccountBean [accountNumber=" + accountNumber + ", userName=" + userName + ", gender=" + gender
				+ ", balance=" + balance + "]";
	}
	
	//

}
