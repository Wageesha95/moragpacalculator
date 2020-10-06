package com.myapps.moragpacalculatorserver.dataModels;

import org.springframework.data.annotation.Id;


public class UserProfile {

    @Id
    private String id;
    private String name;

    public UserProfile(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
