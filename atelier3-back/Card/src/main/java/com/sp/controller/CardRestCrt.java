package com.sp.controller;

import java.util.Optional;

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
	
	public CardRestCrt(CardService cardService) {
		this.cardService = cardService;
	}
	
	@PostMapping("/card")
	public CardDTO create(@RequestBody CardDTO card) {
		return this.cardService.create(card);
	}
	
	@PostMapping("/card/{id}")
	public CardDTO update(@PathVariable int id, CardDTO card) {
		return this.cardService.update(card);
	}
	
	@DeleteMapping("/card/{id}")
	public boolean delete(@PathVariable int id, CardDTO card) {
		return this.cardService.delete(card);
	}
	
	@GetMapping("/card/{id}")
	public Optional<CardDTO> show(@PathVariable int id) {
		return this.cardService.show((Integer) id);
	}
	
	@GetMapping("/cards/mycards/{playerId}")
	public Iterable<CardDTO> getMyCards(@PathVariable int playerId){
		return this.cardService.getMyCards(playerId);
	}
	
	@GetMapping("/cards")
	public Iterable<CardDTO> getCards() {
		return this.cardService.getCards();
	}
	
	@GetMapping("/cards/buyable")
	public Iterable<CardDTO> getCardsBuyable() {
		return this.cardService.getCardsBuyable();
	}

}