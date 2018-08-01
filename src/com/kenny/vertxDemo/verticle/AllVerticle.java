package com.kenny.vertxDemo.verticle;

import com.byhealth.h5.config.GlobalConfig;
import com.byhealth.h5.core.WebService;
import com.byhealth.h5.util.Log;
import com.kenny.vertxDemo.api.service.prac.QueryUserInfoByUserIdService;
import com.kenny.vertxDemo.api.service.prac.QueryUserInfoService;

import io.vertx.core.AbstractVerticle;

public class AllVerticle extends AbstractVerticle{
	/** 默认构造方法 */
	public AllVerticle() {}

	@Override
	public void start(){
		try {
			super.start();
			startService();
		} catch (Exception e) {
			Log.error("AllVerticle start error");
			Log.error(e.getMessage(), e);
		}

	}

	/**
	 * 开始服务，包括各种服务的初始化。
	 */
	private void startService(){
		WebService webService = new WebService(vertx);
		
		new QueryUserInfoService(webService);
		new QueryUserInfoByUserIdService(webService);
		
		if(GlobalConfig.IS_ENABLE_STATIC_RESOURCE){
			webService.enableStaticResourceAndHtml();
		}
		webService.startListen();
	};
}
