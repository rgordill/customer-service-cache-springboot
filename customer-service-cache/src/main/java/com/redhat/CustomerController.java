package com.redhat;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerRepositoryCache repository;
	
    @RequestMapping(method=RequestMethod.GET,value="/customer/{id}")
    @Operation(
            summary = "Get Customer",
	 		description = "Get a Customer by id")    
	public Customer getCustomer(
		@PathVariable(value="id") String id
    		) {
    	Customer c = repository.findById(id);
    	
    	if (c ==null){
    		throw new CustomerNotFoundException();
    	}
    	
        return c;
    }

    @RequestMapping(method=RequestMethod.PUT,value="/customer")
    @Operation(
            summary = "Create a Customer",
            description = "Create a Customer serialized in JSON")
    public Customer putCustomer(
            @Parameter(description = "Customer object", required = true, name = "Customer") 
            @RequestBody Customer c
    		) {
    	
    	c.setId(UUID.randomUUID().toString());
    	
        return repository.insert(c.getId(), c);
    }

    @RequestMapping(method=RequestMethod.DELETE,value="/customer/{id}")
    @Operation(
            summary = "Delete a Customer",
            description = "Delete a Customer by id")
     public void deleteCustomer(
            @PathVariable(value="id") String id
    		) {
    	repository.delete(id);
    }

    
    @RequestMapping(method=RequestMethod.POST,value="/customer/{id}")
    @Operation(
            summary = "Update a Customer",
            description = "Update a Customer by id")
    public Customer updateCustomer(
    		@PathVariable(value="id") String id,
            @Parameter(description = "Customer object", required = true, name = "Customer") 
            @RequestBody Customer c
    		) {
    	Customer c_cache = repository.findById(id);
    	
    	if (c_cache == null){
    		throw new CustomerNotFoundException();
       	}
    		
        Customer c_update = repository.insert(id, c);
        
    	return c_update;
    }    
    
    @ResponseStatus(value=HttpStatus.NOT_FOUND,reason="This customer is not found in the system")
    public class CustomerNotFoundException extends RuntimeException 
    {
    	private static final long serialVersionUID = 100L;
    }
    
}