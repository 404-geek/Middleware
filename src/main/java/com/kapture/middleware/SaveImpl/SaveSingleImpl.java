package com.kapture.middleware.SaveImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.kapture.middleware.DataInterfaces.Save;
import com.kapture.middleware.DataModel.Model;
import com.kapture.middleware.Repositories.ModelRepository;

@Component("push")
@Service
public class SaveSingleImpl implements Save{

	@Autowired
	ModelRepository repo;
	@Override
	public String save(List<Model> modelList) {
		
		repo.save(modelList.get(0));
		return "successfull";
	}
	

}
