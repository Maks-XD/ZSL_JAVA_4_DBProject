package pl.zsl;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PersonDBLayer {
	public void addPerson(Person prsn) throws Exception {
		Connection connection = null;
		try {
			Class.forName("org.sqlite.JDBC");
	        	connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\snasiadk\\eclipse-workspace\\DBProject\\bin\\persons.db");

	        	Statement statement = connection.createStatement();
	        	statement.setQueryTimeout(30); 

	        	statement.executeUpdate("INSERT INTO Person values('"+prsn.getName()+"')");
	        
		}
	    	catch(SQLException e){
	    	 	System.err.println(e.getMessage());
	    	 	throw e;
	    	}
		catch (ClassNotFoundException e) {
			System.err.println(e.getMessage()); 
			throw e;
		}
	    	finally {         
			try {
				if(connection != null)
					connection.close();
			}
			catch(SQLException e) {          
				System.err.println(e); 
			}
	    }
	}
	
	public void removePerson (Person prsn) throws Exception {
		Connection connection = null;
		try {
			Class.forName("org.sqlite.JDBC");
	        	connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\snasiadk\\eclipse-workspace\\DBProject\\bin\\persons.db");

	        	Statement statement = connection.createStatement();
	        	statement.setQueryTimeout(30); 

	        	statement.executeUpdate("DELETE FROM Person WHERE name='"+ prsn.getName() + "'");
	        
		}
	    	catch(SQLException e){
	    	 	System.err.println(e.getMessage());
	    	 	throw e;
	    	}
		catch (ClassNotFoundException e) {
			System.err.println(e.getMessage()); 
			throw e;
		}
	    	finally {         
			try {
				if(connection != null)
					connection.close();
			}
			catch(SQLException e) {          
				System.err.println(e); 
			}
	    }
	}
	
	public List<Person> getPersons () throws Exception {
		List<Person> listOfPersons = new ArrayList<Person>();
	    	Class.forName("org.sqlite.JDBC");

		Connection connection = null;
		try {
	         	connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\snasiadk\\eclipse-workspace\\DBProject\\bin\\persons.db");

	         	Statement statement = connection.createStatement();
	         	statement.setQueryTimeout(30); 

	         	ResultSet resultSet = statement.executeQuery("SELECT name from Person");
	         	while(resultSet.next())
	         	{
	        	 	Person newPerson = new Person(resultSet.getString("name"));
	        	 	listOfPersons.add (newPerson);
	         	}
		}
	    	catch(SQLException e){
	    	 	System.err.println(e.getMessage()); 
	    	}       
	    	finally {         
			try {
				if(connection != null)
					connection.close();
			}
			catch(SQLException e) {        
				System.err.println(e); 
			}
	    	}
		
		return listOfPersons;
	}
}
