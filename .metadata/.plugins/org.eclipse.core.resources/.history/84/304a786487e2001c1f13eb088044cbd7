package com.sp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Card {
	
	
	// @GeneratedValue : Cette annotation indique que la clé primaire est générée de façon automatique lors de l’insertion en base.
	// strategy = GenerationType.IDENTITY : La génération de la clé primaire se fera à partir d’une Identité propre au SGBD. Il utilise un type de colonne spéciale à la base de données
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
	
	// Creation de tous les attributs d'une carte en ajoutant le @Column
	// @Column annotation is used for Adding the column the name in the table of a particular MySQL database.
	
	@Column(name = "name")
    private String name;
	
	@Column(name = "description")
    private String description;
	
	@Column(name = "imgUrl")
    private String imgUrl;

    @Column(name = "family")
    private String family;

    @Column(name = "affinity")
    private String affinity;

    @Column(name = "hp")
    private Integer hp;

    @Column(name = "energy")
    private Integer energy;

    @Column(name = "attack")
    private Integer attack;

    @Column(name = "defense")
    private Integer defense;
    
    // Informations que l'on ajoute aux attributs d'une carte pour notre marketplace

    @Column(name = "playerId")
    private Integer playerId;

    @Column(name = "price")
    private Integer price;

    @Column(name = "isToSell")
    public Boolean isToSell;
    
    public Card() {
    	
    	this.name = "";
    	this.description = "";
        this.imgUrl = "";
        this.family = "";
        this.affinity = "";
        this.hp = 0;
        this.energy = 0;
        this.attack = 0;
        this.defense = 0;
        this.playerId = 0;
        this.price = 0;
        this.isToSell = false;
    }
	
    public Card(String name, String description, String imgUrl, String family, String affinity, Integer hp,
            Integer energy, Integer attack, Integer defense, Integer playerId, Integer price, Boolean status) {
    	this.name = name;
        this.description = description;
        this.imgUrl = imgUrl;
        this.family = family;
        this.affinity = affinity;
        this.hp = hp;
        this.energy = energy;
        this.attack = attack;
        this.defense = defense;
        this.playerId = playerId;
        this.price = price;
        this.isToSell = false; // Quand une carte est cree elle n'est pas a vendre
    }
    
    // GETTER AND SETTER

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getAffinity() {
		return affinity;
	}

	public void setAffinity(String affinity) {
		this.affinity = affinity;
	}

	public Integer getHp() {
		return hp;
	}

	public void setHp(Integer hp) {
		this.hp = hp;
	}

	public Integer getEnergy() {
		return energy;
	}

	public void setEnergy(Integer energy) {
		this.energy = energy;
	}

	public Integer getAttack() {
		return attack;
	}

	public void setAttack(Integer attack) {
		this.attack = attack;
	}

	public Integer getDefense() {
		return defense;
	}

	public void setDefense(Integer defense) {
		this.defense = defense;
	}

	public Integer getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Boolean getIsToSell() {
		return isToSell;
	}

	public void setIsToSell(Boolean isToSell) {
		this.isToSell = isToSell;
	}
    

}
