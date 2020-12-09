package com.redhat;

import javax.cache.annotation.CacheDefaults;
import javax.cache.annotation.CacheKey;
import javax.cache.annotation.CachePut;
import javax.cache.annotation.CacheRemove;
import javax.cache.annotation.CacheResult;
import javax.cache.annotation.CacheValue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


@Repository
@Qualifier("JSR-107") 
@CacheDefaults(cacheName="default")
public class CustomerRepositoryJCache implements CustomerRepositoryCache{
    Logger log = LoggerFactory.getLogger(this.getClass());

    @CacheResult
    public Customer findById(@CacheKey String id){
    	return null; 	
    }

    @CachePut
    public Customer insert(@CacheKey String id, @CacheValue Customer c){
        return c;
    }
    
    @CacheRemove
    public void delete(@CacheKey String id){
    }
    

}