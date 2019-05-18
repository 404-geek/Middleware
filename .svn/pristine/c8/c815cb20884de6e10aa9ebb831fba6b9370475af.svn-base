package com.kapture.middleware.services;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.kapture.middleware.DataModel.Credential;
import com.kapture.middleware.DataModel.SourceConf;
import com.kapture.middleware.DataModel.UserConf;
import com.kapture.middleware.Repositories.UserConfRepository;
import com.mongodb.WriteResult;

@Component
public class UserConfService {

	@Autowired
	MongoTemplate mongoTemplate;

	@Autowired
	UserConfRepository user;

	public List<Credential> getCredentials(String apiname) {

		UserConf userConf = user.findByApiname(apiname);
		if (userConf == null) {
			return new ArrayList<Credential>();
		}
		List<Credential> credential = userConf.getKeycreds();
		return credential;
	}

	public UserConf getUserConf(String apiname) {

		UserConf userConf = user.findByApiname(apiname);
		if (userConf == null) {
			return null;
		}
		return userConf;
	}

	public void updatePullLastDateTime(int index,String name, String apikey, LocalDateTime timeStamp) {
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("apiname").is(name).and("keycreds.apikey").is(apikey));
			Update update = new Update();
			update.set("keycreds.$.pullastdatetime."+index+".time", timeStamp);
			mongoTemplate.updateMulti(query, update, UserConf.class);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
