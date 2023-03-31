/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examplecrud.demojsp.model.authorizationModel;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author kmd
 */
@Entity
@Table(name = "Role")
public class Role {

    @Id
    @Column(name = "roleId")
    private int roleId;
    @Column
    private String roleName;
    @OneToMany(mappedBy = "role")
    List<Account_Role> account_Role;
    @OneToMany(mappedBy = "role")
    List<Role_Feature> role_Feature;

    public List<Account_Role> getAccount_Role() {
        return account_Role;
    }

    public void setAccount_Role(List<Account_Role> account_Role) {
        this.account_Role = account_Role;
    }

    public List<Role_Feature> getRole_Feature() {
        return role_Feature;
    }

    public void setRole_Feature(List<Role_Feature> role_Feature) {
        this.role_Feature = role_Feature;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}
