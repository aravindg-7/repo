package com.cognizant.mfrp.agile.api.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="hospital_booking")
public class HospitalSlot {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="hb_id")
	private long id;
	@NotNull
	@Column(name="hb_name")
	private String Hospitalname;
	@NotNull
	@Column(name="hb_city")
	private String City;
	@NotNull
	@Column(name="hb_date")
	private Date slotdate;
	@NotNull
	@Column(name="hb_time")
	private String timeslot;

	@OneToOne
	@JoinColumn(name="hb_do_id")
	private Donor donor;
	
//	public Donor getDonor() {
//		return donor;
//	}
	public void setDonor(Donor donor) {
		this.donor = donor;
	}
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
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public Date getSlotdate() {
		return slotdate;
	}
	public void setSlotdate(Date slotdate) {
		this.slotdate = slotdate;
	}
	public String getTimeslot() {
		return timeslot;
	}
	public void setTimeslot(String timeslot) {
		this.timeslot = timeslot;
	}

	
	@Override
	public String toString() {
		return "HospitalSlot [id=" + id + ", Hospitalname=" + Hospitalname + ", City=" + City + ", slotdate=" + slotdate
				+ ", timeslot=" + timeslot + "]";
	}
}
