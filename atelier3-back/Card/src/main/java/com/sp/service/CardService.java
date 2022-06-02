package com.sp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.model.Card;
import com.sp.repository.CardRepository;

import Common.cp.CardDTO;

@Service
public class CardService {
	
	@Autowired
    CardRepository cardRepository;
	
	private CardDTO CardToCardDTO(Card card){
		CardDTO cardDTO = new CardDTO(card.getName(),card.getDescription(),card.getImgUrl(),card.getFamily(),card.getAffinity(),card.getHp(),card.getEnergy(),card.getAttack(),card.getDefense(),card.getPlayerId(),card.getPrice(),card.getIsToSell());
		//BeanUtils.copyProperties(card, cardDTO);
		return cardDTO;
	}
	
	private Card CardDTOTOCard(CardDTO cardDTO){
		Card card = new Card(cardDTO.getName(),cardDTO.getDescription(),cardDTO.getImgUrl(),cardDTO.getFamily(),cardDTO.getAffinity(),cardDTO.getHp(),cardDTO.getEnergy(),cardDTO.getAttack(),cardDTO.getDefense(),cardDTO.getPlayerId(),cardDTO.getPrice(),cardDTO.getIsToSell());
		//BeanUtils.copyProperties(cardDTO, card);
		return card;
	}
	
	
	public CardDTO create(CardDTO cardDTO) {
		Card cardcreate = this.cardRepository.save(this.CardDTOTOCard(cardDTO));
		return this.CardToCardDTO(cardcreate);
        
    }
	
	public boolean delete(CardDTO card) {
        this.cardRepository.delete(this.CardDTOTOCard(card));
        return true;
    }
	
	public CardDTO update(Integer id,CardDTO cardDTO) {
		Card card = this.CardDTOTOCard(cardDTO);
		card.setId(id);
        Card cardupdate = this.cardRepository.save(card);
        return this.CardToCardDTO(cardupdate);
    }
	
	public CardDTO getCard(Integer id) {
		Optional<Card> card = cardRepository.findById(id);
		if (card.isPresent()) {
			return this.CardToCardDTO(card.get());
		} else {
			return null;
		}
    }

	public Iterable<CardDTO> getCardByPlayerId(int playerId){
		Iterable<Card> cards = cardRepository.findByPlayerId(playerId);
		List<CardDTO> cardsDTO = new ArrayList<CardDTO>();
		for (Card card : cards) {
			cardsDTO.add(this.CardToCardDTO(card));
		}
		return cardsDTO;
	}
	
	public Iterable<CardDTO> getAllCards() {
		Iterable<Card> cards = cardRepository.findAll();
		List<CardDTO> cardsDTO = new ArrayList<CardDTO>();
		for (Card card : cards) {
			cardsDTO.add(this.CardToCardDTO(card));
		}
		return cardsDTO;
    }
	
	public Iterable<CardDTO> getCardsBuyable(){
		Iterable<Card> cardsBuyable = cardRepository.findByIsToSell(true);
		List<CardDTO> cardsDTOBuyable = new ArrayList<CardDTO>();
        for (Card card : cardsBuyable) {
        	cardsDTOBuyable.add(this.CardToCardDTO(card));
        }
        return cardsDTOBuyable;
    }

}
