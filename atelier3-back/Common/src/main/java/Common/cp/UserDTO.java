package Common.cp;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {
	
	
		private Integer id;
	    private String email;
	    private String name;
	    private String surname;
	    private String password;
	    private Integer sold = 100;
	    private List<Integer> ListIdCard;

	    public UserDTO(){
	    	this.email= "";
	    	this.name = "";
	    	this.surname = "";
	    	this.password = "";
	    	this.sold = 0;
	    	this.ListIdCard = new ArrayList<>();
	    }
	    

		public UserDTO(String email, String name, String surname, String password, Integer sold,List<Integer> idCard){
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



