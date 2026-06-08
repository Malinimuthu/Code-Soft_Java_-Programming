import java.util.ArrayList;
import java.util.Scanner;


class Student {
    private String name;
    private int rollNumber;
    private char grade;

    
    public Student(String name, int rollNumber, char grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    
    public int getRollNumber() { return rollNumber; }
    public String getName() { return name; }
    public char getGrade() { return grade; }

    // Student details-ai azhaga print panna
    public void displayStudent() {
        System.out.println("Roll No: " + rollNumber + " | Name: " + name + " | Grade: " + grade);
    }
}


public class StudentManagementSystem {
    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<>(); // Ella student-aiyum store panna list
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("=========================================");
        System.out.println("    WELCOME TO STUDENT MANAGEMENT SYSTEM  ");
        System.out.println("=========================================");

        // Infinite Loop - User exit panra varai run aagum
        do {
            System.out.println("\n1. Add New Student 📥");
            System.out.println("2. Display All Students 📋");
            System.out.println("3. Search Student by Roll No 🔍");
            System.out.println("4. Exit Application ❌");
            System.out.print("Enter your choice (1-4): ");
            choice = scanner.nextInt();
            scanner.nextLine(); // 

            switch (choice) {
                case 1:
                    
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    
                    System.out.print("Enter Roll Number: ");
                    int roll = scanner.nextInt();
                    
                    System.out.print("Enter Grade (O/A/B/C/F): ");
                    char grade = scanner.next().charAt(0);

                    
                    if(name.isEmpty()) {
                        System.out.println("❌ Error: Name cannot be empty!");
                    } else {
                        Student newStudent = new Student(name, roll, grade);
                        studentList.add(newStudent);
                        System.out.println("🎉 Student Added Successfully!");
                    }
                    break;

                case 2:
            
                    System.out.println("\n--- STUDENT LIST ---");
                    if (studentList.isEmpty()) {
                        System.out.println("No students registered yet.");
                    } else {
                        for (Student s : studentList) {
                            s.displayStudent();
                        }
                    }
                    break;

                case 3:
                    
                    System.out.print("Enter Roll Number to Search: ");
                    int searchRoll = scanner.nextInt();
                    boolean found = false;

                    for (Student s : studentList) {
                        if (s.getRollNumber() == searchRoll) {
                            System.out.println("\n✨ Student Found:");
                            s.displayStudent();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("❌ Student with Roll No " + searchRoll + " not found.");
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using Student Management System! Tata, Bye-Bye! 👋");
                    break;

                default:
                    System.out.println("❌ Invalid Choice! Please choose between 1 to 4.");
            }
        } while (choice != 4);

        scanner.close();
    }
}