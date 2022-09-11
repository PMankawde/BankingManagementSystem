package com.school.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Student")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	int st_id;
	
	@Column
	String st_name;
	
	@Column
	int classes;
	
	public Student() {
		super();
	}

	public Student(int st_id, String st_name, int classes) {
		super();
		this.st_id = st_id;
		this.st_name = st_name;
		this.classes = classes;
	}

	public Student(String st_name, int classes) {
		super();
		this.st_name = st_name;
		this.classes = classes;
	}

	public int getSt_id() {
		return st_id;
	}

	public void setSt_id(int st_id) {
		this.st_id = st_id;
	}

	public String getSt_name() {
		return st_name;
	}

	public void setSt_name(String st_name) {
		this.st_name = st_name;
	}

	public int getClasses() {
		return classes;
	}

	public void setClasses(int classes) {
		this.classes = classes;
	}

	
}
