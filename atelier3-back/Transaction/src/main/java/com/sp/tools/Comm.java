package com.sp.tools;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import Common.cp.CardDTO;
import Common.cp.UserDTO;



public class Comm {
	
	private static final String URL_CARD="http://localhost:8082/card"; 
	private static final String URL_USER="http://localhost:8083/user"; 
	
	public static CardDTO getRemoteCard(int id) {

		RestTemplate restTemplate = new RestTemplate();

		// Send request with GET method and default Headers.
		CardDTO c_result = restTemplate.getForObject(URL_CARD+"/"+id, CardDTO.class);
		return c_result;
	}
	
	public static UserDTO getRemoteUser(int id) {

		RestTemplate restTemplate = new RestTemplate();

		// Send request with GET method and default Headers.
		UserDTO u_result = restTemplate.getForObject(URL_USER+"/"+id, UserDTO.class);
		return u_result;
}
	

	public static void postRemoteCard(CardDTO card) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<CardDTO> requestBody = new HttpEntity<>(card, headers);

		// Send request with PUT method.
		restTemplate.postForEntity(URL_CARD+"/"+ card.getId(), requestBody,CardDTO.class);
	}
	
	public static void postRemoteUser(UserDTO user) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<UserDTO> requestBody = new HttpEntity<>(user, headers);

		// Send request with PUT method.
		restTemplate.postForEntity(URL_USER+"/"+ user.getId(), requestBody,UserDTO.class);
	}
	
	
	
}
