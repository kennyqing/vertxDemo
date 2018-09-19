package com.kenny.vertxDemo.config;


public final class ApiConfig {
	/** API前缀 */
	private static final String API_PREFIX = "/vertxDemoApi";

	/** 不让类实例化 */
	private ApiConfig() {
		throw new AssertionError();
	}

	// 用户模块
	/** 查询用户信息接口 */
	public static final String 	QUERY_USER_INFO_PATH = API_PREFIX + "/queryUserInfo";
	
	//项目模块
	/** 上传项目接口 */
	public static final String 	UPLOAD_PROJECT_PATH = API_PREFIX + "/public/project/uploadProject";
	
	/** 根据userId查询用户信息接口 */
	public static final String 	QUERY_USER_INFO_USERID_PATH = API_PREFIX + "/queryUserInfoByUserId";
}
