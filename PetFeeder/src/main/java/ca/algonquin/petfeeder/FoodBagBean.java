package ca.algonquin.petfeeder;

import java.io.Serializable;
import java.util.Date;

public class FoodBagBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String fbBrand;
	private int fbSize;
	private int sCups;
	private Date dayOpened;
	private String Owner;
	private int daysUntilEmpty;
	private int id;
	
	public FoodBagBean() {};
    public FoodBagBean(int id, String fbBrand, int fbSize, int sCups, Date dayOpened, String Owner) {
    	this.id = id;
    	this.fbBrand = fbBrand;
    	this.fbSize = fbSize;
    	this.sCups = sCups;
    	this.Owner = Owner;
    	this.dayOpened = dayOpened;
    }
	
    FoodBagBean get_fb_info(FoodBagBean foodBagBean) {
    	FoodBagBean updatedFoodBagBean = null;
    	return updatedFoodBagBean;
	}
	
	public String getFbBrand() {
		return fbBrand;
	}

	public void setFbBrand(String fbBrand) {
		this.fbBrand = fbBrand;
	}

	public int getFbSize() {
		return fbSize;
	}

	public void setFbSize(int fbSize) {
		this.fbSize = fbSize;
	}
	
	public int getSCups() {
		return sCups;
	}

	public void setSCups(int sCups) {
		this.sCups = (this.fbSize * 9);
	}

	public Date getDayOpened() {
		return dayOpened;
	}

	public void setDayOpened(Date dayOpened) {
		this.dayOpened = dayOpened;
	}
	
	public String getOwner() {
    	return Owner;
    }
    
	public void setOwner(String Owner) {
        this.Owner = Owner;
    }

	public int getDaysUntilEmpty() {
		return daysUntilEmpty;
	}

	public void setDaysUntilEmpty(int daysUntilEmpty) {
		this.daysUntilEmpty = daysUntilEmpty;
	}
}
