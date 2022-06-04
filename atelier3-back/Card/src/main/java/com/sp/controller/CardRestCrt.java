package com.sp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sp.service.CardService;

import Common.cp.CardDTO;

@RestController
public class CardRestCrt {
	
	@Autowired
	CardService cardService;
	
	
	@PostMapping("/card")
	public CardDTO create(@RequestBody CardDTO card) {
		return this.cardService.create(card);
	}
	
	@PostMapping("/card/{id}")
	public CardDTO update(@PathVariable Integer id,@RequestBody CardDTO card) {
		return this.cardService.update(id,card);
	}
	
	@DeleteMapping("/card/{id}")
	public boolean delete(@PathVariable Integer id, CardDTO card) {
		return this.cardService.delete(card);
	}
	
	@GetMapping("/card/{id}")
	public CardDTO getCard(@PathVariable Integer id) {
		return this.cardService.getCard((Integer) id);
	}
	
	@GetMapping("/cards/mycards/{playerId}")
	public Iterable<CardDTO> getCardByPlayerId(@PathVariable int playerId){
		return this.cardService.getCardByPlayerId(playerId);
	}
	
	@GetMapping("/cards")
	public Iterable<CardDTO> getAllCards() {
		return this.cardService.getAllCards();
	}
	
	@GetMapping("/cards/buyable")
	public Iterable<CardDTO> getCardsBuyable() {
		return this.cardService.getCardsBuyable();
	}
	
}
