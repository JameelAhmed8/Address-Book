
import java.util.*;
import java.sql.DriverManager;
import java.sql.*;

public class PersonDAO
{      


	@SuppressWarnings("rawtypes")
	private ArrayList personsList;


	private Connection con;

	// constructor 
	@SuppressWarnings("rawtypes")
	public PersonDAO()
	{
		personsList = new ArrayList();
		getConnection();		//Create Connection to the Oracle Database
	}


	public Connection getConnection()
	{

		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");	

		} catch(java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		}

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/abook?" + "user=root&password=610093");
		} catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}

		return con;
	}

	public ArrayList searchPerson(String str)
	{
		try	{

			PreparedStatement st = con.prepareStatement("select * from Person where name=?");
			st.setString(1, str);

			ResultSet rs = st.executeQuery();  
			if (rs.next()) 
			{  
				String s = rs.getString(1);  
				String s1 = rs.getString(2);  
				long s2 = rs.getLong(3);  
				String s3 = rs.getString(4);  
				long s4 = rs.getLong(5);  

				System.out.println(s);
				System.out.println(s1);
				System.out.println(s2);
				System.out.println(s3);
				System.out.println(s4);


			}


		}


		catch(Exception e)
		{
			System.out.println(e);
		}

		return personsList;

	} 

	public void savePerson(PersonInfo person){
		try
		{
			String sql = "INSERT INTO Person(name, address, " +
					"phone, Gender, cnic) VALUES (?,?,?,?,?) ";

			// Create a Preparedstatement
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, person.getName());
			ps.setString(2, person.getAddress());
			ps.setLong(3, person.getPhone());
			ps.setString(4, person.getGender());
			ps.setLong(5, person.getId());


			ps.executeUpdate();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

	public void updatePerson(PersonInfo person)
	{

		//long cn =person.getId();
		try
		{
			String sql = "UPDATE Person SET name = ?, address=? , " +
					"phone=? , Gender=? where cnic=?";

			// Create a Prepared statement
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1 , person.getName());		
			ps.setString(2 , person.getAddress());
			ps.setLong(3 , person.getPhone());
			ps.setString(4 , person.getGender());
			ps.setLong(5, person.getId());

			ps.executeUpdate();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

	public int removePerson(long cn)
	{
		int no = 0;
		try{
			String sql = "DELETE FROM Person WHERE cnic = ?";
			// Create a Prepared statement
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, cn);
			no = ps.executeUpdate();
		}
		catch(Exception e){
			System.out.println(e);
		}
		return no;
	}

}