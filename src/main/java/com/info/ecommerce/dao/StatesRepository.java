package com.info.ecommerce.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.info.ecommerce.entity.State;

@CrossOrigin
@RepositoryRestResource
public interface StatesRepository extends CrudRepository<State, Integer> {
	
	List<State> findByCountryCode(@Param("code") String code);

}
