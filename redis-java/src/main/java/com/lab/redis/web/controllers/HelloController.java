package com.lab.redis.web.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab.redis.model.Student;
import com.lab.redis.repository.StudentRepository;

@RestController
public class HelloController {
	
	StudentRepository studentRepository;
	
	public HelloController(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	@RequestMapping("/")
	public String index() {
		
		this.onAddAlltudent();
		this.onGetStudent();
		this.onUpdateStudent();
		this.onRemoveStudent();
		this.onAddAlltudent();
		
		return "Laboratório de REDIS no ar!\n!";
		
	}
	
	public void onAddStudent() {
		Student student = new Student("Eng2015001", "John Doe", Student.Gender.MALE, 1);
		Student result = studentRepository.save(student);
		System.out.println("Adicionando: " + result);
	}

	public void onGetStudent() {
		Student retrievedStudent = studentRepository.findById("Eng2015001").get();
		System.out.println("Lendo: " + retrievedStudent);
	}

	public void onUpdateStudent() {
		String name = "Wedson Silva";
		Student retrievedStudent = studentRepository.findById("Eng2015001").get();
		System.out.println("Alterando - ANTES: " + retrievedStudent);
		retrievedStudent.setName(name);
		studentRepository.save(retrievedStudent);
		Student result = studentRepository.findById("Eng2015001").get();
		System.out.println("Alterando - DEPOIS: " + result);
	}

	public void onRemoveStudent() {
		Student retrievedStudent = studentRepository.findById("Eng2015001").get();
		System.out.println("Excluindo: " + retrievedStudent);
		studentRepository.delete(retrievedStudent);
		System.out.println("===> Excluido!");
	}

	public void onAddAlltudent() {
		Student engStudent = new Student("Eng2015001", "John Doe", Student.Gender.MALE, 1);
		Student medStudent = new Student("Med2015001", "Gareth Houston", Student.Gender.MALE, 2);
		List<Student> all = Arrays.asList(engStudent, medStudent);
		studentRepository.saveAll(all);
		studentRepository.findAll().forEach(s -> System.out.println(s));
		
	}

}
