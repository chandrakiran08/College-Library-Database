import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Studentdetails {
	public static boolean checkstudent(String studid){
		boolean stat=false;
		try{
			Connection con=SQLCon.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from students where rollno=?");
			ps.setString(1,studid);
		    ResultSet rs=ps.executeQuery();
			stat=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return stat;
	}
	public static int insertstudent(String name,String rollno,String Branch, String Course){
		int status=0;
		try{
			Connection con=SQLCon.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into students(name,rollno,Branch,Course) values(?,?,?,?)");
			ps.setString(1,name);
			ps.setString(2,rollno);
			ps.setString(3,Branch);
			ps.setString(4,Course);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static int deletestudent(String id){
		int status=0;
		try{
			Connection con=SQLCon.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from students where rollno=?");
			ps.setString(1,id);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
}
