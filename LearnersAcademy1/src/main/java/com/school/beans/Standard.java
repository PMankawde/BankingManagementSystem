package com.school.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Class")
public class Standard {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	int cl_id;
	
	@Column
	int classes;
	
	@Column
	String sub_name;
	
	@Column
	String t_name;
	
	public Standard() {
		super();
	}
	
	public Standard(int cl_id, int classes, String sub_name, String t_name) {
		super();
		this.cl_id = cl_id;
		this.classes = classes;
		this.sub_name = sub_name;
		this.t_name = t_name;
	}

	public Standard(int classes, String sub_name, String t_name) {
		super();
		this.classes = classes;
		this.sub_name = sub_name;
		this.t_name = t_name;
	}

	public int getCl_id() {
		return cl_id;
	}

	public void setCl_id(int cl_id) {
		this.cl_id = cl_id;
	}

	public int getClasses() {
		return classes;
	}

	public void setClasses(int classes) {
		this.classes = classes;
	}

	public String getSub_name() {
		return sub_name;
	}

	public void setSub_name(String sub_name) {
		this.sub_name = sub_name;
	}

	public String getT_name() {
		return t_name;
	}

	public void setT_name(String t_name) {
		this.t_name = t_name;
	}

}