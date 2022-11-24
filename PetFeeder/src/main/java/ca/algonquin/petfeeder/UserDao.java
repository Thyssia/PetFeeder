package ca.algonquin.petfeeder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
	
	public int registerUser(UserBean user) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO user" +
            "  (first_name, last_name, email, username, password) VALUES " +
            " (?, ?, ?, ?, ?);";
        
        int result = 0;

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/petfeeder?useSSL=false", "root", "root");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getUsername());
            preparedStatement.setString(5, user.getPassword());
            
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }
	
	
	
	
	
	public UserBean getUserInfo(String user) throws ClassNotFoundException {
		String SELECT_USER_INFO = "select first_name, last_name, email where username = ?; ";
		UserBean getUserInfo = null;
	        
	       Class.forName("com.mysql.cj.jdbc.Driver");

	        try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/petfeeder?useSSL=false", "root", "root");

	            // Step 2:Create a statement using connection object
	            PreparedStatement prepStat = connection.prepareStatement(SELECT_USER_INFO)) {
	            
	        	
	        	
	        	prepStat.setString(1, user.getUsername());
	            prepStat.setString(2, user.getFirstName());
	            prepStat.setString(3, user.getLastName());
	            prepStat.setString(4, user.getEmail());
	            
	            
	            System.out.println(prepStat);
	          
	        } catch (SQLException e) {
	            // process sql exception
	            printSQLException(e);
	        }
	        return user;
		
	        DogBean dog = null;
	        // Step 1: Establishing a Connection
	        try (Connection connection = getConnection();
	        	// Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DOG_BY_ID);) {
	            preparedStatement.setInt(1, id);
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            ResultSet rs = preparedStatement.executeQuery();

	            // Step 4: Process the ResultSet object.
	            while (rs.next()) {
	            	String DogName = rs.getString("dog_name");
	                String DogType = rs.getString("dog_type");
	                int DogDailyAmount = rs.getInt("dog_daily_amount");
	                String DogOwner = rs.getString("dog_owner");
	                dog = new DogBean(id, DogName, DogType, DogDailyAmount, DogOwner);
	            }
	       } catch (SQLException e) {
	    	   printSQLException(e);
	       }
	       return dog;
		
		
		
		
		
		
		
		
		
		
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
