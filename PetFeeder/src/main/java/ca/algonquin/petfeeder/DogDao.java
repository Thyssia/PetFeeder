package ca.algonquin.petfeeder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DogDao {
	private static final String jdbcURL = "jdbc:mysql://localhost:3306/petfeeder?useSSL=false";
	private static final String jdbcUsername = "root";
	private static final String jdbcPassword = "root";
	
    private static final String INSERT_DOGS_SQL = "INSERT INTO dog" +
         "  (dog_name, dog_type, dog_owner) VALUES " +
         " (?, ?, ?);";
        
    private static final String SELECT_DOG_BY_ID = "select id, dog_name, dog_type, dog_owner from dog where id =?";
    private static final String SELECT_ALL_DOG = "select * from dog where dog_owner = ?; ";
    private static final String DELETE_DOG_SQL = "delete from dog where id = ?;";
    private static final String UPDATE_DOG_SQL = "update dog set dog_name = ?, dog_type= ? where id = ?;";

    int result = 0;
        
    public DogDao() {}

    protected Connection getConnection() {
    	Connection connection = null;
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        } catch (ClassNotFoundException e) {
           // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }
    
    public void insertDog(DogBean dog) throws SQLException {
    	System.out.println(INSERT_DOGS_SQL);
        		
        try (Connection connection = getConnection(); 
        	PreparedStatement preparedStatement = connection.prepareStatement(INSERT_DOGS_SQL)) {
        	preparedStatement.setString(1, dog.getDogName());
        	preparedStatement.setString(2, dog.getDogType());
        	preparedStatement.setString(3, dog.getDogOwner());
        	System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
            
        	} catch (SQLException e) {
            printSQLException(e);
        	}
    }
    public DogBean selectDog(int id) {
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
                String DogOwner = rs.getString("dog_owner");
                dog = new DogBean(id, DogName, DogType, DogOwner);
            }
       } catch (SQLException e) {
    	   printSQLException(e);
       }
       return dog;
    }

    public List < DogBean > selectAllDogs(String dog_owner) {
    	// using try-with-resources to avoid closing resources (boiler plate code)
        List < DogBean > dogs = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
        	
        	// Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DOG);) {
        	preparedStatement.setString(1, dog_owner);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
            	int id = rs.getInt("id");
                String DogName = rs.getString("dog_name");
                String DogType = rs.getString("dog_type");
                String DogOwner = rs.getString("dog_owner");
                dogs.add(new DogBean(id, DogName, DogType, DogOwner));
                System.out.println("Added dog row: " + id);
            }
            } catch (SQLException e) {
                printSQLException(e);
            }
            return dogs;
    }
    
    public boolean deleteDog(int id) throws SQLException {
    	boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_DOG_SQL);) {
        	statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
    
    public boolean updateDog(DogBean dog) throws SQLException {
    	boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_DOG_SQL);) {
        	statement.setString(1, dog.getDogName());
            statement.setString(2, dog.getDogType());
           // statement.setString(3, dog.getDogOwner());
            statement.setInt(3, dog.getId());

            rowUpdated = statement.executeUpdate() > 0;
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