import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Logindetails {
	public static boolean checklogin(String id){
		boolean allow=false;
		try{
			Connection con=SQLCon.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from Librarian where id=?");
			ps.setString(1,id);
		    ResultSet rs=ps.executeQuery();
			allow=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return allow;
	}
	public static boolean checkpassword(String id,String pass){
		boolean state=false;
		try{
			Connection con=SQLCon.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from Librarian where id =? and password=?");
			ps.setString(1,id);
			ps.setString(2,pass);
		    ResultSet rs=ps.executeQuery();
			state=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return state;
	}
}
