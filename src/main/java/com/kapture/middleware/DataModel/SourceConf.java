package com.kapture.middleware.DataModel;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "SourceConf")
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SourceConf {

	String name;
	String authType;
	String domain;
	String parser;
	String kapoint;
	String AuthLegs;
	String status;
	String steps;
	String refresh;
	Object refreshToken;
	Object requestToken;
	Object accessCode;
	Object accessToken;
	AuthEndPoints authEndPoints;
	List<DataEndPoints> dataEndPoints;
	String formatterType;
	String type;
}
