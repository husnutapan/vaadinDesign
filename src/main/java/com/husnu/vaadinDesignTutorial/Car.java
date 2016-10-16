package com.husnu.vaadinDesignTutorial;

public class Car {
	
	private int id;
	private String name;
	private String company;
	private int cost;
	
	private CarTypes carTypes;
	
	public Car() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Car(int id, String name, String company, int cost, CarTypes carTypes) {
		super();
		this.id = id;
		this.name = name;
		this.company = company;
		this.cost = cost;
		this.carTypes = carTypes;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public CarTypes getCarTypes() {
		return carTypes;
	}
	public void setCarTypes(CarTypes carTypes) {
		this.carTypes = carTypes;
	}
	 
}
