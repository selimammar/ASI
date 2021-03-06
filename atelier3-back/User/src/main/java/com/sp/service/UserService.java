package com.sp.service;


import java.util.*;
import com.sp.model.User;
import com.sp.repository.UserRepository;
import com.sp.requests.LoginRequest;
import com.sp.requests.RegisterRequest;

import Common.cp.UserDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {
   
	@Autowired
    UserRepository userRepository;
	
	private UserDTO UserToUserDTO(User user){
		UserDTO userDto = new UserDTO(user.getEmail(),user.getName(),user.getSurname(),user.getPassword(),user.getSold(),user.getListIdCard());
		return userDto;
	}
	
	private User UserDTOToUser(UserDTO userDTO){
		User user = new User(userDTO.getEmail(),userDTO.getName(),userDTO.getSurname(),userDTO.getPassword(),userDTO.getSold(),userDTO.getListIdCard());
		return user;
	}

    public UserDTO login(LoginRequest loginRequest) {
        User user = this.userRepository.findByEmail(loginRequest.getEmail());
        if (user != null) {
            if (user.getPassword().equals(loginRequest.getPassword())) {
                return this.UserToUserDTO(user);
            }
        }
        throw new ResponseStatusException(null);
    }

    public UserDTO register(RegisterRequest registerRequest) {

        UserDTO userDTO = new UserDTO(registerRequest.getEmail(), registerRequest.getName(), registerRequest.getSurname(), registerRequest.getPassword(), registerRequest.getSold(),generateRandomArray(5));
        User user_register = this.userRepository.save((this.UserDTOToUser(userDTO)));
        return this.UserToUserDTO(user_register);
    }
    
    
    public List<Integer> generateRandomArray(int n){
        ArrayList<Integer> list = new ArrayList<Integer>(n);
        Random random = new Random();
        
        for (int i = 0; i < n; i++)
        {
            list.add(random.nextInt(100));
        }
       return list;
    } 
    
    public UserDTO update(UserDTO userDTO) {
    	User user = this.UserDTOToUser(userDTO);
		User userupdate = this.userRepository.save(user);
		return this.UserToUserDTO(userupdate);
    }
    
    public Iterable<UserDTO> getAllUsers() {
		Iterable<User> users = userRepository.findAll();
		List<UserDTO> usersDTO = new ArrayList<UserDTO>();
		for(User user : users){
			usersDTO.add(this.UserToUserDTO(user));
		}
		return usersDTO;
	}
	
    
    public UserDTO getUserById(int id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			return this.UserToUserDTO(user.get());
		} else {
			return null;
		}
	}


}

