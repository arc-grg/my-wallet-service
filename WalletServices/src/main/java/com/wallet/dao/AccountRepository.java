package com.wallet.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wallet.entity.AccountEntity;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
	@Query(value="SELECT * FROM USER_ACCOUNTS where user_name=:name",nativeQuery = true)
	public AccountEntity findUserByUserName(@Param("name") String name);
}
