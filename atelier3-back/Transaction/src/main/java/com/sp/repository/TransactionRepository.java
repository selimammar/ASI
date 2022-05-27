package com.sp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sp.model.Transaction;

@Repository
public interface TransactionRepository  extends CrudRepository<Transaction, Integer> {

}
