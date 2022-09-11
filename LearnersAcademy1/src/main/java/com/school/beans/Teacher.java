package com.school.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Teacher")
public class Teacher {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	int t_id;
	
	@Column
	String t_name;
	
	public Teacher() {
		super();
	}
	public Teacher(int t_id, String t_name) {
		super();
		this.t_id = t_id;
		this.t_name = t_name;
	}

	public Teacher(String t_name) {
		super();
		this.t_name = t_name;
	}

	public int getT_id() {
		return t_id;
	}

	public void setT_id(int t_id) {
		this.t_id = t_id;
	}

	public String getT_name() {
		return t_name;
	}

	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	

	
}