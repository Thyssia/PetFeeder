package ca.algonquin.petfeeder.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ca.algonquin.petfeeder.beans.DogBean;
import ca.algonquin.petfeeder.utils.DBConnection;

public class DogDao {
	private Connection connection;	
	private static final String INSERT_DOGS_SQL = "INSERT INTO dog" +
         "  (dog_name, dog_type, dog_daily_amount, dog_owner) VALUES " + " (?, ?, ?, ?);";
    private static final String SELECT_DOG_BY_ID = "select id, dog_name, dog_type, dog_daily_amount, dog_owner from dog where id =?;";
    private static final String SELECT_ALL_DOG = "select * from dog where dog_owner = ?;";
    private static final String DELETE_DOG_SQL = "delete from dog where id = ?;";
    private static final String UPDATE_DOG_SQL = "update dog set dog_name = ?, dog_type= ?, dog_daily_amount= ? where id = ?;";

    int result = 0;
        
    public DogDao() {
    	this.connection = DBConnection.getConnectionToDatabase();
    }

    public void insertDog(DogBean dog) throws SQLException {
    	System.out.println(INSERT_DOGS_SQL);
        		
        try {
        	PreparedStatement preparedStatement = connection.prepareStatement(INSERT_DOGS_SQL);
        	preparedStatement.setString(1, dog.getDogName());
        	preparedStatement.setString(2, dog.getDogType());
        	preparedStatement.setInt(3, dog.getDogDailyAmount());
        	preparedStatement.setString(4, dog.getDogOwner());
        	System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
            
        	} catch (SQLException e) {
            printSQLException(e);
        	}
        }
        	
    public DogBean selectDog(int id) {
    	DogBean dog = null;
        // Step 1: Establishing a Connection
        try {
        	PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DOG_BY_ID);
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 2: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 3: Process the ResultSet object.
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

    public List < DogBean > selectAllDogs(String dog_owner) {
    	// using try-with-resources to avoid closing resources (boiler plate code)
        List < DogBean > dogs = new ArrayList < > ();
       
        try {
        	PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DOG);
        	preparedStatement.setString(1, dog_owner);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
            	int id = rs.getInt("id");
                String DogName = rs.getString("dog_name");
                String DogType = rs.getString("dog_type");
                int DogDailyAmount = rs.getInt("dog_daily_amount");
                String DogOwner = rs.getString("dog_owner");
                dogs.add(new DogBean(id, DogName, DogType, DogDailyAmount, DogOwner));
                System.out.println("Added dog row: " + id);
            }
      } catch (SQLException e) {
                printSQLException(e);
      }
      return dogs;
    }
            
    public boolean deleteDog(int id) {
    	boolean rowDeleted = false;
        try {
        	PreparedStatement statement = connection.prepareStatement(DELETE_DOG_SQL); {
        	statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
            return rowDeleted;
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
		return rowDeleted;
    }
    
    public boolean updateDog(DogBean dog) throws SQLException {
    	boolean rowUpdated = false;
        try {
        	PreparedStatement statement = connection.prepareStatement(UPDATE_DOG_SQL);
        	statement.setString(1, dog.getDogName());
            statement.setString(2, dog.getDogType());
            statement.setInt(3, dog.getDogDailyAmount());
            statement.setInt(4, dog.getId());

            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
        }
        return rowUpdated;
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