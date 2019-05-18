package com.kapture.middleware.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kapture.middleware.DataModel.ProcessedModel;

public interface ProcessedModelRepository extends MongoRepository<ProcessedModel, String>{

}
