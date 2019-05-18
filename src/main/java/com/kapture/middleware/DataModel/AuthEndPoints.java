package com.kapture.middleware.DataModel;

import java.util.List;

import com.kapture.middleware.DTOModels.KeyValue;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AuthEndPoints {
	
	String label;
	String url;
	String method;
	List<KeyValue> params;
	List<KeyValue> header;
	List<KeyValue> requestbody;

	
}
