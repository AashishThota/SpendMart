package com.info.ecommerce.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.info.ecommerce.entity.Country;
import com.info.ecommerce.entity.Product;
import com.info.ecommerce.entity.ProductCategory;
import com.info.ecommerce.entity.State;


@Configuration
@CrossOrigin
public class MyDataRestConfig  implements RepositoryRestConfigurer{
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		
		HttpMethod[] theUnsupportedActions= {HttpMethod.PUT,HttpMethod.POST,HttpMethod.DELETE};
		config.getExposureConfiguration().forDomainType(Product.class)
		.withItemExposure((metdata,httpMethods)->httpMethods.disable(theUnsupportedActions))
		.withCollectionExposure((metdata,httpMethods)->httpMethods.disable(theUnsupportedActions));
		
		config.getExposureConfiguration().forDomainType(ProductCategory.class)
		.withItemExposure((metdata,httpMethods)->httpMethods.disable(theUnsupportedActions))
		.withCollectionExposure((metdata,httpMethods)->httpMethods.disable(theUnsupportedActions));
		
		config.getExposureConfiguration().forDomainType(Country.class)
		.withItemExposure((metdata,httpMethods)->httpMethods.disable(theUnsupportedActions))
		.withCollectionExposure((metdata,httpMethods)->httpMethods.disable(theUnsupportedActions));
		
		config.getExposureConfiguration().forDomainType(State.class)
		.withItemExposure((metdata,httpMethods)->httpMethods.disable(theUnsupportedActions))
		.withCollectionExposure((metdata,httpMethods)->httpMethods.disable(theUnsupportedActions));
		
		exposeIds(config);
	}
 
	private void exposeIds(RepositoryRestConfiguration config) {
		Set<EntityType<?>> entities=entityManager.getMetamodel().getEntities();
		List<Class> entityClasses=new ArrayList();
		for(EntityType<?> tempentity:entities) {
			entityClasses.add(tempentity.getJavaType());
		}
		
		Class[] domainTypes=entityClasses.toArray(new Class[0]);
		config.exposeIdsFor(domainTypes);
	}
}
