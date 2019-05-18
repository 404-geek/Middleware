package com.kapture.middleware.DataInterfaces;

import com.kapture.middleware.DTOModels.RequestBuilderDTO;
import com.kapture.middleware.DataModel.SourceConf;

public interface Authentication {

	public RequestBuilderDTO authentication(SourceConf source);
}
