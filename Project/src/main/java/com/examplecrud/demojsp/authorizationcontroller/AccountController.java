/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examplecrud.demojsp.authorizationcontroller;

import com.examplecrud.demojsp.model.authorizationModel.Account;
import com.examplecrud.demojsp.repository.AccountRepository;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
    
    @RequestMapping(path="login", method = RequestMethod.POST)
    public String processLoginForm(@RequestParam("username") String username,@RequestParam("password") String password,ModelMap modelMap,HttpSession session){
        Account account = accountRepository.findByUsernameAndPassword(username, password);
        if(account == null){
            modelMap.addAttribute("errorLogin","Login Failed");
            return "../authorization/login";
        }else{
            session.setAttribute("account", account);
            return "hello";
        }
    }
    
}
