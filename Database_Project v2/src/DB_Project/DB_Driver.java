package DB_Project;
import java.sql.*;
import java.util.Scanner;

public class DB_Driver 
{
	public static void main(String[] args)
	{
		try
		{
		    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	        Connection con = DriverManager.getConnection("jdbc:odbc:CSCUI520DB");
	        
	        Statement st = con.createStatement();	        
	        st.executeUpdate("insert into login values('mark','12345')");
	        st.executeUpdate("insert into login values('mark2','12345')");
	        con.commit();
	        
            ResultSet rs = st.executeQuery("select * from login");
            String user = "";
            String password = "";
            
            while (rs.next())
            {
               user=rs.getString(1);
               password=rs.getString(2);
               System.out.println("ID: " + user + "   password: " + password);
            }
            
			//Greeting message 
			Scanner scan = new Scanner(System.in);
			
			int response=0;
			while(response != 10){
				printMenu();
				response = scan.nextInt();
				if(response == 1){
					
				}
				else if(response == 2){
					
				}
				else if(response == 3){
					
				}
				else if(response == 4){
					
				}
				else if(response == 5){
					
				}
				else if(response == 6){
					
				}
				else if(response == 7){
					
				}
				else if(response == 8){
					
				}
				else if(response == 9){
					
				}
				else if(response == 10){
					System.out.println("Thank you for using the Online Registration System, now exiting.");
				}
				else{
					System.out.println(response + " is not a valid input, please try again.");
				}
			}
			scan.close();
            rs.close();
            st.close();
            con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static void printMenu()
	{
		System.out.println("*********************************************************************");
		System.out.println("***                                                               ***");
		System.out.println("***           Welcome to the Online Registration System           ***");
		System.out.println("***                                                               ***");
		System.out.println("*********************************************************************");
		System.out.println();
		System.out.println("\t 1. Add a course");
		System.out.println("\t 2. Delete a course");
		System.out.println("\t 3. Add a student");
		System.out.println("\t 4. Delete a student");
		System.out.println("\t 5. Register a course");
		System.out.println("\t 6. Drop a course");
		System.out.println("\t 7. Check student registration");
		System.out.println("\t 8. Upload grades");
		System.out.println("\t 9. Check grade");
		System.out.println("\t 10. Quit");
	}
}