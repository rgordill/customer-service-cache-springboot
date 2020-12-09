package com.redhat;

public interface CustomerRepositoryCache {

	    public Customer findById(String id);

	    public Customer insert(String id, Customer c);
	    
	    public void delete(String id);
}
