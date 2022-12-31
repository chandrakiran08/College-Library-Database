import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SQLCon{
	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/college_library","root","kiran08");
		}catch(Exception e){System.out.println(e);}
		return con;
	}

}
