package ca.algonquin.petfeeder;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class FoodBagDao {
	private static final String SELECT_ALL_FOOD = "select * from foodbag where owner = ?; ";
	private static final String INSERT_FOODBAG_SQL = "INSERT INTO foodbag" +
			" (food_bag_brand, food_bag_size, size_cups, day_opened, owner) VALUES " +
				"(?, ?, ?, ?, ?);";
	public int foodBag(FoodBagBean foodbag) throws ClassNotFoundException {
	 		
		int result = 0;
		
		// convert from java date to sql date
		java.sql.Date sqlDate = new java.sql.Date(foodbag.getDayOpened().getTime());
		System.out.println(foodbag.getFbSize());
        try {
        	Connection connection = DBConnection.getConnectionToDatabase();
        	PreparedStatement preparedStatement = connection.prepareStatement(INSERT_FOODBAG_SQL);
            preparedStatement.setString(1, foodbag.getFbBrand());
            preparedStatement.setInt(2, foodbag.getFbSize());
            preparedStatement.setInt(3, foodbag.getSCups());
            preparedStatement.setDate(4, sqlDate);
            preparedStatement.setString(5, foodbag.getOwner());
                        
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }
	
	public List < FoodBagBean > selectAllBag(String owner)  {
    	// using try-with-resources to avoid closing resources (boiler plate code)
		
        List < FoodBagBean > fb = new ArrayList < > ();
        // Step 1: Establishing a Connection
       	
        try {
        	Connection connection = DBConnection.getConnectionToDatabase();
        	PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_FOOD);
        	preparedStatement.setString(1, owner);
            System.out.println(preparedStatement);
            // Step 2: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 3: Process the ResultSet object.
            while (rs.next()) {
            	int id = rs.getInt("id");
                String fbBrand = rs.getString("food_bag_brand");
                int fbSize = rs.getInt("food_bag_size");
                int sCups = rs.getInt("size_cups");
                String Owner = rs.getString("owner");
                Date dayOpened = rs.getDate("day_opened");
                fb.add(new FoodBagBean(id, fbBrand, fbSize, sCups, dayOpened, Owner));
                System.out.println("Added bag row: " + id);
            }
            } catch (SQLException e) {
                printSQLException(e);
            }
            return fb;
    }
    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}