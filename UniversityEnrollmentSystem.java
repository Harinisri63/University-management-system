package assignment;

import java.sql.*;
import java.util.Scanner;

public class UniversityEnrollmentSystem 
{
    public static void main(String[] args) 
    {
        try
        {
        	String url="jdbc:mysql://localhost:3306/university";
        	String username="root";
        	String password="santhiya147";
        	Connection conn = DriverManager.getConnection(url,username,password);
            Scanner scanner = new Scanner(System.in);
            while (true) {
            	int ch;
                System.out.println("\nUNIVERSITY ENROLLMENT SYSTEM: \n");
                System.out.println("1. Student details");
                System.out.println("2. Course details");
                System.out.println("3. Enrollment details");
                System.out.println("4. Faculty details");
                System.out.println("5. Exit");
                System.out.print("\nEnter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                    	while(true)
                    	{
                    		System.out.println("\nSTUDENTS DETAILS: \n");
                        	System.out.println("1. Add Student");
                            System.out.println("2. Update Student");
                            System.out.println("3. Delete Student");
                            System.out.println("4. Display Student Table");
                        	System.out.println("0. Exit");
                            System.out.print("\nEnter your choice: ");
                            ch = scanner.nextInt();
                            scanner.nextLine();
                            if(ch==0)
                            	break;
                            switch(ch)
                            {
                            	case 1:
                            		addStudent(conn, scanner);
                                    break;
                            	case 2:
                            		updateStudent(conn, scanner);
                            		break;
                            	case 3:
                            		deleteStudent(conn,scanner);
                            		break;
                            	case 4:
                            		displayStudent(conn);
                            		break;
                            	default:
                            		break;
                            }
                    	}
                        break;
                    case 2:
                    	while(true)
                    	{
                    		System.out.println("\nCOURSE DETAILS: \n");
                        	System.out.println("1. Add Course");
                            System.out.println("2. Update Course");
                            System.out.println("3. Display Course Table");
                            System.out.println("0. Exit");
                            System.out.print("\nEnter your choice: ");
                            ch = scanner.nextInt();
                            scanner.nextLine();
                            if(ch==0)
                            	break;
                            switch(ch)
                            {
                            	case 1:
                                    addCourse(conn, scanner);
                                    break;
                            	case 2:
                                    updateCourse(conn, scanner);
                            		break;
                            	case 3:
                            		displayCourse(conn);
                            		break;
                            	default:
                            		break;
                            }
                    	}
                        break;
                    case 3:
                    	while(true)
                    	{
                    		System.out.println("\nENROLLMENT DETAILS: ");
                        	System.out.println("1. Enroll Course");
                            System.out.println("2. Unenroll Course");
                            System.out.println("3. Display Enrollments Table");
                            System.out.println("0. Exit");
                            System.out.print("\nEnter your choice: ");
                            ch = scanner.nextInt();
                            scanner.nextLine();
                            if(ch==0)
                            	break;
                            switch(ch)
                            {
                            	case 1:
                                    enrollStudent(conn, scanner);
                                    break;
                            	case 2:
                                    unenrollStudent(conn, scanner);
                            		break;
                            	case 3:
                            		displayEnrollments(conn);
                            	default:
                            		break;
                            }
                    	}
                        break;
                    case 4:
                    	while(true)
                    	{
                    		System.out.println("\nFACULTY DETAILS: ");
                        	System.out.println("1. Assign Course");
                            System.out.println("2. Remove Course");
                            System.out.println("3. Display Faculty Table");
                            System.out.println("0. Exit");
                            System.out.print("\nEnter your choice: ");
                            ch = scanner.nextInt();
                            scanner.nextLine();
                            if(ch==0)
                            	break;
                            switch(ch)
                            {
                            	case 1:
                                    assignFacultyToCourse(conn, scanner);
                                    break;
                            	case 2:
                                    removeFacultyToCourse(conn, scanner);
                            		break;
                            	case 3:
                            		displayFaculty(conn);
                            		break;
                            	default:
                            		break;
                            }
                    	}
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice!");
                }
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }
    private static void addStudent(Connection conn, Scanner scanner) 
    {
        try
        {
        	System.out.print("Enter roll no: ");
        	int rollno=scanner.nextInt();
            scanner.nextLine();
        	System.out.print("Enter student name: ");
            String name = scanner.nextLine();
            System.out.print("Enter student email: ");
            String email = scanner.nextLine();
        	String query1 = "INSERT INTO Students (roll_no,name, email_id) VALUES (?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(query1);
            stmt.setInt(1, rollno);
            stmt.setString(2, name);
            stmt.setString(3, email);
            int rows=stmt.executeUpdate();
            if (rows > 0) 
            {
                System.out.println("Student added successfully.");
            } 
            else 
            {
                System.out.println("Failed to add student.");
            }
        }
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }

    private static void updateStudent(Connection conn, Scanner scanner) 
    {
        try
        {
        	System.out.print("Enter roll no: ");
        	int rollno=scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
        	String query1 = "UPDATE Students SET name=? WHERE roll_no=?";
            PreparedStatement stmt = conn.prepareStatement(query1);
            stmt.setString(1, name);
            stmt.setInt(2, rollno);
            int rows=stmt.executeUpdate();
            if (rows > 0) 
            {
                System.out.println("Student details updated successfully.");
            } 
            else 
            {
                System.out.println("Failed to update student details.");
            }
        }
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    
    private static void deleteStudent(Connection conn, Scanner scanner) 
    {
        try
        {
        	System.out.print("Enter roll no: ");
        	int rollno=scanner.nextInt();
            scanner.nextLine();
        	String query1 = "DELETE FROM Students WHERE roll_no=?";
            PreparedStatement stmt = conn.prepareStatement(query1);
            stmt.setInt(1, rollno);
            int rows=stmt.executeUpdate();
            if (rows > 0) 
            {
                System.out.println("Student record deleted successfully.");
            } 
            else 
            {
                System.out.println("Failed to delete student details.");
            }
        }
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    
    private static void displayStudent(Connection conn)
    {
    	try
    	{
    		Statement st=conn.createStatement();
    		ResultSet rs=st.executeQuery("SELECT * FROM Students");
    		while(rs.next())
    		{
    			System.out.printf("%-5d %-15s %-10s\n",rs.getInt("roll_no"),rs.getString("name"),rs.getString("email_id"));
    		}
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    
    private static void addCourse(Connection conn, Scanner scanner) 
    {
        try
        {
        	System.out.print("Enter course id: ");
            String course_id = scanner.nextLine();
        	System.out.print("Enter course name: ");
            String course_name = scanner.nextLine();
            System.out.print("Enter faculty name: ");
            String faculty = scanner.nextLine();
            String query = "INSERT INTO Courses (course_id,course_name,faculty) VALUES (?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, course_id);
            stmt.setString(2, course_name);
            stmt.setString(3, faculty);
            int rows = stmt.executeUpdate();
            if (rows > 0) 
            {
            	System.out.println("Course added successfully.");
            }
            else 
            {
            	System.out.println("Failed to add course.");
            }
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
    }
    
    private static void updateCourse(Connection conn, Scanner scanner) 
    {
        try
        {
        	System.out.print("Enter course id: ");
        	String course_id=scanner.nextLine();
        	System.out.print("Enter course name: ");
            String course_name = scanner.nextLine();
        	String query1 = "UPDATE Courses SET course_name=? WHERE course_id=?";
            PreparedStatement stmt = conn.prepareStatement(query1);
            stmt.setString(1, course_name);
            stmt.setString(2, course_id);
            int rows=stmt.executeUpdate();
            if (rows > 0) 
            {
                System.out.println("Course details updated successfully.");
            } 
            else 
            {
                System.out.println("Failed to update course details.");
            }
        }
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }

    private static void displayCourse(Connection conn)
    {
    	try
    	{
    		Statement st=conn.createStatement();
    		ResultSet rs=st.executeQuery("SELECT * FROM Courses");
    		while(rs.next())
    		{
    			System.out.printf("%-5s %-40s %-10s\n",rs.getString("course_id"),rs.getString("course_name"),rs.getString("faculty"));
    		}
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    
    private static void enrollStudent(Connection conn, Scanner scanner)
    {
        try
        {
        	System.out.print("Enter roll no: ");
            int rollno = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter course ID: ");
            String courseId = scanner.nextLine();
            String query = "INSERT INTO Enrollments (roll_no, course_id) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, rollno);
            stmt.setString(2, courseId);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) 
            {
                System.out.println("Student enrolled successfully.");
            } 
            else 
            {
            	System.out.println("Failed to enroll course.");
            }
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
    }

    private static void unenrollStudent(Connection conn, Scanner scanner)
    {
        try
        {
        	System.out.print("Enter roll no: ");
            int rollno = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter course ID: ");
            String courseId = scanner.nextLine();
            String query = "DELETE FROM Enrollments WHERE roll_no=? and course_id=?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, rollno);
            stmt.setString(2, courseId);
            int rows= stmt.executeUpdate();
            if (rows> 0) 
            {
                System.out.println("Student unenrolled successfully.");
            } 
            else 
            {
            	System.out.println("Failed to unenroll course.");
            }
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
    }
    
    private static void displayEnrollments(Connection conn)
    {
    	try
    	{
    		Statement st=conn.createStatement();
    		ResultSet rs=st.executeQuery("SELECT * FROM Enrollments");
    		while(rs.next())
    		{
    			System.out.printf("%-5d %-5d %-10s\n",rs.getInt("enrollment_id"),rs.getInt("roll_no"),rs.getString("course_id"));
    		}
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    
    private static void assignFacultyToCourse(Connection conn, Scanner scanner)
    {
        try
        {
        	System.out.print("Enter faculty name: ");
            String faculty_name = scanner.nextLine();
            System.out.print("Enter department: ");
            String dept = scanner.nextLine();
            System.out.print("Enter course name: ");
            String coursename = scanner.nextLine();
            String sql = "INSERT INTO Faculty(name,department,course) VALUES (?,?,?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, faculty_name);
                stmt.setString(2, dept);
                stmt.setString(3, coursename);
                int rows= stmt.executeUpdate();
                if (rows> 0) {
                    System.out.println("Faculty assigned to course successfully.");
                } else {
                    System.out.println("Failed to assign faculty to course.");
                }
            }
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
    }
    
    private static void removeFacultyToCourse(Connection conn, Scanner scanner)
    {
        try
        {
        	System.out.print("Enter faculty name: ");
            String faculty_name = scanner.nextLine();
            System.out.print("Enter course name: ");
            String coursename = scanner.nextLine();
            String sql = "DELETE FROM Faculty WHERE name=? and course=?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, faculty_name);
                stmt.setString(2, coursename);
                int rows= stmt.executeUpdate();
                if (rows> 0) {
                    System.out.println("Faculty removed from course successfully.");
                } else {
                    System.out.println("Failed to remove faculty from course.");
                }
            }
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
    }
    private static void displayFaculty(Connection conn)
    {
    	try
    	{
    		Statement st=conn.createStatement();
    		ResultSet rs=st.executeQuery("SELECT * FROM Faculty");
    		while(rs.next())
    		{
    			System.out.printf("%-5d %-20s %-10s %-10s\n",rs.getInt("faculty_id"),rs.getString("name"),rs.getString("department"),rs.getString("course"));
    		}
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
}