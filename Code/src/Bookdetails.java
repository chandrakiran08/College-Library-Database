
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Bookdetails {

	public static boolean checkbook(String bookid){
		boolean status=false;
		try{
			Connection con=SQLCon.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from book where bookid=?");
			ps.setString(1,bookid);
		    ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static int insertbook(String bookid,String Title,String Author){
		int status=0;
		try{
			Connection con=SQLCon.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into Book(bookid,Title,Author) values(?,?,?)");
			ps.setString(1,bookid);
			ps.setString(2,Title);
			ps.setString(3,Author);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static int deletebook(String id){
		int status=0;
		try{
			Connection con=SQLCon.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from book where bookid=?");
			ps.setString(1,id);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static int issuebook(String date,String bookid,String rollno){
		int status=0;
		try{
			Connection con=SQLCon.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into issue(issue_date,bookid,rollno) values(?,?,?)");
			ps.setString(2,bookid);
			ps.setString(3,rollno);
			ps.setString(1,date);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static int returnbook(String date,String bookid,String rollno){
		int status=0;
		try{
			Connection con=SQLCon.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into breturn(breturn_date,bookid,rollno) values(?,?,?)");
			ps.setString(2,bookid);
			ps.setString(3,rollno);
			ps.setString(1,date);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
}
