package com.lab.redis.repository;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.lab.redis.model.Student;

public class StudentRepositoryTest {

	@Autowired
	StudentRepository studentRepository;

	@Test
	public void onAddStudent() {
		Student student = new Student("Eng2015001", "John Doe", Student.Gender.MALE, 1);
		Student result = studentRepository.save(student);
		assertTrue(result != null);
	}

	@Test
	public void onGetStudent() {
		Student retrievedStudent = studentRepository.findById("Eng2015001").get();
		assertTrue(retrievedStudent != null);
	}

	@Test
	public void onUpdateStudent() {
		String name = "Wedson Silva";
		Student retrievedStudent = studentRepository.findById("Eng2015001").get();
		retrievedStudent.setName(name);
		studentRepository.save(retrievedStudent);
		Student result = studentRepository.findById("Eng2015001").get();
		assertTrue(result != null);
		assertTrue(name.equals(result.getName()));
	}

	@Test
	public void onRemoveStudent() {
		Student retrievedStudent = studentRepository.findById("Eng2015001").get();
		studentRepository.delete(retrievedStudent);
		Student result = studentRepository.findById("Eng2015001").get();
		assertTrue(result == null);
	}

	@Test
	public void onAddAlltudent() {
		Student engStudent = new Student("Eng2015001", "John Doe", Student.Gender.MALE, 1);
		Student medStudent = new Student("Med2015001", "Gareth Houston", Student.Gender.MALE, 2);
		List<Student> all = Arrays.asList(engStudent, medStudent);
		
		studentRepository.saveAll(all);
		
		Iterable<Student> students = studentRepository.findAll();
		
		List<Student> result = new ArrayList<>();
		
		students.forEach(result::add);
		
		assertTrue(result.size() == 2);
	}

}
