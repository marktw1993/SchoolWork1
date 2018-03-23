import java.sql.*;
import java.util.*;
 
//performs database functions
public class database {
	
	//creates a new course
	public void addCourse(){                                
		try{
			//creates new scanner object and db connection
			Scanner scan = new Scanner(System.in);
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection conn = DriverManager.getConnection("jdbc:odbc:StudentRegistration_DSN");
			Statement st = conn.createStatement();
			
			//requests for information
			System.out.println("Please enter the course title: ");
			String title = scan.nextLine();
			System.out.println("Please enter the course's code: ");
			String code = scan.next();
			
			//issues server command
			st.executeUpdate("INSERT INTO course VALUES('"+code+"','"+title+"')");
			
			//prints out the relation after changes
			ResultSet rs = st.executeQuery("SELECT * FROM course");
			code = "";
			title = "";
			System.out.println("This is the course relation as of current changes.");                     
			while (rs.next()){
			   code=rs.getString(1);
			   title=rs.getString(2);
			   System.out.println("Code: " + code + " Title: " + title);
			}
			System.out.println("Please make another choice");
			
			rs.close();
			st.close();
			conn.close();
			scan.close();
		}
		catch (Exception e){
			System.out.println(e);
		}
	}

	//removes a course
	public void deleteCourse(){
		try{
			//creates new scanner object and db connection
			Scanner scan = new Scanner(System.in);
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection conn = DriverManager.getConnection("jdbc:odbc:StudentRegistration_DSN");
			Statement st = conn.createStatement();
			
			//request for information
			System.out.println("Please enter the code for the course you would like to delete: ");
			String code = scan.next();
			
			//issues server commands
			st.executeUpdate("DELETE FROM registered WHERE code = '"+code+"'");
			st.executeUpdate("DELETE FROM course WHERE code = '"+code+"'");

			//prints out the relation after changes
			ResultSet rs = st.executeQuery("SELECT * FROM course");
			code = "";
			String title = "";
			System.out.println("This is the course relation as of current changes.");                     
			while (rs.next()){
				code=rs.getString(1);
				title=rs.getString(2);
				System.out.println("Code: " + code + " Title: " + title);
			}
			rs.close();
			st.close();
			conn.close();
			scan.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	//enrolls a student at the school
	public void enrollStudent(){
		try{
			//creates new scanner object and db connection
			Scanner scan = new Scanner(System.in);
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection conn = DriverManager.getConnection("jdbc:odbc:StudentRegistration_DSN");
			Statement st = conn.createStatement();
			
			//requests for information
			System.out.println("Please enter the student's full name: ");
			String name = scan.nextLine();
			System.out.println("Please enter the student's address: ");
			String address = scan.nextLine();
			System.out.println("Please enter the code for the student's major: ");
			String major = scan.next();
			System.out.println("Please enter the student's SSN: ");
			int ssn = scan.nextInt();
			
			//issues server command
			st.executeUpdate("INSERT INTO student VALUES ("+ssn+",'"+name+"','"+address+"','"+major+"')");
			
			//prints out the relation after changes
			ResultSet rs = st.executeQuery("SELECT * FROM student");
			ssn = 0;
			name = "";
			address = "";
			major = "";
			System.out.println("This is the student relation as of current changes.");                       
			while (rs.next()){
				ssn=rs.getInt(1);
				name=rs.getString(2);
				address=rs.getString(3);
				major=rs.getString(4);
				System.out.println("SSN: "+ssn+" Name: "+name+" Address: "+address+" Major: "+major);
			}
			rs.close();
			st.close();
			conn.close();
			scan.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	//deletes a student
	public void deleteStudent(){
		try{
			//creates new scanner object and db connection
			Scanner scan = new Scanner(System.in);
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection conn = DriverManager.getConnection("jdbc:odbc:StudentRegistration_DSN");
			Statement st = conn.createStatement();
			
			//requesting information
			System.out.println("Please enter the SSN (without hyphens) of the student you wish to remove: ");
			int ssn = scan.nextInt();
			
			//server commands
			st.executeUpdate("DELETE FROM registered WHERE ssn = "+ssn);
			st.executeUpdate("DELETE FROM student WHERE ssn = "+ssn);
			
			//prints out the relation after changes
			ResultSet rs = st.executeQuery("SELECT * FROM student");
			ssn = 0;
			String name = "";
			String address = "";
			String major = "";
			System.out.println("This is the student relation as of current changes.");                       
			while (rs.next()){
				ssn=rs.getInt(1);
				name=rs.getString(2);
				address=rs.getString(3);
				major=rs.getString(4);
				System.out.println("SSN: "+ssn+" Name: "+name+" Address: "+address+" Major: "+major);
			}
			rs.close();
			st.close();
			conn.close();
			scan.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	//registers a student for a course
	public void registerStudent(){
		try{
			//creates new scanner object and db connection
			Scanner scan = new Scanner(System.in);
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection conn = DriverManager.getConnection("jdbc:odbc:StudentRegistration_DSN");
			Statement st = conn.createStatement();
			
			//requests for information
			System.out.println("Please enter the SSN of the student you would like to register courses for: ");
			int ssn = scan.nextInt();
			System.out.println("Please enter the course code you would like to register the student with: ");
			String code = scan.next();
			System.out.println("Please enter the year the course is offered: ");
			int year = scan.nextInt();
			System.out.println("Please enter the semester the course if offered: ");
			String sem = scan.next();
			
			//server command
			st.executeUpdate("INSERT INTO registered (ssn, code, year, semester) VALUES (("+ssn+"), ('"+code+"'), ("+year+"), ('"+sem+"'))");
			
			//prints out the relation after changes
			ResultSet rs = st.executeQuery("SELECT * FROM registered");
			ssn = 0;
			System.out.println("This is the registered relation as of current changes.");                      
			while (rs.next()){
				ssn=rs.getInt(1);
				code=rs.getString(2);
				year=rs.getInt(3);
				sem=rs.getString(4);
				System.out.println("SSN: "+ssn+" Code: "+code+" Year: "+year+" Semester: "+sem);
			}
			rs.close();
			st.close();
			conn.close();
			scan.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	//drops a course
	public void dropCourse(){
		try{
			//creates new scanner object and db connection
			Scanner scan = new Scanner(System.in);
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection conn = DriverManager.getConnection("jdbc:odbc:StudentRegistration_DSN");
			Statement st = conn.createStatement();
			
			//requests for information
			System.out.println("Please enter the SSN of the student dropping a class: ");
			int ssn = scan.nextInt();
			System.out.println("Please enter the course code of the class being dropped: ");
			String code = scan.next();
			System.out.println("Please enter the year the course is offered: ");
			int year = scan.nextInt();
			System.out.println("Please enter the semester the course if offered: ");
			String sem = scan.next();
			
			//server command
			st.executeUpdate("DELETE FROM registered WHERE ssn = "+ssn+" AND code = '"+code+"' AND year = "+year+" AND semester = '"+sem+"'");
			
			//prints out the relation after changes
			ResultSet rs = st.executeQuery("SELECT * FROM registered");
			ssn = 0;
			System.out.println("This is the registered relation as of current changes.");   
			while (rs.next()){
				ssn=rs.getInt(1);
				code=rs.getString(2);
				year=rs.getInt(3);
				sem=rs.getString(4);
				System.out.println("SSN: "+ssn+" Code: "+code+" Year: "+year+" Semester: "+sem);
			}
			rs.close();
			st.close();
			conn.close();
			scan.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	//lists registration
	public void checkReg(){
		try{
			//creates new scanner object and db connection
			Scanner scan = new Scanner(System.in);
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection conn = DriverManager.getConnection("jdbc:odbc:StudentRegistration_DSN");
			Statement st = conn.createStatement();
			
			//variable declaration
			int ssn;
			String studName;
			ResultSet rs;
			System.out.println("Please enter the student's full name or SSN (no hyphens): ");
			
			//checks which information was given and issues the appropriate query
			if (scan.hasNextInt()){
				ssn = scan.nextInt();
				rs = st.executeQuery("SELECT * FROM registered WHERE ssn = "+ssn);
			}
			else{
				studName = scan.nextLine();
				rs = st.executeQuery("SELECT r.ssn, code, year, semester FROM student, registered r WHERE name = '"+studName+"' AND student.ssn = r.ssn");
			}
			
			//prints out the relation after changes
			ssn = 0;
			String code, sem;
			int year;
			if (!rs.next()){
				System.out.println("This student is not currently enrolled.");
			}
			else{
				System.out.println("This is the record matching that information.");
				while (rs.next()){
					ssn=rs.getInt(1);
					code=rs.getString(2);
					year=rs.getInt(3);
					sem=rs.getString(4);
					System.out.println("SSN: "+ssn+" Code: "+code+" Year: "+year+" Semester: "+sem);
				}
			}
			rs.close();
			st.close();
			conn.close();
			scan.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}