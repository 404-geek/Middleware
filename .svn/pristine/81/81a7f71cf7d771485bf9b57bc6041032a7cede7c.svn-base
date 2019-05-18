package com.kapture.middleware.DataModel;

import java.time.LocalDateTime;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//import com.kapture.middleware.model.ProcessedModel.ProcessedBuilder;

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
@Document(collection = "ProcessedDataCollection")
public class ProcessedModel {

	@Id
	public ObjectId _id;
	String type;
	String apikey;
	String label;
	LocalDateTime time;
	String data;
}
