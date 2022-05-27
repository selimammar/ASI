package com.sp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Transaction {
	
	@Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
	
	@Column(name = "date")
	private String date;
	
	@Column(name = "id_player")
    private Integer id_player;
	
	@Column(name = "id_card")
    private Integer id_card;
	
	@Column(name = "amount")
    private Integer amount;
	
	public Transaction() {
        this.date = "";
        this.id_player = 0;
        this.id_card = 0;
        this.amount = 0;
    }
	
	public Transaction(String date, Integer amount, Integer card_id, Integer user_id) {
        this.date = date;
        this.id_player = user_id;
        this.id_card = card_id;
        this.amount = amount;
    }

	
	// GETTER AND SETTER
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getId_player() {
		return id_player;
	}

	public void setId_player(Integer id_player) {
		this.id_player = id_player;
	}

	public Integer getId_card() {
		return id_card;
	}

	public void setId_card(Integer id_card) {
		this.id_card = id_card;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	

	
	
	
	

}
