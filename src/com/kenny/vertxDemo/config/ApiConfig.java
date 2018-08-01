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
}
