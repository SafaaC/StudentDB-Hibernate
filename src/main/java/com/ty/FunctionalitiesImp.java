package com.ty;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import customException.InvalidChoiceException;
import customException.StudentNotFoundException;
import customSorting.SortStudentByName;
import customSorting.SortStudentByRegNo;

public class FunctionalitiesImp implements Functionalities {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("hi");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	Scanner s = new Scanner(System.in);

	public void addStudent() {
		System.out.println("enter name");
		String name = s.next();
		System.out.println("enter email");
		String email = s.next();
		System.out.println("enter age");
		int age = s.nextInt();

		Student std = new Student();
		std.setName(name);
		std.setEmail(email);
		std.setAge(age);

		et.begin();
		em.persist(std);
		et.commit();
	}
	
	public void displayStudents() {
		et.begin();
		javax.persistence.Query q=em.createQuery("select std from Student std");
		List<Student> stds=q.getResultList();
		for (Student std : stds) {
			System.out.println(std);
		}
		et.commit();
	}

	
	public void getByName() {
		et.begin();
		System.out.println("enter name");
		String name=s.next();
		javax.persistence.Query q = em.createQuery("select std from Student std where std.name=?1");
		q.setParameter(1, name);
		List<Student> stds = q.getResultList();
		for (Student std : stds) {
			System.out.println(std);
		}
		et.commit();
	}
	
	public void getByEmail() {
		et.begin();
		System.out.println("enter email");
		String email=s.next();
		javax.persistence.Query q = em.createQuery("select std from Student std where std.email=?1");
		q.setParameter(1, email);
		List<Student> stds = q.getResultList();
		for (Student std : stds) {
			System.out.println(std);
		}
		et.commit();
	}
	public void getByRegNo() {
		et.begin();
		System.out.println("enter reg no");
		int regNo=s.nextInt();
		javax.persistence.Query q = em.createQuery("select std from Student std where std.regNo=?1");
		q.setParameter(1, regNo);
		List<Student> stds = q.getResultList();
		for (Student std : stds) {
			System.out.println(std);
		}
		et.commit();
	}
	public void sortStudents() {
		
		et.begin();
		javax.persistence.Query q=em.createQuery("select std from Student std");
		List<Student> stds=q.getResultList();
		if (stds.size()>=2){
			System.out.println(
					"1:Sort Student By RegNo\n2:Sort Student By Name\n");
			System.out.println("enter your choice");
			int ch = s.nextInt();
			switch (ch) {
			case 1:
				Collections.sort(stds, new SortStudentByRegNo());
				display(stds);
				break;
			case 2:
				Collections.sort(stds, new SortStudentByName());
				display(stds);
				break;
			default:
				try {
					String message = "Invalid Choice ,Enter Valid Choice!";
					throw new InvalidChoiceException(message);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		} else {
			try {
				String message = "No sufficient student record to sort";
				throw new StudentNotFoundException(message);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		}
		
		private void display(List<Student> stds) {
			for (Student s : stds) {
				System.out.println(s);
			}

	}
		
}
