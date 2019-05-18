package com.kapture.middleware.Scheduler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.kapture.middleware.DataInterfaces.Authentication;
import com.kapture.middleware.DataModel.Model;
import com.kapture.middleware.DataModel.SourceConf;
import com.kapture.middleware.Repositories.SourceConfRepository;
import com.kapture.middleware.services.Processor;
import com.kapture.middleware.services.RestConsumeService;


@Component
public class PullScheduler {

	//private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	Authentication auth;

	@Autowired
	RestConsumeService serv;

	@Autowired
	Processor processor;
	
	@Autowired
	SourceConfRepository sourceConfRepository;

	@Scheduled(fixedRate = 10000)
	public void pullData() {

		List<SourceConf> sourceConfList = sourceConfRepository.findByType("pull");
		//System.out.println(sourceConfList.get(0).toString());
		for (int i = 0; i < sourceConfList.size(); i++) {
			Model model = Model.builder().type(sourceConfList.get(i).getName()).build();
			if(sourceConfList != null)
			processor.process(model, sourceConfList.get(i));

		}

	}
}