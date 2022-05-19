/*
  The program is a console application to create a student database 
  It allows the user to create a list of students using array list, a text file is needed to store the list
  in order for the case 2 and case 3 of the switch statement to work
  The program is still in development
*/
package Database;
//Header file 
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.*;




public class TestStudents {
  
    public static void main(String[]args){
      //object of the class  
      Scanner input = new Scanner(System.in);

      //variables to be used
      int status=1;
      String name;
      String surname;
      int age;
      int year;
      String StudentNumber; //enrollment can be a mixture of numbers and characters

      //creating a text file to store the information
      try{
            File studentDatabase = new File("C:\\Users\\Lihle\\Desktop\\MyCourses\\Favtutor\\7-Projects\\Student-Database\\src\\Databasedatabase.txt"); //specifies the location of the file 
            if(studentDatabase.createNewFile())
            {
                System.out.println("Filename " +studentDatabase+ " is created!!");
            }else{
                System.out.println("File already exist");
            }
      }catch(Exception e)
      {
            System.out.println("An error occured while trying to create file");
      }

      while(status == 1)
      {
        //Program Menu
        System.out.println();
        System.out.println("\n========================="+"=========================");
        System.out.println("\tStudent Personal Details Database");
        System.out.println("========================="+"=========================");

        System.out.println("Please make a selection from the following");
        System.out.println("1. Create a database of students");
        System.out.println("2. Check if student exist on database");
        System.out.println("3. Change information of student");
        System.out.println("4. Exit");
        System.out.println("========================="+"=========================");
        System.out.print("Enter selection: ");
        int selection = input.nextInt();
        System.out.println("========================="+"=========================");
        System.out.println();

        //Arraylist for student class and constructor
        List<Student> studentsList = new ArrayList<Student>();

        switch(selection)
        {
            case 1:
                    int number;
                    System.out.print("How many students are you going to add: ");
                    number = input.nextInt();
                    System.out.println();
                    int numOfStudents[] = new int[number]; //array to store number of students to be entered on the database

                    for(int i=0; i<numOfStudents.length; i++)
                    {
                      int studentNum = i+1; //pointing to the student at use
                      System.out.print("Please enter data of the Student "+ studentNum);
                      System.out.println();
                      System.out.print("Enter Student Name: ");
                      name = input.next();
                      System.out.print("Enter Student Surname: ");
                      surname = input.next();
                      System.out.print("Enter Student Age: ");
                      age = input.nextInt();
                      System.out.print("Enter Year of Study: ");
                      year = input.nextInt();
                      System.out.print("Enter Student/Enrollment Number: ");
                      StudentNumber = input.next();
                      System.out.println();

                      //create the reference of the student class with its object
                      Student studentInfo = new Student(name, surname, age, year, StudentNumber);
                      //adding tht information to the ArrayList
                      studentsList.add(studentInfo);
                    
                    }
                    //display the entered information
                    for(int j=0; j<studentsList.size(); j++)
                    {
                      //extract the information of the student
                      Student getStudentInfo = studentsList.get(j);
                      System.out.println("Student "+(j+1));
                      System.out.println("Name\t\t: "+getStudentInfo.getName()+ "\nSurname\t\t: " +getStudentInfo.getSurname()+ "\nAge\t\t: "+getStudentInfo.getAge()+ "\nYear\t\t: "+getStudentInfo.getYear()+ "\nStudent Number\t: "+getStudentInfo.getStudentNumber());
                      System.out.println();
                    }
            break;
            case 2:
                    System.out.println("========================="+"=========================");
                    System.out.println("\tChecking ........");
                    System.out.println("========================="+"=========================");

                    System.out.print("Enter the name of the Student you want to search: ");
                    String check = input.next();
              
                    //for loop to check the ArrayList for the Student
                    for(int a=0; a<studentsList.size(); a++)
                    {
                      Student getStudentInfo = studentsList.get(a);
                      if((check.toLowerCase()).equals(getStudentInfo.getName().toLowerCase()))
                      {
                        System.out.println("Student is present on the database");
                        System.out.println("Details of the Student");
                        System.out.println("Name: "+getStudentInfo.getName()+ " Age: "+getStudentInfo.getAge()+ " Year: "+getStudentInfo.getYear()+ " Student Number: "+getStudentInfo.getStudentNumber());
                      }
                    }
                    System.out.println("Record not found");
            break;
            // case 3:
            //         System.out.println("Enter student list number: "); //
            //         int serialNum = input.nextInt();
            //         Student stu = studentsList.get(serialNum);
            //         System.out.println("Please enter the new information");

            //         System.out.print("Please enter data of the Student "+serialNum );
            //         System.out.println();
            //         System.out.print("Enter Student Name: ");
            //         name = input.next();
            //         System.out.print("Enter Student Surname: ");
            //         surname = input.next();
            //         System.out.print("Enter Student Age: ");
            //         age = input.nextInt();
            //         System.out.print("Enter Year of Study: ");
            //         year = input.nextInt();
            //         System.out.print("Enter Student/Enrollment Number: ");
            //         StudentNumber = input.next();
            //         System.out.println();

            //         System.out.println("Updated Information");
            //         System.out.println("Name: "+stu.getName()+ " Age: "+stu.getAge()+ " Year: "+stu.getYear()+ " Student Number: "+stu.getStudentNumber());
            // break;
        //     case 4:
        //             System.out.println("Thank You Bye!");
        //             System.exit(0);
        //     break;
        //     default:
        //             System.out.println("You have entered an incorrect value!");
        //     break;
         }
        //writing to the file
        try{
              FileWriter fileWrite = new FileWriter("C:\\Users\\Lihle\\Desktop\\MyCourses\\Favtutor\\7-Projects\\Student-Database\\src\\Databasedatabase.txt");
              BufferedWriter buffWrite = new BufferedWriter(fileWrite);
              for(int m=0; m<studentsList.size(); m++)
              {
                buffWrite.write(studentsList.get(m).toString());
              }
              buffWrite.flush();
              buffWrite.close();
        }catch(Exception e){
              System.out.println("An error occured while trying to write to file");
        }

        System.out.print("Please enter 1 to continue or 3 to exit: ");
        status = input.nextInt();
        if(status == 3)
        {
          selection = status;
        }else{
          //continue with the program
        }
      }
        input.close();
    }
}
