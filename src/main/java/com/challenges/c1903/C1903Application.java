package com.challenges.c1903;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class C1903Application {

	public static void main(String[] args) {
		SpringApplication.run(C1903Application.class, args);
	}

	@Bean
	public CommandLineRunner loadData(MongoTemplate mongoTemplate) {
	    return (args) -> {
	    	mongoTemplate.dropCollection("customers");
	    	C1903Customer c = new C1903Customer();
	    	c.setFirstName("John");
	    	c.setLastName("Doe");
	    	Address address = new Address();
	    	Location location = new Location();
	    	location.setLattitude("100");
	    	location.setLongitude("200");
	    	AddressDetail billing = new AddressDetail();
	    	billing.setAddress("Billing Address");
	    	billing.setLocation(location);
	    	AddressDetail shipping = new AddressDetail();
	    	shipping.setAddress("Shipping Address");
	    	shipping.setLocation(location);
	    	address.setBilling(billing);
	    	address.setShipping(shipping);
	    	c.setAddress(address);
	    	
	    	mongoTemplate.insert(c);
	    };
	}

}
