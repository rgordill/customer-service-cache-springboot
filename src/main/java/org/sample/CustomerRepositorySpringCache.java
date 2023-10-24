package org.sample;

import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Optional;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("SpringCache") 
@CacheConfig(cacheNames="customers")
public interface CustomerRepositorySpringCache extends CrudRepository<Customer,String>{

    @Cacheable
    public Optional<Customer> findById(String id);

    @CacheEvict(key="#p0.id")
    public <S extends Customer> S save(S customer);

    @CacheEvict
    public void deleteById(String id);
}