package com.challenges.c1903;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class C1903Controller {
	
	@Autowired
	private C1903CustomerService service;
	
	@PostMapping
    public List<C1903Customer> getCustomers(@RequestBody C1903Customer customer) {
		return service.getCustomers(customer);
    }
}
