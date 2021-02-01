package org.sample;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.NoArgsConstructor;
import lombok.Setter;
import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;

@SuppressWarnings("serial")
@Setter @NoArgsConstructor
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

	@Override
	public String toString() {
		return "Customer{" + "id='" + id + '\'' + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\''
				+ ", email='" + email + '\'' + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Customer customer = (Customer) o;
		return Objects.equals(id, customer.id) && Objects.equals(firstName, customer.firstName) && Objects
				.equals(lastName, customer.lastName) && Objects.equals(email, customer.email);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, firstName, lastName, email);
	}
}