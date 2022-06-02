package com.sp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import Common.cp.CardDTO;

public interface CardRepository extends CrudRepository<CardDTO, Integer> {
	
	 //@Query("select c from Card c where c.ownerId = ?1")
	 List<CardDTO> findByPlayerId(Integer ownerId);

	 //@Query("select c from Card c where c.isToSell = ?1")
	 Iterable<CardDTO> findByIsToSell(boolean value);
}
