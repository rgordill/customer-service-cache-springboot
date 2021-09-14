package org.sample;

import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Optional;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("SpringCache") 
@CacheConfig(cacheNames="customers")
public interface CustomerRepositorySpringCache extends CrudRepository<Customer,String>{

    @Cacheable(unless="#result == null")
    public Optional<Customer> findById(String id);

    @Cacheable
    public <S extends Customer> S save(S customer);

    @CacheEvict
    public void deleteById(String id);
}