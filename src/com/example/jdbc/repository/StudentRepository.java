package com.example.jdbc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.jdbc.config.PostgresConnect;
import com.example.jdbc.model.Student;

public class StudentRepository {
	
	//Inserting a student record
	public void insert(Student student) {
		String sql_insert ="INSERT INTO student (student_name,email,phone_number) VALUES (?,?,?)";
		//try with resources
		try(Connection connect= PostgresConnect.getConnection();
				PreparedStatement preparedStatement = connect.prepareStatement(sql_insert)){
				preparedStatement.setString(1, student.getName());
				preparedStatement.setString(2, student.getEmail());
				preparedStatement.setString(3, student.getPhone_number());
				int rowsAffected = preparedStatement.executeUpdate();
				if(rowsAffected > 0) {
					System.out.println("✅ Row inserted successfully");
				}
				
		} catch (SQLException e) {
			System.out.println("❌ Insertion failed!");
			e.printStackTrace();
		}
	}
	// Updating a student record
	public void update(Student student) {
		String sql_update = "UPDATE student SET student_name=?,email=?,phone_number=? WHERE id=?";
		try(Connection connect = PostgresConnect.getConnection();
				PreparedStatement preparedStatement = connect.prepareStatement(sql_update)){
			preparedStatement.setString(1, student.getName());
			preparedStatement.setString(2, student.getEmail());
			preparedStatement.setString(3, student.getPhone_number());
			preparedStatement.setLong(4, student.getId());
			int rowsAffected = preparedStatement.executeUpdate();
			if(rowsAffected > 0)
				System.out.println("✅ Row updated successfully");
		}
		catch(SQLException e) {
			System.out.println("❌ Updation failed");
			e.printStackTrace();
		}
	}
	
	// deleting a student record
	public void delete(Long id) {
		String sql_delete ="DELETE FROM student WHERE id=?";
		try(Connection connection =PostgresConnect.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql_delete)){
				preparedStatement.setLong(1, id);
				int rowsAffected = preparedStatement.executeUpdate();
				if(rowsAffected > 0)
					System.out.println("✅ Row deleted successfully");
		} 
		catch (SQLException e) {
			System.out.println("❌ Deletion failed");
					e.printStackTrace();
				}
	}
	
	// fetch all records
	public List<Student> getAllStudent(){
		List<Student> students = new ArrayList<Student>();
		String sql_fetch_all = "SELECT * FROM student";
		try(Connection connection = PostgresConnect.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(sql_fetch_all)){
			while(resultSet.next()) {
				Student student = new Student(resultSet.getString("student_name"), resultSet.getString("email"), resultSet.getString("phone_number")
						);
				student.setId(resultSet.getLong("id"));
				students.add(student);
			}
		}
		catch (SQLException e) {
					System.out.println("❌ Unable to fetch all records");
					e.printStackTrace();
				}
		return students;
	}
	
	// fetch a student by id
	public Student getStudentById(Long id) {
		Student student = null;
		String sql_fetch_by_id = "SELECT * FROM student where id=?";
		try(Connection connection =PostgresConnect.getConnection();
				PreparedStatement preparedStatement=connection.prepareStatement(sql_fetch_by_id)){
				preparedStatement.setLong(1, id);
				ResultSet resultSet = preparedStatement.executeQuery();
				if(resultSet.next()) {
					student= new Student(resultSet.getString("student_name"), resultSet.getString("email"), resultSet.getString("phone_number"));
					student.setId(resultSet.getLong("id"));}
		} catch (SQLException e) {
			System.out.println("❌  Unable to fetch record");
			e.printStackTrace();
		}
		return student;
	}
}
