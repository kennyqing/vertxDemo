package com.kenny.vertxDemo.verticle;

import com.byhealth.h5.config.GlobalConfig;
import com.byhealth.h5.util.Log;
import com.kenny.vertxDemo.config.ProjectPrivateCofnig;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;


/**
 * 发布Verticle类
 * @author Kenny
 *
 */
public class DeployVerticle {
	/** 默认构造方法 */
	public DeployVerticle() {
		
		// 这里是测试
		Log.info("isEnableProjectPrivateConfig=="+GlobalConfig.IS_ENABLE_PROJECT_PRIVATE_CONFIG);
		Log.info("uploadFileSaveDirectory=="+GlobalConfig.UPLOAD_FILE_SAVE_DIRECTORY);
		Log.info("downloadFileSaveDirectory=="+GlobalConfig.DOWNLOAD_FILE_SAVE_DIRECTORY);
		Log.info("serverHost=="+GlobalConfig.SERVER_HOST);
		Log.info("isWindow=="+ProjectPrivateCofnig.IS_WINDOWS_PLATFOMR);
		
		VertxOptions vertxOptions = new VertxOptions();
		vertxOptions.setMaxEventLoopExecuteTime(GlobalConfig.THREAD_BLOCK_MAX_TIME * 1000000); // eventloop执行的最大时间，单位纳秒。1秒=1 000 000 000 纳秒; 1毫秒=1 000 000 纳秒
		vertxOptions.setBlockedThreadCheckInterval(GlobalConfig.THREAD_BLOCK_CHECK_INTERVAL); // 线程被阻塞时，检查的间隔，单位毫秒。1秒=1 000 毫秒
		
		Vertx vertx = Vertx.vertx(vertxOptions);
		
		DeploymentOptions deploymentOptions = new DeploymentOptions().setInstances(GlobalConfig.INSTANCES_NUM);
		vertx.deployVerticle("com.kenny.vertxDemo.verticle.AllVerticle", deploymentOptions, res -> {
			
			if (res.succeeded()) {
				String tips = "-----------所有模块部署完毕----------------";
				Log.info(tips);
			} else {
				Log.error("DeployVerticle error");
				Log.error(res.cause().getMessage(), res.cause());
			}
		});
	}
}
