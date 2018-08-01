package com.kenny.vertxDemo.config;

public final class TableConfig {
	/** 不让类实例化 */
	private TableConfig() {
		throw new AssertionError();
	}
	
	// 1 用户表
	/** 用户表表名 */
	public static final String USER_TABLE_NAME = "t_user";

	/** 用户表: 表的唯一标识，自增，主键 */
	public static final String USER_TABLE_FIELD_USER_ID = "user_id";

	/** 用户表: 用户名 */
	public static final String USER_TABLE_FIELD_USER_NAME = "user_name";

	/** 用户表: 密码 */
	public static final String USER_TABLE_FIELD_PASSWORD = "password";

	/** 用户表: 手机号码 */
	public static final String USER_TABLE_FIELD_PHONE = "phone";
}
