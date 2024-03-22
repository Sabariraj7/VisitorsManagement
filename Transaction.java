package control;
import java.sql.SQLException;

import model.TransactionDAO;

public class Transaction {

	public void worker(String custid,String unId) throws SQLException {
		TransactionDAO tn= new TransactionDAO();
		//if(tn.customerExists(custid))
			tn.addcust(custid,unId);
//		else
//			System.out.println("Customer Not Found");
		
	}

	public static void out(String custid, String unId) throws Exception {
		System.out.println("passed");
		TransactionDAO tn= new TransactionDAO();
		tn.exitcust(custid,unId);
	}

}
