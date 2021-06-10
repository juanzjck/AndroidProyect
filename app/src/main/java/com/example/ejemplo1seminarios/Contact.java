package com.example.ejemplo1seminarios;

import com.orm.SugarRecord;

import java.io.Serializable;

public class Contact extends SugarRecord implements Serializable {
    private int image;
    private String name;
    private String phone;
    private String address;

    public Contact(int image, String name, String phone, String address){
        this.image=image;
        this.name=name;
        this.phone=phone;
        this.address=address;
    }
    public Contact(){

    }

    public int getImage(){
        return this.image;
    }

    public String getName(){
        return this.name;
    }
    public String getPhone(){
        return this.phone;
    }
    public String getAddress(){
        return this.address;
    }

    public void setImage(int image){
        this.image=image;
    }

    public void setName(String name){
        this.name=name;
    }
    public void setPhone(String phone){
        this.phone=phone;
    }
    public void setAddress(String address){
        this.address=address;
    }

}
