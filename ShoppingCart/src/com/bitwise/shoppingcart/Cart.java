package com.bitwise.shoppingcart;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;

public class Cart {
	HashMap<String, Integer> cartItems;
    public Cart(){
     cartItems = new HashMap<>();
      
    }
    public HashMap<String, Integer> getCartItems(){
        return cartItems;
    }
    public void addToCart(String itemId, int price){
        cartItems.put(itemId, price);
    }
    public void deleteFromCart(String itemId){
        cartItems.remove(itemId);
    }

}
