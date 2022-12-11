package ca.algonquin.petfeeder.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ca.algonquin.petfeeder.beans.UserBean;
import ca.algonquin.petfeeder.utils.DBConnection;

public class UserDao {
	
	public int registerUser(UserBean user) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO user" +
            "  (first_name, last_name, email, username, password) VALUES " +
            " (?, ?, ?, ?, ?);";
        
        int result = 0;

       try {
    	   Connection connection = DBConnection.getConnectionToDatabase();
           PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
           preparedStatement.setString(1, user.getFirstName());
           preparedStatement.setString(2, user.getLastName());
           preparedStatement.setString(3, user.getEmail());
           preparedStatement.setString(4, user.getUsername());
           preparedStatement.setString(5, user.getPassword());
            
            System.out.println(preparedStatement);
            // Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }
	
	public boolean validate(UserBean userBean) throws ClassNotFoundException {
		boolean status = false;
		
		try {
			Connection connection = DBConnection.getConnectionToDatabase();
    	   
			String sql = "select * from user where username = ? and password = ? ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userBean.getUsername());
            preparedStatement.setString(2, userBean.getPassword());
            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();

        } catch (SQLException e) {
            
            printSQLException(e);
        }
        return status;
    }
		
	public UserBean getUserInfo(String username) throws ClassNotFoundException {
		UserBean user = null;
		String SELECT_USER_INFO = "select first_name, last_name, email, username from user where username = ?; ";
			        
	    try {
	    	Connection connection = DBConnection.getConnectionToDatabase();
	    	PreparedStatement prepStat = connection.prepareStatement(SELECT_USER_INFO);
	        prepStat.setString(1, username);
	        System.out.println(prepStat);
	        ResultSet rs = prepStat.executeQuery();
	        // Process the ResultSet object.
	        while (rs.next()) {
	        	String FirstName = rs.getString("first_name");
		        String LastName = rs.getString("last_name");
		        String email = rs.getString("email");
		        user = new UserBean(FirstName, LastName, email, username);
	        }
	    } catch (SQLException e) {
	    	// process sql exception
	        printSQLException(e);
	    }
	    return user;
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
