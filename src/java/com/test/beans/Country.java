
package com.test.beans;

public class Country {
    private String id;
    private String country;

    public Country(String id, String country) {
        this.id = id;
        this.country = country;
    }

    public Country() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Country{" + "id=" + id + ", country=" + country + '}';
    }
    
    
    
    
}
