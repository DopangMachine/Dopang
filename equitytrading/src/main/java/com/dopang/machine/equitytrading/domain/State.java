package com.dopang.machine.equitytrading.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "STATE", uniqueConstraints = {
		@UniqueConstraint(columnNames = "STATE_ID")})
public class State {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "STATE_ID", nullable = false, unique = true)
	private int stateId;

	@Column(name = "STATE_NAME", nullable = true, unique = false)
	private String stateName;

	@OneToMany(mappedBy="state", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<City> city;

	@ManyToOne
	@JoinColumn(name="COUNTRY_ID")
	private Country country;


	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public List<City> getCity() {
		return city;
	}

	public void setCity(List<City> city) {
		this.city = city;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}	
}
