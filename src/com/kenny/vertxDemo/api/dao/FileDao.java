package com.kenny.vertxDemo.api.dao;

import java.util.HashMap;
import java.util.Map;

import com.byhealth.h5.core.ApiReturnObject;
import com.byhealth.h5.core.BridgeListenner;
import com.byhealth.h5.core.SqlDao;
import com.byhealth.h5.util.Log;
import com.kenny.vertxDemo.api.model.project.UploadProjectPoModel;

import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;

public class FileDao extends SqlDao{

	public FileDao(BridgeListenner bridgeListenner, RoutingContext rc) {
		super(bridgeListenner, rc);
	}

	public void init(Handler<Void> done) {
		super.connect(res -> {
			done.handle(null);
		});
	}

	
	public void uploadProject(UploadProjectPoModel uploadProjectPoModel, String fileFullName) {
		Log.info("uploadProjectPoModel fileFullName=" + fileFullName + " uploadProjectPoModel=" + uploadProjectPoModel);

		String fileName = fileFullName.substring(fileFullName.lastIndexOf("/") + 1, fileFullName.length());
		
		Log.info("文件上传成功，project_uuid为:"+fileName);
		
		Map<String, String> roMap = new HashMap<>();
		roMap.put("project_uuid", fileName);
		ApiReturnObject aro = new ApiReturnObject("项目上传成功");
		aro.setReturnObject(roMap);
		super.success(aro);
		
	}
	
	
	
}
