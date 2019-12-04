package com.cognizant.mfrp.agile.api.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="hospital_feedback")
public class Feedback {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="hf_id")
	private long id;
	@NotNull
	@Column(name="hf_name")
	private String Hospitalname;
	@NotNull
	@Column(name="hf_city")
	private String city;
	@NotNull
	@Column(name="hf_feedback")
	private String feedback;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getHospitalname() {
		return Hospitalname;
	}
	public void setHospitalname(String hospitalname) {
		Hospitalname = hospitalname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
}
