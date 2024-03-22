package model;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import Console.ConnectionDB;
public class UserDAO {
     
	public static String validate(String uId, String password, String designation) throws Exception {
		 String query="SELECT upass FROM users where Uid= '"+uId+"' and designation = '"+designation+"';";
	        Connection con=ConnectionDB.createConnection();
	        Statement stmt=con.createStatement();
	        ResultSet rs=stmt.executeQuery(query);
	        String pass=null;
	        while(rs.next()){
	            pass=rs.getString("upass");
	        }
	        return pass;
	}

	public static void addUser(String name, String designation, String loginId, String password, String rideName) throws Exception {
		Connection con=ConnectionDB.createConnection();
        String query="INSERT INTO USERS (Uname,designation,Uid,Upass,RideName)"
                + "VALUES( '"+name+"', '"+designation+"','"+loginId +"','"+ password +"','"+rideName+"');";
        //System.out.println(query);
        Statement stmt=con.createStatement();
        stmt.execute(query);
	}

}
