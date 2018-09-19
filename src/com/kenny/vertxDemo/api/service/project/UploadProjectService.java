package com.kenny.vertxDemo.api.service.project;

import com.byhealth.h5.core.FileService;
import com.byhealth.h5.core.WebService;
import com.byhealth.h5.util.Log;
import com.kenny.vertxDemo.api.dao.FileDao;
import com.kenny.vertxDemo.api.model.project.UploadProjectPoModel;
import com.kenny.vertxDemo.config.ApiConfig;

import io.vertx.core.http.HttpMethod;
import io.vertx.ext.web.RoutingContext;

public class UploadProjectService extends FileService<UploadProjectPoModel>{

	public UploadProjectService(WebService webService) {
		super(webService);
	}

	@Override
	public String getApiPath() {
		return ApiConfig.UPLOAD_PROJECT_PATH;
	}

	@Override
	public HttpMethod getHttpMethod() {
		return HttpMethod.POST;
	}

	@Override
	public Class<UploadProjectPoModel> returnClass() {
		return UploadProjectPoModel.class;
	}

	@Override
	public void logInputParameters(String jsonStr) {
		Log.info(jsonStr);
	}

	@Override
	public void doService(UploadProjectPoModel uploadProjectPoModel, String fileFullName, RoutingContext rc) {
		Log.info("UploadProjectService 上传项目文件");
		
		FileDao fileDao = new FileDao(UploadProjectService.this, rc);
		
		fileDao.init(voidRes -> {
			fileDao.uploadProject(uploadProjectPoModel,fileFullName);
		});
		
	}

}
