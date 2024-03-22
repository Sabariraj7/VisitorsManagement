package model;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import Console.ConnectionDB;

public class CustomerDAO {

	public void addnewCust(String custName, String custid, String phoneNO, String location) throws Exception {
		// TODO Auto-generated method stub
		Connection con=ConnectionDB.createConnection();
		String query="INSERT INTO customerdetails (Custname,custid,phoneNO,location,indate,intime)"
                + "VALUES( '"+custName+"', '"+custid+"','"+phoneNO +"','"+ location +"',current_date(), current_time());";
		Statement stmt=con.createStatement();
        stmt.execute(query);
		
	}

	public static void exit(String cidex) throws Exception {
		Connection con=ConnectionDB.createConnection();
		String query = "update customerdetails set outdate= current_date(), outtime =current_time()  where custid='"+cidex+"' ";
		Statement stmt=con.createStatement();
        stmt.execute(query);
	}

	public static void dispAll() throws Exception {
		Connection con=ConnectionDB.createConnection();
		String query="Select * from customerdetails;";
		Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery(query);
        while(rs.next()) {
        	String custname=rs.getString("CustName");
        	String custid=rs.getString("custid");
        	String phoneno=rs.getString("phoneNO");
        	String location=rs.getString("location");
        	String indate=rs.getString("indate");
        	String intime=rs.getString("intime");
        	String outdate=rs.getString("outdate");
        	String outtime=rs.getString("outtime");
        	
        	System.out.println(custname +"  "+custid+"  "+phoneno +"  "+location+"  "+ indate+"  " + intime +"  " +outdate+"  "+ outtime );
        }
	}

}
