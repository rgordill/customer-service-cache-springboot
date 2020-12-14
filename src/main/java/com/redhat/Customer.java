package com.redhat;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor 
@SuppressWarnings("serial")
@Schema(title = "Customer")
@JsonPropertyOrder({"id","first-name","last-name","email"})
public class Customer implements Serializable {

	@Schema(title="UUID of a customer", readOnly=true )
	@JsonProperty("id")
	private String id;
	
	@Schema(title="First Name" )
	@JsonProperty("first-name")
	private String firstName;
	
	@Schema(title="Last Name" )
	@JsonProperty("last-name")
    private String lastName;
	
	@Schema(title="Email" )
	@JsonProperty("email")
    private String email;
    	
}