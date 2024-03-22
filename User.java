package control;
import java.sql.SQLException;

import model.UserDAO;

public class User {
	//private String Uid ,Upass;
	private static String RideName;
    private static  String designation;
    private static  String name;
	private static  String loginId;
	private static  String password;
    
    public User(String name,String designation, String loginId, String password,String RideName) {
        this.name = name;
        this.designation = designation;    
        this.loginId = loginId;
        this.password = password;
        this.RideName=RideName;
    }
    
    public static boolean validate(String uId, String password, String designation) throws Exception {
        try {
            String pass=UserDAO.validate(uId,password,designation);
            if(password.equals(pass)) {
            	//System.out.print("passed");
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }
    
    
    public static void addUser() throws Exception{
        try{
            UserDAO userDAO = new UserDAO();
			UserDAO.addUser(name, designation, loginId, password, RideName);
            System.out.println("Added Successful");
        } catch (SQLException e) {
            System.out.println("Insertion Failed\n"+e);
        }
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getRideName() {
        return RideName;
    }

    public void setRideName(String RideName) {
        this.RideName = RideName;
    }

	
}
    
    
    