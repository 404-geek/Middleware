package com.kapture.middleware.FormatterImpl;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.stereotype.Component;

import com.kapture.middleware.DataInterfaces.Formatter;

import lombok.extern.slf4j.Slf4j;

@Component("xmltojson")
@Slf4j
public class XmlToJSON99AcresFormatterImpl implements Formatter{

	@Override
	public String formatter(String data, String label, String type) {

		String jsonPrettyPrintString = null;
		try {
            JSONObject xmlJSONObj = XML.toJSONObject(data);
            jsonPrettyPrintString = xmlJSONObj.toString(4);
        } catch (JSONException je) {
        	
        }
		log.info(jsonPrettyPrintString);
		return jsonPrettyPrintString;
	}

	
}
