/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examplecrud.demojsp.authorizationcontroller;

import com.examplecrud.demojsp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Asus
 */

@Controller
public class AccountController {
    
    @Autowired
    AccountRepository accountRepository;
    
      @RequestMapping(path="login", method = RequestMethod.GET)
    public String showLoginForm(ModelMap modelMap){
        return "../authorization/login";
    }
    
    
}
