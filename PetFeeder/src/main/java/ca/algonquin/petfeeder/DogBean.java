package ca.algonquin.petfeeder;

import java.io.Serializable;

public class DogBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String dogName;
    private String dogType;
    private String dogOwner;
    
    public DogBean() {
    }
    public DogBean(String dogName, String dogType, String dogOwner) {
    	this.dogName = dogName;
    	this.dogType = dogType;
    	this.dogOwner = dogOwner; 
    }
    public DogBean(int id, String dogName, String dogType, String dogOwner) {
    	this.id = id;
    	this.dogName = dogName;
    	this.dogType = dogType;
    	this.dogOwner = dogOwner;
    }
    public int getId() {    
    	return id;
    }
    public void setId(int id) {
    	this.id = id;
    }
    public String getDogName() {
        return dogName;
    }
    public void setDogName(String dogName) {
        this.dogName = dogName;
    }
    public String getDogType() {
        return dogType;
    }
    public void setDogType(String dogType) {
        this.dogType = dogType;
    }
    public String getDogOwner() {
    	return dogOwner;
    }
    public void setDogOwner(String dogOwner) {
        this.dogOwner = dogOwner;
    }
}
