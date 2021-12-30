package com.wallet.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wallet.entity.AccountEntity;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

}
