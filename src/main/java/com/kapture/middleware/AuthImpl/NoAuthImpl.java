package com.kapture.middleware.AuthImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.kapture.middleware.DTOModels.RequestBuilderDTO;
import com.kapture.middleware.DataInterfaces.Authentication;
import com.kapture.middleware.DataInterfaces.Formatter;
import com.kapture.middleware.DataModel.Credential;
import com.kapture.middleware.DataModel.SourceConf;
import com.kapture.middleware.services.SourceConfService;
import com.kapture.middleware.services.UserConfService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component("NoAuth")
@Primary
public class NoAuthImpl implements Authentication {
	
		@Autowired
		Formatter formatter;

		@Autowired
		UserConfService ucs;

		@Autowired
		SourceConfService scs;

		ResponseEntity<String> response = null;
		HttpHeaders headers = new HttpHeaders();
		List<Credential> cred;
		String type;
		String url;
		String method;
		RestTemplate rt = new RestTemplate();
		HttpEntity<Object> entity = new HttpEntity<Object>(headers);
		@Override
		public RequestBuilderDTO authentication(SourceConf source) {
			try {
				if(source != null) {
					RequestBuilderDTO requestBuilderDTO = RequestBuilderDTO.builder().Message("successfull").build();
					//log.info("NoAuth");
					return requestBuilderDTO;
				}
				else {
					log.error("SourceConf is Empty for NoAuth Implementation");
				}	
			} catch (Exception e) {
				log.error("NoAuth Implementation Error",e);
			}
			return null;
			
		}
}
