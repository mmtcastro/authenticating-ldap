package com.example.authenticatingldap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("")
	public String index() {
		return "<H2>LDAP Lab - Welcome to the home page!</H2>";
	}
}
