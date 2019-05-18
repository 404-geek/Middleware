package com.kapture.middleware.Repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import com.kapture.middleware.DataModel.SourceConf;

public interface SourceConfRepository extends MongoRepository<SourceConf, String>{
	
	List<SourceConf> findByType(String type);
	
	SourceConf findByName(String name);
	
	void deleteByName(String name);
}
