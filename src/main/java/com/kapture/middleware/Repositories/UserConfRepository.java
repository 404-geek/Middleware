package com.kapture.middleware.Repositories;



import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.kapture.middleware.DataModel.UserConf;


@Repository
public interface UserConfRepository extends MongoRepository<UserConf, String>{
	
	UserConf findByApiname(String apiname); 
	void deleteByApiname(String apiname);

}
