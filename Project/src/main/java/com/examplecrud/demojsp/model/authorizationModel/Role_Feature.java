/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examplecrud.demojsp.model.authorizationModel;

import com.examplecrud.demojsp.modelkey.Role_FeatureKey;
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
@Table(name = "Role_Feature")
public class Role_Feature {
    @EmbeddedId
    Role_FeatureKey id;
    
    @ManyToOne
    @MapsId("featureId")
    @JoinColumn(name = "featureId")
    Feature feature;

    @ManyToOne
    @MapsId("roleId")
    @JoinColumn(name = "roleId")
    Role role;

    public Role_FeatureKey getId() {
        return id;
    }

    public void setId(Role_FeatureKey id) {
        this.id = id;
    }

    public Feature getFeature() {
        return feature;
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    
}
