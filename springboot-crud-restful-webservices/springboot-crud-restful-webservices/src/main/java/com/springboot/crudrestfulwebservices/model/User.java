package com.springboot.crudrestfulwebservices.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
  @Column(name="id")
  private long id;
	
  @Column(name="name")
  private String name;
	
  @Column(name="age")
  private String age;
	
  @Column(name="sex")
  private String sex;
  
  @Column(name="address")
  private String address;
  
public User() {
	super();
	// TODO Auto-generated constructor stub
}
public User(long id, String name, String age, String sex, String address) {
	super();
	this.id = id;
	this.name = name;
	this.age = age;
	this.sex = sex;
	this.address = address;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAge() {
	return age;
}
public void setAge(String age) {
	this.age = age;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}

}
