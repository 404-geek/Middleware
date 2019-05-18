package com.kapture.middleware.DataModel;

import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import com.kapture.middleware.DataModel.SourceConf.SourceConfBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Component
@Document(collection="UserConf")
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserConf {

	String apiname;
	List<Credential> keycreds;
	
	
}
