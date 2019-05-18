package com.kapture.middleware.Factory;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.kapture.middleware.DataInterfaces.Authentication;
import com.kapture.middleware.DataInterfaces.Formatter;
import com.kapture.middleware.DataInterfaces.Save;


@Component
@Service
public class BeanFactory {

	@Autowired 
	AutowireCapableBeanFactory beanFactory;
	
	@Autowired
	@Qualifier("NoAuth")
	private Authentication noauth;
	
	@Autowired
	@Qualifier("OAuth")
	private Authentication oauth;
	
	@Autowired
	@Qualifier("BasicAuth")
	private Authentication basic;
	
	@Autowired
	@Qualifier("ResponseBodyAuth")
	private Authentication body;
	
	@Autowired
	@Qualifier("NoFormatting")
	private Formatter noformat;
	
	@Autowired
	@Qualifier("duplicacycheck")
	private Formatter duplicate;
	
	@Autowired
	@Qualifier("xmltojson")
	private Formatter xml;
	
	@Autowired
	@Qualifier("pull")
	private Save saveMultiple;
	
	@Autowired
	@Qualifier("push")
	private Save saveSingle;
	
	
	public Authentication chooseAuth(String type)
	{
		switch(type) {
	      case "OAuth":
	        return oauth;
	      case "NoAuth":
	        return noauth;
	      case "BasicAuth":
	    	  return basic;
	      case "ResponseBodyAuth":
	    	  return body;
	    }
		return null;
	}
	public Formatter chooseFormatting(String type)
	{
		switch(type) {
	      case "NoFormatting":
	        return noformat;
	      case "duplicacycheck":
		        return duplicate;
	      case "xmltojson":
		        return xml;
	    }
		return null;
	}
	public Save chooseSave(String type){
		{
			switch(type) {
			case "pull" :
				return saveMultiple;
			case "push" :
				return saveSingle;
			}
		}
		return null;
	}
	
}
