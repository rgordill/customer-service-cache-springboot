package org.sample;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;

@Setter @NoArgsConstructor
@EqualsAndHashCode
@ToString
@Schema(title = "Customer")
@JsonPropertyOrder({"id","first-name","last-name","email"})
public class Customer {

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

	@ProtoFactory
	public Customer(String id, String firstName, String lastName, String email) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	@ProtoField(number = 1)
	public String getId() {
		return id;
	}

	@ProtoField(number = 2)
	public String getLastName() {
		return lastName;
	}

	@ProtoField(number = 3)
	public String getFirstName() {
		return firstName;
	}

	@ProtoField(number = 4)
	public String getEmail() {
		return email;
	}

}