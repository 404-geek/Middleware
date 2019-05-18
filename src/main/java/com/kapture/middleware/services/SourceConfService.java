package com.kapture.middleware.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.kapture.middleware.DataModel.DataEndPoints;
import com.kapture.middleware.DataModel.SourceConf;
import com.kapture.middleware.Repositories.SourceConfRepository;

@Component
public class SourceConfService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	MongoTemplate mongoTemplate;

	@Autowired
	SourceConfRepository source;

//	public DataEndPoints getDataEndPoints(String apiname)
//	{
//		
//		Optional<SourceConf> s = source.findById(apiname);
//		DataEndPoints data = s.get().getDataEndPoints();
//		
//		return data;
//	}

	public String getType(String apiname) {

		Optional<SourceConf> s = source.findById(apiname);
		String data = s.get().getAuthType();

		return data;
	}


}
