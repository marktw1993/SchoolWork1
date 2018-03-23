import java.util.*;

public class driver {

	public static void main(String[] args) {
			
		//creates scanner and database objects
		Scanner scan = new Scanner(System.in);
		database db = new database();
		int choice = scan.nextInt();
		while(choice != 8){
			System.out.println();
			welcomeMessage();
			choice = scan.nextInt();
			//create a new course
			if (choice == 1)
				db.addCourse();
			//remove a course
			else if(choice == 2)			
				db.deleteCourse();
			//enroll a student
			else if(choice == 3)
				db.enrollStudent(); 
			//delete a student
			else if(choice == 4)
				db.deleteStudent(); 
			//register for a course
			else if(choice == 5)
				db.registerStudent(); 
			//drop a course
			else if(choice == 6)
				db.dropCourse(); 
			//check student registration
			else if(choice == 7)
				 db.checkReg(); 
			else
				System.out.println("Invalid input, please try again.");
			
		}
		scan.close();
	}
			
	//provides the interface to be used
	public static void welcomeMessage(){
		System.out.println();
		System.out.println("***********************************************************");
		System.out.println();
		System.out.println("***                                                     ***");
		System.out.println();
		System.out.println("***      Welcome to the Online Registration System      ***");
		System.out.println();
		System.out.println("***                                                     ***");
		System.out.println();
		System.out.println("***********************************************************");
		System.out.println();
		System.out.println("Please make a selection:");
		System.out.println("1. Create a new course");
		System.out.println("2. Remove a course");
		System.out.println("3. Enroll a student");
		System.out.println("4. Delete a student");
		System.out.println("5. Register for a course");
		System.out.println("6. Drop a course");
		System.out.println("7. Check student registration");
		System.out.println("8. Quit");
	}
}





