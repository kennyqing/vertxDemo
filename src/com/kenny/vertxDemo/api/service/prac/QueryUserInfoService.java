package com.kenny.vertxDemo.api.service.prac;

import com.byhealth.h5.core.HttpService;
import com.byhealth.h5.core.WebService;
import com.byhealth.h5.util.Log;
import com.kenny.vertxDemo.api.dao.UserDao;
import com.kenny.vertxDemo.api.model.NoParamModel;
import com.kenny.vertxDemo.config.ApiConfig;

import io.vertx.core.http.HttpMethod;
import io.vertx.ext.web.RoutingContext;

public class QueryUserInfoService extends HttpService<NoParamModel>{

	public QueryUserInfoService(WebService webService) {
		super(webService);
	}

	@Override
	public String getApiPath() {
		return ApiConfig.QUERY_USER_INFO_PATH;
	}

	@Override
	public HttpMethod getHttpMethod() {
		return HttpMethod.GET;
	}

	@Override
	public void logInputParameters(String str) {
		Log.info(str);
	}

	@Override
	public Class<NoParamModel> returnClass() {
		return NoParamModel.class;
	}

	@Override
	public void doService(NoParamModel noParamModel, RoutingContext rc) {
		Log.info("QueryUserInfoService 查询用户信息");
		
		UserDao userDao = new UserDao(QueryUserInfoService.this, rc);
		
		userDao.init(voidRes -> {
			userDao.queryUserInfo();
		});
	}

}
