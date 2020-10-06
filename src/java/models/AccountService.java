/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;

/**
 *
 * @author 831690
 */
public class AccountService {


    public AccountService() {
        
    }
    
    public User login(String username, String password) {
        
        User user = new User(username, password);
        
        if ((user.username.equals("abe") || user.username.equals("barb")) && user.password.equals("password")) {
            user.password = null;
            return user; 
        }
        
        else {
            return null;
        }
    }
    
}
    
  