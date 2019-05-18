package com.kapture.middleware.Repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kapture.middleware.DataModel.Model;

@Component
@Repository
public interface ModelRepository extends MongoRepository<Model, String>{

	List<Model> findByType(String apiname);
	

	@Query("{'type' : ?0, 'time' : {$gte : ?1} }")
	List<Model> findByTypeAndTimeLessThan(String type, LocalDateTime time);
	
	
	//@Query("{'type' : ?0, 'time' : {$lt : ?1} }")
	//List<Model> deleteByTypeAndTimeLessThan(String type, LocalDateTime time);
	
	//@Query(value = "{type : ?0, 'time' : {$lt : ?1} }", delete = true)
	//List<Model> deleteByTypeAndTimeLessThan(String type, LocalDateTime time);
	
	@DeleteQuery("{type : ?0, time : {$lt : ?1} }")
	List<Model> deleteByTypeAndTimeLessThan(String type, LocalDateTime time);
	
	
	void deleteByType(String type);
}
