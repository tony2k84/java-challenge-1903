package com.challenges.c1903;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class C1903CustomerService {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	public List<C1903Customer> getCustomers(C1903Customer customer) {
		Query query = new Query();
		// firstName
		if("true".equals(customer.getFirstName())) {
			query.fields().include("firstName");
		}
		// lastName
		if("true".equals(customer.getLastName())) {
			query.fields().include("lastName");
		}
		
		// mobile
		if("true".equals(customer.getMobile())) {
			query.fields().include("mobile");
		}
		
		// address
		if(customer.getAddress() != null) {
			// address.billing
			if(customer.getAddress().getBilling() != null) {
				// address.billing.address
				if("true".equals(customer.getAddress().getBilling().getAddress())) {
					query.fields().include("address.billing.address");
				}
				
				// address.billing.location
				if(customer.getAddress().getBilling().getLocation() != null) {
					// address.billing.location.lat 
					if("true".equals(customer.getAddress().getBilling().getLocation().getLattitude())) {
						query.fields().include("address.billing.location.lattitude");
					}
					// address.billing.location.long 
					if("true".equals(customer.getAddress().getBilling().getLocation().getLongitude())) {
						query.fields().include("address.billing.location.longitude");
					}
				}
				
			}
			// address.shipping
			if(customer.getAddress().getShipping() != null) {
				// address.shipping.address
				if("true".equals(customer.getAddress().getShipping().getAddress())) {
					query.fields().include("address.shipping.address");
				}
				
				// address.shipping.location
				if(customer.getAddress().getShipping().getLocation() != null) {
					// address.shipping.location.lat 
					if("true".equals(customer.getAddress().getShipping().getLocation().getLattitude())) {
						query.fields().include("address.shipping.location.lattitude");
					}
					// address.shipping.location.long 
					if("true".equals(customer.getAddress().getShipping().getLocation().getLongitude())) {
						query.fields().include("address.shipping.location.longitude");
					}
				}
			}
		}
		
		query.fields().exclude("id");
				
		List<C1903Customer> customers = mongoTemplate.find(query, C1903Customer.class);		
		return customers;
	}
}
