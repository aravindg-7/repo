package com.cognizant.mfrp.agile.api.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="us_id")
	private int id;
	@NotNull
	@Size
	@Column(name="us_user_name")
	private String username;
	@NotNull
	@Column(name="us_first_name")
	private String firstName;
	@NotNull
	@Column(name="us_last_name")
	private String lastName;
	@NotNull
	@Size(min=8)
	@Column(name="us_password")
	private String password;
	@NotNull
	@Column(name="us_email")
	private String email;
	@NotNull
	@Column(name="us_gender")
	private String gender;
	@NotNull
	@Column(name="us_state")
	private String state;
	@NotNull
	@Column(name="us_area")
	private String area;
	@NotNull
	@Column(name="us_blood_group")
	private String bloodgroup;
	@NotNull
	@Column(name="us_age")
	private int age;
	@NotNull
	@Column(name="us_contact_number")
	private String contactno;
	@NotNull
	@Column(name="us_pincode")
	private int pincode;
	@NotNull
	@Column(name="us_weight")
	private int weight;
	@JsonIgnore
	@ManyToMany
    @JoinTable(name = "user_role",
        joinColumns = @JoinColumn(name = "ur_us_id"), 
        inverseJoinColumns = @JoinColumn(name = "ur_ro_id"))
 private List<Role> roles;
	
	@OneToMany(mappedBy = "userId",cascade=CascadeType.ALL)
    private List<BloodRequest> requests;	
	@OneToOne(mappedBy="user",cascade=CascadeType.ALL)
	private Donor donor;
	
	
		

	public Donor getDonor() {
		return donor;
	}


	public void setDonor(Donor donor) {
		this.donor = donor;
	}


	public List<BloodRequest> getRequests() {
		return requests;
	}


	public void setRequests(List<BloodRequest> requests) {
		this.requests = requests;
	}


	public List<Role> getRoles() {
		return roles;
	}


	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getArea() {
		return area;
	}


	public void setArea(String area) {
		this.area = area;
	}


	


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}



	public String getContactno() {
		return contactno;
	}


	public void setContactno(String contactno) {
		this.contactno = contactno;
	}


	public int getPincode() {
		return pincode;
	}


	public void setPincode(int pincode) {
		this.pincode = pincode;
	}


	public int getWeight() {
		return weight;
	}


	public void setWeight(int weight) {
		this.weight = weight;
	}


	public User() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getBloodgroup() {
		return bloodgroup;
	}


	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", password=" + password + ", email=" + email + ", gender=" + gender + ", state=" + state + ", area="
				+ area + ", bloodgroup=" + bloodgroup + ", age=" + age + ", contactno=" + contactno + ", pincode="
				+ pincode + ", weight=" + weight + ", roles=" + roles + ", requests=" + requests + ", donor=" + donor
				+ "]";
	}


	

}
