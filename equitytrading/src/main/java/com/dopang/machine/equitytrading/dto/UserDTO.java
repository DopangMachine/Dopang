package com.dopang.machine.equitytrading.dto;

import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@ToString
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {

	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private String gender;
	private boolean userEnabled;
	private String createdBy;
	private Timestamp createdDate;
	private Timestamp updatedDate;
	private List<AddressDTO> addressList;
	private RoleDTO role;
}
