package com.example.jdbc.controller;

import java.util.List;
import java.util.Scanner;

import com.example.jdbc.model.Student;
import com.example.jdbc.repository.StudentRepository;
import com.example.jdbc.service.StudentService;

public class StudentController {
	private static final Scanner scanner = new Scanner(System.in);
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    public void start() {
        while(true) {
            System.out.println("\n=== Student Management ===");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Fetch Student by ID");
            System.out.println("5. Fetch All Students");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    updateStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    fetchStudentById();
                    break;
                case 5:
                    fetchAllStudents();
                    break;
                case 6:
                    System.out.println("Exiting the application.");
                    return;  // Exit the application
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
        
    }

    private void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student email: ");
        String email = scanner.nextLine();
        System.out.print("Enter student phone number: ");
        String phoneNumber = scanner.nextLine();

        Student student = new Student(name, email, phoneNumber);
        studentService.insert(student);
        System.out.println("Student added successfully!");
    }

    private void updateStudent() {
        System.out.print("Enter student ID to update: ");
        Long id = scanner.nextLong();
        scanner.nextLine();  // Consume newline left-over
        System.out.print("Enter new name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new email: ");
        String email = scanner.nextLine();
        System.out.print("Enter new phone number: ");
        String phoneNumber = scanner.nextLine();

        Student student = new Student(name, email, phoneNumber);
        student.setId(id);
        studentService.update(student);
        System.out.println("Student updated successfully!");
    }

    private void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        Long id = scanner.nextLong();
        studentService.delete(id);
        System.out.println("Student deleted successfully!");
    }

    private void fetchStudentById() {
        System.out.print("Enter student ID to fetch: ");
        Long id = scanner.nextLong();
        Student student = studentService.fetchStudentById(id);
        if (student != null) {
            System.out.println("Student Details: " + student);
        } else {
            System.out.println("No student found with ID: " + id);
        }
    }

    private void fetchAllStudents() {
        List<Student> students = studentService.fetchAllStudents();
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    public static void main(String[] args) {
        // Create instances of the repository, service, and controller classes
        StudentRepository studentRepository = new StudentRepository();
        StudentService studentService = new StudentService(studentRepository);
        StudentController studentController = new StudentController(studentService);

        // Start the application
        studentController.start();
    }
}
