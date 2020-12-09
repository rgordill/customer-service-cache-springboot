package com.redhat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;


@Repository
@Qualifier("SpringCache") 
@CacheConfig(cacheNames="default")
public class CustomerRepositorySpringCache implements CustomerRepositoryCache {
    Logger log = LoggerFactory.getLogger(this.getClass());

    @Cacheable(key="#id")
    public Customer findById(String id){
    	return null; 	
    }

    @CachePut(key="#id")
    public Customer insert(String id, Customer c){
        return c;
    }
    
    @CacheEvict(key="#id")
    public void delete(String id){
    }
    

}