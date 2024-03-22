package control;

import model.CustomerDAO;

public class Customer {
	String CustName ;
	String custid ;
	String phoneNO ;
	String location;
	public Customer(String custName, String custid, String phoneNO, String location) {
		this.CustName =custName;
		this.custid =custid ;
		this.phoneNO =phoneNO;
		this.location =location;
	}

	public void addCust() throws Exception {
		CustomerDAO cust=new CustomerDAO();
		cust.addnewCust(CustName,custid,phoneNO,location);
		System.out.println("Added Successful");
		
	}

	public static void displayCustomerView(String uId) {
		// TODO Auto-generated method stub
		
	}

}
