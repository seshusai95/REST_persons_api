package com.example.person.detailsAPI.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="person")
@NamedQuery(name="getallpersons", query="select p from Person p")
public class Person {
@Id
@GeneratedValue
private int id;
@Column(name="name")
private String name;
@Column(name="age")
private int age;
@Column(name="city")
private String city;
@Column(name="phone")
private long phone;

public Person() {
	super();
	// TODO Auto-generated constructor stub
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
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public long getPhone() {
	return phone;
}
public void setPhone(long phone) {
	this.phone = phone;
}
@Override
public String toString() {
	return "Person [id=" + id + ", name=" + name + ", age=" + age + ", city=" + city + ", phone=" + phone + "]";
}


}
