package com.challenges.c1903;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @JsonInclude(Include.NON_NULL)
class Location{
	@JsonProperty("lat")
	String lattitude;
	@JsonProperty("long")
	String longitude;
}

@Getter @Setter @NoArgsConstructor @JsonInclude(Include.NON_NULL)
class AddressDetail{
	String address;
	Location location;
}

@Getter @Setter @NoArgsConstructor @JsonInclude(Include.NON_NULL)
class Address{
	private AddressDetail billing;
	private AddressDetail shipping;
}

@Document("customers") @Getter @Setter @NoArgsConstructor @JsonInclude(Include.NON_NULL)
public class C1903Customer {
	@Id
    public String id;
	private String firstName;
	private String lastName;
	private String mobile;
	private Address address;
}
