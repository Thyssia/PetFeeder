package ca.algonquin.petfeeder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CalculationDao {
	private static final String SELECT_ALL_DOGS = "select sum(dog_daily_amount) as dailyUse from dog where dog_owner = ?; ";
	private static final String SELECT_BAG_SIZE_CUPS = "select size_cups,day_opened from foodbag where owner = ?; ";
	public String calculation(String owner)  {
	 	int dailyDogUse = 1;
	 	int totalCupsSize = 1;
	  	LocalDate today = LocalDate.now();
	 	LocalDate foodOpenedDate = LocalDate.now().minusDays(10);
	 	String daysUntilEmpty = "";
	 	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/petfeeder?useSSL=false", "root", "root");
        	
            // Get the sum of the daily intake of all dogs by the same user and gets the size of the foodbag in cups
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DOGS);
			PreparedStatement preparedStatement2 = connection.prepareStatement(SELECT_BAG_SIZE_CUPS);) {	
				
            	preparedStatement.setString(1, owner);
            	System.out.println("In calc dao, statement 1: " + preparedStatement);
            	ResultSet rs = preparedStatement.executeQuery();
            	while (rs.next()) {
            		dailyDogUse = rs.getInt("dailyUse");
            	}
            	preparedStatement2.setString(1, owner);
                System.out.println("in calc dao, statement 2: "+ preparedStatement2);
                ResultSet rss = preparedStatement2.executeQuery();
                while (rss.next()) {
                	totalCupsSize = rss.getInt("size_cups");
                	foodOpenedDate = rss.getDate("day_opened").toLocalDate();
            	}
           
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
                
        int daysSinceOpened = (int)ChronoUnit.DAYS.between(today, foodOpenedDate);
        daysUntilEmpty = Integer.toString(((totalCupsSize/dailyDogUse) - daysSinceOpened));
  
        return daysUntilEmpty;
    }
}
