package com.sp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



import com.sp.requests.SellRequest;
import com.sp.service.TransactionService;

import Common.cp.CardDTO;

@RestController
public class TransactionRestCrt {
	
	@Autowired
	TransactionService transactionService;
	
	public TransactionRestCrt(TransactionService transactionService) {
        this.transactionService = transactionService;
    }
	
	@PostMapping("/transaction/buy/{id1}/{id2}")
    public CardDTO buy(@PathVariable int id1, @PathVariable int id2 ) {
		Integer cardId=id1;
		Integer playerId=id2;
        return this.transactionService.buy(cardId, playerId);
    }
	
	@PostMapping("/transaction/sell/{id1}/{id2}")
    public CardDTO sell(@PathVariable int id1, @PathVariable int id2, @RequestBody SellRequest sellRequest) {
		Integer cardId=id1;
		Integer playerId=id2;
        return this.transactionService.sell(cardId, playerId, sellRequest.getPrice());
    }
}
