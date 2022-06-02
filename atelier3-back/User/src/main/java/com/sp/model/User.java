package com.sp.model;

import javax.persistence.Column;
import javax.persistence.ElementCollection;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true)
	private Integer id;

	@Column(name = "email", unique = true)
    private String email;

	@Column(name = "name")
    private String name;

	@Column(name = "surname")
    private String surname;

	@Column(name = "password")
    private String password;
	
	@Column(name = "sold")
    private Integer sold = 100;
	
	@Column(name = "idCard")
	@ElementCollection
    private List<Integer> ListIdCard;
	

    public User(){
    	this.email= "";
    	this.name = "";
    	this.surname = "";
    	this.password = "";
    	this.sold = 0;
    	this.ListIdCard = new ArrayList<>();

    }
    
    public User(String email, String name, String surname, String password, Integer sold, List<Integer> idCard){
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.sold = sold;
        this.ListIdCard = idCard;
   
    }
    
    // GETTER AND SETTER
    

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }
    

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public Integer getSold() {
		return sold;
	}

	public void setSold(Integer sold) {
		this.sold = sold;
	}

	public List<Integer> getListIdCard() {
		return ListIdCard;
	}

	public void setListIdCard(List<Integer> listIdCard) {
		ListIdCard = listIdCard;
	}
	


}
