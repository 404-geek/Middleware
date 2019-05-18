package com.kapture.middleware.Repositories;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.kapture.middleware.DataModel.HashCode;

@Component
@Repository
public interface HashCodeRepository extends MongoRepository<HashCode, String>{
	
}
