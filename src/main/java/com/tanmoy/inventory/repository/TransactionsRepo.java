package com.tanmoy.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tanmoy.inventory.domain.Transactions;

public interface TransactionsRepo extends JpaRepository<Transactions, Long>{

}
