package com.communitycenterproject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblprogramcsr")
public class Program {
	private Long id;
	private String name;
	private String category;
	private String location;
	private String plandate;
	
    
	protected Program() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPlandate() {
		return plandate;
	}
	public void setPlandate(String plandate) {
		this.plandate = plandate;
	}
}
