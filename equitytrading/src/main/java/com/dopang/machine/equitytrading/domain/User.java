package com.dopang.machine.equitytrading.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Proxy;

@Entity
@Proxy(proxyClass=User.class,lazy=false)
@Table(name = "USER", uniqueConstraints = {@UniqueConstraint(columnNames = "USER_ID")})
public class User implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID", nullable = false, unique = true)
	private Long userId;

	@Column(name = "USER_NAME", nullable = false, unique = false)
	private String userName;

	@Column(name = "PASSWORD", nullable = false, unique = false)
	private String password;

	@Column(name = "FIRST_NAME", nullable = false, unique = false)
	private String firstName;

	@Column(name = "LAST_NAME", nullable = false, unique = false)
	private String lastName;

	@Column(name = "EMAIL", nullable = false, unique = false)
	private String email;

	@Column(name = "GENDER", nullable = false, unique = false)
	private String gender;

	@Column(name = "USER_ENABLED", nullable = false, unique = false)
	private boolean userEnabled;

	@Column(name = "CREATED_BY", nullable = false, unique = false)
	private String createdBy;

	@Column(name = "CREATED_DATE", nullable = false, unique = false)
	private Timestamp createdDate;

	@Column(name = "UPDATED_DATE", nullable = false, unique = false)
	private Timestamp updatedDate;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="USER_ID")
	private List<Address> addressList;

	@OneToOne(fetch = FetchType.LAZY, cascade= CascadeType.ALL)
	@JoinColumn(name = "ROLE_ID")
	private Role role;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public boolean isUserEnabled() {
		return userEnabled;
	}

	public void setUserEnabled(boolean userEnabled) {
		this.userEnabled = userEnabled;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
