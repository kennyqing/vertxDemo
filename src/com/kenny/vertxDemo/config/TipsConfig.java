package com.kenny.vertxDemo.config;

/**
 * 信息提示配置类
 * @author Kenny
 *
 */
public final class TipsConfig {
	/** 不让类实例化 */
	private TipsConfig() {
		throw new AssertionError();
	}


	// 用户模块
	/** 查询用户信息失败 */
	public static final String QUERY_USER_INFO_FAILED = "查询用户信息失败";
}
