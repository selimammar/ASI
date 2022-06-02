package com.sp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



import com.sp.requests.SellRequest;
import com.sp.service.TransactionService;

import Common.cp.CardDTO;

@RestController
public class TransactionRestCrt {
	
	@Autowired
	TransactionService transactionService;
	
	@RequestMapping(method = RequestMethod.PUT, value="/transaction/buy/{id1}/{id2}")
    public CardDTO buy(@PathVariable Integer id1, @PathVariable Integer id2 ) {
		Integer cardId=id1;
		Integer playerId=id2;
        return this.transactionService.buy(cardId, playerId);
    }
	
	@RequestMapping(method = RequestMethod.PUT, value="/transaction/sell/{id1}/{id2}")
    public CardDTO sell(@PathVariable Integer id1, @PathVariable Integer id2, @RequestBody SellRequest sellRequest) {
		Integer cardId=id1;
		Integer playerId=id2;
        return this.transactionService.sell(cardId, playerId, sellRequest.getPrice());
    }
}
