package com.sp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.sp.repository.CardRepository;

import Common.cp.CardDTO;

@Service
public class CardService {
	
	@Autowired
    CardRepository cardRepository;
	
	public CardDTO create(CardDTO card) {
        this.cardRepository.save(card);
        return card;
    }
	
	public boolean delete(CardDTO card) {
        this.cardRepository.delete(card);
        return true;
    }
	
	public CardDTO update(CardDTO card) {
        this.cardRepository.save(card);
        return card;
    }
	
	public Optional<CardDTO> show(Integer id) {
        return this.cardRepository.findById(id);
    }

	public Iterable<CardDTO> getMyCards(int playerId){
		return this.cardRepository.findByPlayerId(playerId);
	}
	
	public Iterable<CardDTO> getCards() {
        return this.cardRepository.findAll();
    }
	
	public Iterable<CardDTO> getCardsBuyable(){
        return this.cardRepository.findByIsToSell(true);
    }

}
