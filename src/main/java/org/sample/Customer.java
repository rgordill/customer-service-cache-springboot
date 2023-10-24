package org.sample;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
// import javax.persistence.Entity;
// import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;

//import org.springframework.data.annotation.Id;
//import org.springframework.data.annotation.Transient;
//import org.springframework.data.couchbase.core.mapping.Document;
//import org.springframework.data.couchbase.core.mapping.Field;

@Data 
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Schema(title = "Customer")
@JsonPropertyOrder({"id","first-name","last-name","email"})
@Entity
//@Document
public class Customer implements Serializable {

	@Schema(title="UUID of a customer", readOnly=true )
	@JsonProperty("id")
	@Id
	private String id;
	
	@Schema(title="First Name" )
	@JsonProperty("first-name")
//	@Field
	private String firstName;
	
	@Schema(title="Last Name" )
	@JsonProperty("last-name")
//	@Field
	private String lastName;
	
	@Schema(title="Email" )
	@JsonProperty("email")
//	@Field
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