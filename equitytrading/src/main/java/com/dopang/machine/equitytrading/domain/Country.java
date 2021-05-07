package com.dopang.machine.equitytrading.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "COUNTRY", uniqueConstraints = {
@UniqueConstraint(columnNames = "DM_COUNTRY_ID")})
public class Country {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DM_COUNTRY_ID", nullable = false, unique = true)
	private int countryId;
	
	@Column(name = "DM_COUNTRY_NAME", nullable = false, unique = true)
	private String countryName;
	
	@Column(name = "DM_COUNTRY_CODE", nullable = true, unique = true)
	private String countryCode;
	
	@Column(name = "DM_COUNTRY_CURRENCY", nullable = true, unique = false)
	private String countryCurrency;
	
	@OneToMany(mappedBy="country", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<State> state;

	
	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryCurrency() {
		return countryCurrency;
	}

	public void setCountryCurrency(String countryCurrency) {
		this.countryCurrency = countryCurrency;
	}

	public List<State> getState() {
		return state;
	}

	public void setState(List<State> state) {
		this.state = state;
	}

}
