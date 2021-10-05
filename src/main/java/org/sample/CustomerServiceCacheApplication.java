package org.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

@SpringBootApplication
//@EnableJpaRepositories
@EnableCouchbaseRepositories
@EnableCaching
public class CustomerServiceCacheApplication {
	
	static Logger logger = LoggerFactory.getLogger(CustomerServiceCacheApplication.class);
	
	public static void main(String[] args) {
        try {
		SpringApplication.run(CustomerServiceCacheApplication.class, args);
        } catch (Exception e){
        	logger.error("Exception in main: ", e);
        }
	}
	
}
