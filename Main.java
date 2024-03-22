package View;
import java.util.Scanner;

import control.Customer;
import control.Transaction;
import control.User;
import model.CustomerDAO;
import model.TransactionDAO;

public class Main {
    static Scanner sc=new Scanner(System.in);
    public static String unId;
    public static void main(String[] args) throws Exception {
        System.out.println("-----------------------------");
        System.out.println("|                           |");
        System.out.println("|   CHILLOUT THEME PARK     |");
        System.out.println("|                           |");
        System.out.println("-----------------------------");
        String designation="0";
        do {
            System.out.print("Enter Login Id: ");
            String uId=sc.nextLine();
            unId=uId;
            System.out.print("Enter Password: ");
            String password=sc.nextLine();
            System.out.println("-------------------------------------------------------------");
            System.out.print("Menu:\n1. Admin\n2. Worker\n3. Exit\nEnter Your Choice: ");
            switch (sc.nextLine()){
                case "1":
                    designation="A";
                    break;
                case "2":
                	
                    designation="W";
                    break;
                case "3":
                    System.out.println("Thank You ");
                    return;
                default:
                    System.out.println("Enter valid option.");
                    continue;
            }
            
            if(User.validate(uId,password, designation)){
                switch (designation){
                    case "A":
                        displayAdminView();
                        break;
                    case "W":
                    	
                    	displayWorkerView();
                        break;
                    case "C":
                        Customer.displayCustomerView(uId);
                        break;
                }
            }
            else {
                System.out.println("Id Password is Incorrect.");
            }
        }while (designation!="E");

    }
    
    public static void displayWorkerView() throws Exception {
    	String choi;
    	do {
    		System.out.println("____________________________");
    		System.out.println("RIDE :\n1:IN\n2:OUT\n3:CLOSE");
    		choi=sc.nextLine();
    		switch(choi) {
    		case "1":
    			TransactionDAO tn= new TransactionDAO();
    			//if
    			String custid;
    			do{
    				System.out.println("ENTER ID:");
    				custid=sc.nextLine();
    			}while(!tn.customerExists(custid));
    			
    			Transaction tran=new Transaction();
    			tran.worker(custid,unId);
                break;
                
    		case "2":
    			System.out.println("ENTER ID");
    			String custid1=sc.nextLine();
    			Transaction.out(custid1,unId);
    		    break;
    		case "3":
    			System.out.println("CLOSED");
    			return;
    		}
    	}while(true);
		
		
	}

	private static void displayAdminView() throws Exception {
        String choice;
        do{
            System.out.println("-------------------------------------------------------------");
            System.out.println("Menu:\n1. Add New User\n2. Add New Customer\n3. OutCustomer\n"
            		+ "4. DisplaycustomerIN\n5. Ridesdisplayid\n6. Show All Customer Details\n7. DisplayRides\n8. Logout");                                                            
            choice= sc.nextLine();
            switch (choice) {
                case "1":
	            	 System.out.print("Enter User Name: ");
	                 String name = sc.nextLine();
	                 System.out.print("Enter Designation ");
	                 String designation= sc.nextLine();
	                 System.out.print("Enter Login id: ");
	                 String loginId = sc.nextLine();
	                 System.out.print("Enter Login Password: ");
	                 String password = sc.nextLine();
	                 System.out.print("Enter ridename ");
	                 String RideName = sc.nextLine();
	                 sc.nextLine();
	       
					 User user = new User(name, designation , loginId, password,RideName);
					 user.addUser();
						 break;
                case "2":
                	System.out.println("Enter CustomerName");
                	String CustName=sc.nextLine();
                	System.out.println("Enter Custid");
                	String custid =sc.nextLine();
                	System.out.println("Enter phoneno");
                	String phoneNO =sc.nextLine();
                	System.out.println("Enter location");
                	String location =sc.nextLine();
                	Customer custom=new Customer(CustName,custid,phoneNO,location);
                	custom.addCust();
                	break;
                case "3":
                    System.out.println("Enter Custid for Exit");
                    String cidex=sc.nextLine();
                    CustomerDAO.exit(cidex);
                    break;
                case "4":
                	TransactionDAO.disp();
                	break;
                case "5":
                	System.out.println("Enter id to Display");
                	String id=sc.nextLine();
                	TransactionDAO.iddisp(id);
                	break;
                case "6":
                	System.out.println("Show All Customer Details");
                	CustomerDAO.dispAll();
                	break;
                case "7":
                	System.out.println("___________RIDES_____________");
                	System.out.println("Bumper cars");
                	System.out.println("Dark ride");
                	System.out.println("pendulum ride");
                	System.out.println("Ferris wheel");
                	System.out.println("Baloon race");
                	System.out.println("Breakdance");
                	System.out.println("Caterpillar");
                	System.out.println("Ferris wheel");
                	System.out.println("Freak out");
                	System.out.println("Fun slide");
                	System.out.println("Gyro tower");
                	System.out.println("Hurricane");
                	System.out.println("Kamikaze");
                	System.out.println("Ghost Rider");
                	System.out.println("______________________________");
                	
                	break;
//                case "8":
//                	alluser();
//                	break;
                case "8":
                    System.out.println("Logged Out.");
                    return;
                }
           }while (true);
    }

//	private static void alluser() {
//		// TODO Auto-generated method stub
//		
//		System.out.println("display all users");
//		
//		
//	}	
}
    