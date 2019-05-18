package com.kapture.middleware.DTOModels;

import java.util.List;

import org.springframework.stereotype.Component;

import com.kapture.middleware.DTOModels.RequestBuilderDTO.RequestBuilderDTOBuilder;
import com.kapture.middleware.DataModel.Credential;
import com.kapture.middleware.DataModel.SourceConf;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class KeyValue {
	
	String key;
	String value;
	String type;

}
