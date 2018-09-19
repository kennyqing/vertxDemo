package com.kenny.vertxDemo.api.model.project;

import com.byhealth.h5.core.BaseModel;

public class UploadProjectPoModel extends BaseModel{
	private String projectName;
		
	public String getProjectName() {
		return projectName;
	}

	private UploadProjectPoModel() {}

	@Override
	public boolean isParametersValid() {
		
		return true;
	}

	@Override
	public String toString() {
		return "UploadProjectPoModel [projectName=" + projectName + "]";
	}	
}
