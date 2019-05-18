package com.kapture.middleware.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kapture.middleware.DTOModels.RequestBuilderDTO;
import com.kapture.middleware.DTOModels.ResponseBuilderDTO;
import com.kapture.middleware.DataInterfaces.Authentication;
import com.kapture.middleware.DataInterfaces.Formatter;
import com.kapture.middleware.DataInterfaces.Save;
import com.kapture.middleware.DataModel.Model;
import com.kapture.middleware.DataModel.SourceConf;
import com.kapture.middleware.Factory.BeanFactory;
import com.kapture.middleware.Repositories.SourceConfRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class Processor {

	@Autowired
	SourceConfRepository sourceConfRepository;

	@Autowired
	Authentication authentication;

	@Resource
	BeanFactory bean;

	@Autowired
	SourceConfRepository sourcerepo;

	@Autowired
	Authentication auth;

	@Autowired
	Formatter formatter;

	@Autowired
	Save save;

	@Autowired
	RestConsumeService cons;

	public void process(Model model, SourceConf sourceConf) {

		//log.info("Processing   "+sourceConf.getName());
		String msg;
		RequestBuilderDTO reqBuilderDTO = bean.chooseAuth(sourceConf.getAuthType()).authentication(sourceConf);
		if (reqBuilderDTO != null) {
			if (reqBuilderDTO.getMessage().equals("successfull")) {
				if (sourceConf.getType().equalsIgnoreCase("pull")) {
					ResponseBuilderDTO res = cons.Maker(reqBuilderDTO);

					
						if(res.getModelList()!=null) {
						msg = bean.chooseSave(sourceConf.getType()).save(res.getModelList());
						
						if (msg.equalsIgnoreCase("successfull"))
							log.info("Saved Entity " + model.getType());
						else
							log.error("Error in Saving " + model.getType());
						}
						else
						{
							log.error("ModelList is Empty");
						}
				}
				//model.setData(bean.chooseFormatting(sourceConf.getFormatterType()).formatter(model.getData()));
				else{
					model.setData(bean.chooseFormatting(sourceConf.getFormatterType()).formatter(model.getData(), null, null));
					List<Model> modelList = new ArrayList<Model>();
				
					modelList.add(model);
					msg = bean.chooseSave(sourceConf.getType()).save(modelList);

					if (msg.equalsIgnoreCase("successfull"))
						log.info("Saved Entity " + model.getType());
					else
						log.error("Error in Saving " + model.getType());
				} 
				
			} else
				log.info("Error in Authentication");
		} else
			log.error("Request Builder DTO is null");

	}

}
