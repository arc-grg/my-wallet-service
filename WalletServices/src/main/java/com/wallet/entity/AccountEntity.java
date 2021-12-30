package com.wallet.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_accounts")
public class AccountEntity {
	@Id
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

	public void setBalance(float balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "AccountDto [accountNumber=" + accountNumber + ", userName=" + userName + ", gender=" + gender
				+ ", balance=" + balance + "]";
	}

//
}
