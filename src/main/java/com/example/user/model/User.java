package com.example.user.model;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USERSERVICE")
public class User  {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String age;
	private String sex;
	//private String[] hobie;
	private String address;
	
	
	
	public User() {
		super();
	}
	public User(int id, String name, String age, String sex, String[] hobie, String address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
	//	this.hobie = hobie;
		this.address = address;
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
	/*public String[] getHobie() {
		return hobie;
	}
	public void setHobie(String[] hobie) {
		this.hobie = hobie;
	}*/
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	

}
