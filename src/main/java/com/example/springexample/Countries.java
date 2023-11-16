package com.example.springexample;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Countries {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    Countries (){
    }
    Countries( String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        } if (!(o instanceof Countries)){
            return false;
        }

        Countries countries = (Countries) o;
        return Objects.equals(this.id, countries.id) && Objects.equals(this.name, countries.name);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.id, this.name);
    }

    @Override
    public String toString(){
        return "Countries{" + "id=" + this.id + ", name='" + this.name + '\'' + '}';
    }
}
