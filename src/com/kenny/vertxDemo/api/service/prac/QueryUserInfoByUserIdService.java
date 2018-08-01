package com.kenny.vertxDemo.api.service.prac;

import com.byhealth.h5.core.HttpService;
import com.byhealth.h5.core.WebService;
import com.esotericsoftware.minlog.Log;
import com.kenny.vertxDemo.api.dao.UserDao;
import com.kenny.vertxDemo.api.model.user.po.QueryUserInfoByUserIdPoModel;
import com.kenny.vertxDemo.config.ApiConfig;

import io.vertx.core.http.HttpMethod;
import io.vertx.ext.web.RoutingContext;

public class QueryUserInfoByUserIdService extends HttpService<QueryUserInfoByUserIdPoModel>{

	public QueryUserInfoByUserIdService(WebService webService) {
		super(webService);
	}

	@Override
	public String getApiPath() {
		return ApiConfig.QUERY_USER_INFO_USERID_PATH;
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
	public Class<QueryUserInfoByUserIdPoModel> returnClass() {
		return QueryUserInfoByUserIdPoModel.class;
	}

	@Override
	public void doService(QueryUserInfoByUserIdPoModel queryUserInfoByUserIdPoModel, RoutingContext rc) {
		Log.info("QueryUserInfoByUserIdService");
		
		UserDao userDao = new UserDao(QueryUserInfoByUserIdService.this, rc);
		
		userDao.init(voidRes -> {
			userDao.queryUserInfoByUserId(queryUserInfoByUserIdPoModel);
		});
		
	}

}
