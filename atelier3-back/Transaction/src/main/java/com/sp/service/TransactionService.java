package com.sp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.sp.repository.TransactionRepository;
import com.sp.tools.Comm;

import Common.cp.CardDTO;
import Common.cp.UserDTO;

@Service
public class TransactionService {
	
	@Autowired
	TransactionRepository transactionRepository;
	
	private final UserDTO userDTO;
	private final CardDTO cardDTO;
	
	
	public TransactionService(UserDTO userDTO,CardDTO cardDTO) {
		this.cardDTO = cardDTO;
        this.userDTO = userDTO;
	}
	
	public CardDTO buy(Integer id_card, Integer buyer_id) {
		
		CardDTO card = Comm.getRemoteCard(id_card);
		if(card !=null) {
			UserDTO buyer = Comm.getRemoteUser(buyer_id);
			UserDTO seller = Comm.getRemoteUser(card.getPlayerId());
			if(buyer.getSold() >= card.getPrice()) {
				
				// Mise a jour du détenteur de la carte et de son statut a vendre ou non
                card.setPlayerId(buyer.getId());
                card.setIsToSell(false);
                Comm.postRemoteCard(card);
                
                // Mise a jour des portes monnaie du buyer et du seller
				buyer.setSold(buyer.getSold() - card.getPrice());
                seller.setSold(seller.getSold() + card.getPrice());
                Comm.postRemoteUser(buyer);
                Comm.postRemoteUser(seller);
                
                return card;
			}
			else {
				throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED, "Your balance is not enough");
				
			}
			
		}
		throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED, "Card not found");
		
		
	}
	
	public CardDTO sell(Integer cardId, Integer buyer_id, Integer price) {
		CardDTO card = Comm.getRemoteCard(cardId);
        if(card != null){
            if(card.getPlayerId().equals(buyer_id)){
                card.setIsToSell(true);
                card.setPrice(price);
                Comm.postRemoteCard(card);
                return card;
            }else{
                throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED, "You are not the owner of this card");
            }
        }
        throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED, "Card not found");
    }
	
	
	
	
	

}
