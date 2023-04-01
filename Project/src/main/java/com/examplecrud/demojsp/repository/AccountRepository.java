/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.examplecrud.demojsp.repository;

import com.examplecrud.demojsp.model.authorizationModel.Account;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Asus
 */
public interface AccountRepository extends CrudRepository<Account, String>{
    
    Account findByUsernameAndPassword(String username,String password);
    
}
