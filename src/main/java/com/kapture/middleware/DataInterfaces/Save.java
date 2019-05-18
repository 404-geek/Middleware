package com.kapture.middleware.DataInterfaces;

import java.util.List;

import org.springframework.stereotype.Component;

import com.kapture.middleware.DataModel.Model;


@Component
public interface Save {

	public String save(List<Model> modelList);
}
