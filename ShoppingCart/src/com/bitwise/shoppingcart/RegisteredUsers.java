
package com.bitwise.shoppingcart;


import java.util.HashMap;
import java.util.Map;

public class RegisteredUsers {
	Map<String, String> usersData = new HashMap<String , String>();
	public RegisteredUsers(){
		usersData.put("gaurav", "Gaurav@123");
		usersData.put("varun", "Varun@456");
		usersData.put("tarun", "Tarun@789");
		usersData.put("simranjit", "Simranjit@987");
		usersData.put("saurabh", "Saurabh@654");
	}
	public Map<String , String> getUsersData(){
		return usersData;
	}
}
