package com.lwl;

public class UserInfo {
	
	private int age;
	private String sex;
	private String name;
	
	
	
	
	
	public UserInfo() {
	}
	
	
	public UserInfo(int age, String name, String sex) {
		super();
		this.age = age;
		this.name = name;
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	
}
