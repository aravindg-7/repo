package com.cognizant.mfrp.agile.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
@Entity
@Table(name="blood_request")
public class BloodRequest {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="req_us_id")
	private long id;
	@NotNull
	@Column(name="req_us_blood_group")
	private String bloodGroup;
	@NotNull
	@Column(name="req_us_state")
	private String state;
	@NotNull
	@Column(name="req_us_area")
	private String area;
	@NotNull
	@Column(name="req_us_pin_code")
	private int pincode;
	@NotNull
	@Column(name="req_us_contact_number")
	private String contactNumber;
	
	@ManyToOne
	@JoinColumn(name = "req_us_id_fk")
	private User userId;

	public BloodRequest() {

	}

//	public User getUserId() {
//		return userId;
//	}

	public void setUserId(User userId) {
		this.userId = userId;
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

	@Override
	public String toString() {
		return "BloodRequest [userId=" + userId + ", id=" + id + ", bloodGroup=" + bloodGroup + ", state=" + state
				+ ", area=" + area + ", pincode=" + pincode + ", contactNumber=" + contactNumber + "]";
	}

}
