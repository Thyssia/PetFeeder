package ca.algonquin.petfeeder.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import ca.algonquin.petfeeder.utils.DBConnection;
import ca.algonquin.petfeeder.utils.ObserverDaysLeft;

public class CalculationDao {
	private static final String SELECT_ALL_DOGS = "select sum(dog_daily_amount) as dailyUse from dog where dog_owner = ?; ";
	private static final String SELECT_BAG_SIZE_CUPS = "select size_cups,day_opened from foodbag where owner = ?; ";
	private ObserverDaysLeft observer;
	private int daysLeft;
	private String user;
	
	public String getUser() {
		return this.user;
	}
	
	public int getDaysLeft() {
		return this.daysLeft;
	}
	public void attach(ObserverDaysLeft observer){
	      this.observer = observer;		
	}
	
	public String calculation(String owner) throws ClassNotFoundException  {
	 	int dailyDogsUse = 1;
	 	int totalCupsSize = 1;
	  	LocalDate today = LocalDate.now();
	 	LocalDate foodOpenedDate = LocalDate.now().minusDays(10);
	 	String daysUntilEmpty = "";
	 	this.user = owner;
	 	boolean foodbag = false;
	 	boolean dog = false;
				
		try {
			Connection connection = DBConnection.getConnectionToDatabase();
		
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DOGS);
			preparedStatement.setString(1, owner);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
            	System.out.println("I am in the loop indicating results, statement 1: "+ preparedStatement);
            	dailyDogsUse = rs.getInt("dailyUse");
            	System.out.println("Got value : " + dailyDogsUse);
            	if (dailyDogsUse > 0) dog = true;
            }
            PreparedStatement preparedStatement2 = connection.prepareStatement(SELECT_BAG_SIZE_CUPS);
            preparedStatement2.setString(1, owner);
            ResultSet rss = preparedStatement2.executeQuery();
            
            while (rss.next()) {
            	System.out.println("in calc dao, statement 2: "+ preparedStatement2);
            	totalCupsSize = rss.getInt("size_cups");
            	foodOpenedDate = rss.getDate("day_opened").toLocalDate();
            	System.out.println("GOT DATES: " + foodOpenedDate + " and got cupsSize: " + totalCupsSize);
            	foodbag=true;
        	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        
        int daysSinceOpened = (int)ChronoUnit.DAYS.between(foodOpenedDate, today);
        if (daysSinceOpened < 0) {
        	return "Empty Bag";
        }
        System.out.println("DOG? " + dog);
        System.out.println("Food? " + foodbag);
        if ((foodbag) && (dog)) {
        	this.daysLeft = ((totalCupsSize/dailyDogsUse) - daysSinceOpened);
        	daysUntilEmpty = Integer.toString(daysLeft);
        	System.out.println("Calling notifier update now: ");
        	observer.update();
        
           
        if (((totalCupsSize/dailyDogsUse) - daysSinceOpened) < 0) {
        //	System.out.println("Less than zero Mathing: (" + totalCupsSize + "/"+dailyDogsUse +") - " +daysSinceOpened+")");
        //	System.out.println("today " + today + "bag opened + " + foodOpenedDate);
        	return "ERROR: Your food bag finished " + Integer.toString(Math.abs(((totalCupsSize/dailyDogsUse) - daysSinceOpened))) + " days ago";
        }
        }else daysUntilEmpty = "--";
        
        return daysUntilEmpty;
    }
}       
