package com.kenny.vertxDemo.config;

public final class ParameterInvalidTipsConfig {
	/** 不让类实例化 */
	private ParameterInvalidTipsConfig() {
		throw new AssertionError();
	}

	/** 非法参数 */
	public static final String INVALID_PARAMETER = "请传入合法的参数";


	// 用户模块
	/** userId非法 */
	public static final String INVALID_USER_ID = "请传入合法的userId";
}
