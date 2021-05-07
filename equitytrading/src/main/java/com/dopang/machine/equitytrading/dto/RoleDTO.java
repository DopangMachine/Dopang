package com.dopang.machine.equitytrading.dto;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.dopang.machine.equitytrading.domain.User;

public class RoleDTO {

	private User user;
	private String role;
	private boolean roleEnabled;
}
