package model;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Console.ConnectionDB;

public class TransactionDAO {

	public void addcust(String custid,String uId) throws SQLException {
		Connection con=ConnectionDB.createConnection();
		String query="select rideName from users where Uid='"+uId+"'";
		System.out.println(query);
		Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery(query);
        String a = null;
        while(rs.next()) {
        	a=rs.getString("rideName");
        	System.out.print(a);
        }
       String query1="INSERT INTO  transactions  (custid,rideName,intime)  VALUES ('"+ custid+ "','"+ a +"', current_time());";
        //System.out.println(query1);
        stmt.executeUpdate(query1);
        //addcust1(custid,a);
	}
	
//	public void addcust1(String custid,String a) throws SQLException {
//		// TODO Auto-generated method stub
//		
//		Connection con=ConnectionDB.createConnection();
//		String query1="INSERT INTO  transactions  (custid,rideName,intime)  VALUES ('"+ custid+ "','"+ a +"',current_time())";
//		Statement stmt=con.createStatement();
//        stmt.executeQuery(query1);
//		
//	}

	public void exitcust(String custid, String uId) throws Exception {
		Connection con=ConnectionDB.createConnection();
		String query2="UPDATE transactions set outtime = current_time() where custid = '"+ custid +"' ;" ;
		String query="select rideName from transactions where custid='"+ custid+ "' ";
		
		
		
		//System.out.println(query2);
		Statement stmt=con.createStatement();
        stmt.executeUpdate(query2);
        Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		System.out.println("Completed Rides");
		while(rs.next()) {
			String s=rs.getString("rideName");
			
			System.out.println(s);
		}
	}

	public static void disp() throws Exception {
		Connection con=ConnectionDB.createConnection();
		String query="select *from customerdetails ;";
		//System.out.print(query);
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		
		while(rs.next()) {
			String custName=rs.getString("CustName");
			String custid=rs.getString("custid");
			String phoneno=rs.getString("phoneNO");
			String indate=rs.getString("indate");
			String intime=rs.getString("intime");
			
			System.out.println(custName+"  "+custid+"  "+ phoneno+"  "+indate+"  "+intime);
		}
		
	}
	
	
	public boolean customerExists(String custid) throws SQLException {
		Connection con = ConnectionDB.createConnection();
		String query="select * from customerdetails where custid = '"+custid+"';";
		//System.out.print(query);
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		
		boolean b = rs.next();
		
		if(!b) System.out.println("\nCustomer not found!\nEnter valid customer id.");
		
		return b;
	}

	public static void iddisp(String id) throws Exception {
		// TODO Auto-generated method stub
		Connection con = ConnectionDB.createConnection();
		String query="select rideName from transactions where custid = '"+id+"';";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		while(rs.next()) {
			String ridename=rs.getString("rideName");
			System.out.println(ridename);
		}
		
	}
	
	

}
