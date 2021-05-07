package com.dopang.machine.equitytrading.mapper;

import org.apache.tomcat.util.json.ParseException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.dopang.machine.equitytrading.domain.User;
import com.dopang.machine.equitytrading.dto.UserDTO;

public class UserMapper {

	@Autowired
    private ModelMapper modelMapper;
	
	public UserDTO convertToUserDTO(User user) {
		
		UserDTO postDto = modelMapper.map(user, UserDTO.class);
	    return postDto;
	}
	
	public User convertToUser(UserDTO userDTO) throws ParseException {
		User user = modelMapper.map(userDTO, User.class);
	    return user;
	}
}
