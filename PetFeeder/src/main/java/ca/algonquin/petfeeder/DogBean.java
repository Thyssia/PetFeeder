package ca.algonquin.petfeeder;

import java.io.Serializable;

public class DogBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String dogName;
    private String dogType;
    private String dogOwner;
        
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
