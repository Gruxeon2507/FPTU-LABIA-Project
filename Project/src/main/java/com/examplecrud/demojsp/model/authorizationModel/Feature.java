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
@Table(name = "Feature")
public class Feature {

    @Id
    @Column(name = "featureId")
    private int featureId;
    @Column
    private String featureName;
    private String url;
    @OneToMany(mappedBy = "feature")
    List<Role_Feature> role_Feature;

    public List<Role_Feature> getRole_Feature() {
        return role_Feature;
    }

    public void setRole_Feature(List<Role_Feature> role_Feature) {
        this.role_Feature = role_Feature;
    }

    public int getFeatureId() {
        return featureId;
    }

    public void setFeatureId(int featureId) {
        this.featureId = featureId;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
