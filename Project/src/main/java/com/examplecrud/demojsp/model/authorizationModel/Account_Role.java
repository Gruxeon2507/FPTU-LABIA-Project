/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examplecrud.demojsp.model.authorizationModel;

import com.examplecrud.demojsp.model.gradeModel.Course;
import com.examplecrud.demojsp.modelkey.AccountRoleKey;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 *
 * @author kmd
 */
@Entity
@Table(name = "Account_Role")
public class Account_Role {

    @EmbeddedId
    AccountRoleKey id;

    @ManyToOne
    @MapsId("username")
    @JoinColumn(name = "username")
    Account account;

    @ManyToOne
    @MapsId("roleId")
    @JoinColumn(name = "roleId")
    Role role;

    public Account_Role() {
    }

    public Account_Role(AccountRoleKey id, Account account, Role role) {
        this.id = id;
        this.account = account;
        this.role = role;
    }

    public AccountRoleKey getId() {
        return id;
    }

    public void setId(AccountRoleKey id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
