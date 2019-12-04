package com.cognizant.mfrp.agile.api.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="donor")
public class Donor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="do_id")
	private long id;
	@NotNull
	@Column(name="do_blood_group")
	private String bloodGroup;
	@NotNull
	@Column(name="do_state")
	private String state;
	@NotNull
	@Column(name="do_area")
	private String area;
	@NotNull
	@Column(name="do_pin_code")
	private int pincode;
	@NotNull
	@Column(name="do_contact_number")
	private String contactNumber;
	
	@OneToOne(mappedBy="donor",cascade=CascadeType.ALL,orphanRemoval = true)
	private HospitalSlot slot;
	@OneToOne
	@JoinColumn(name="do_us_id")
	private User user;
	
//	public User getUser() {
//		return user;
//	}
	public void setUser(User user) {
		this.user = user;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
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
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public HospitalSlot getSlot() {
		return slot;
	}
	public void setSlot(HospitalSlot slot) {
		this.slot = slot;
	}
	
}
