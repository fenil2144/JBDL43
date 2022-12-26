package Session4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTablewithoutMaven {
	
	public static void main(String args[]) throws SQLException {
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jbdl43","root","root1234");
		Statement statement = connection.createStatement();
		
		statement.execute("create table maven_dummy(id int,name varchar(30))");
	}

}
