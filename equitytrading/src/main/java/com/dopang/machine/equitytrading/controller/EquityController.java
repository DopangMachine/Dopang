package com.dopang.machine.equitytrading.controller;

import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dopang.machine.equitytrading.domain.Address;
import com.dopang.machine.equitytrading.domain.City;
import com.dopang.machine.equitytrading.domain.Country;
import com.dopang.machine.equitytrading.domain.State;
import com.dopang.machine.equitytrading.domain.User;
import com.dopang.machine.equitytrading.dto.UserDTO;
import com.dopang.machine.equitytrading.mapper.UserMapper;
import com.dopang.machine.equitytrading.service.UserService;

@Controller
public class EquityController {
	
	@Autowired
    private UserMapper userMapper;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/index")
	public String viewHomePage() {
		
		
        return "login";
	}
	
	@RequestMapping("/login")
	public ModelAndView showNewProductPage(Model model) {
		UserDTO userDTO = new UserDTO();
		model.addAttribute("userDTO", userDTO);
		
		ModelAndView modelView = new ModelAndView("login");
        return modelView;
	}
	
	@PostMapping(value = "/createUser")
	public String saveProduct(@ModelAttribute("user") UserDTO userDTO) throws ParseException {
		User user = userMapper.convertToUser(userDTO);
		System.out.println(userDTO);
		return "redirect:/index";
	}
	
	private void createUser(UserDTO userDTO) {
		
		User user = new User();
		Address address = new Address();
		Country country = new Country();
		State state = new State();
		City city = new City();
		
	}
}
