package com.kenny.vertxDemo.api.model;

public class ProjectPrivateConfigModel {
	/** 是否是Window平台 */
	private boolean isWindow;
	
	/** 微信公众号APP ID */
	private String wpAppId;
	
	/** 微信公众号APP SECRET */
	private String wpAppSecret;

	/** 学员二维码登录访问令牌有效时间，单位豪秒 */
	private long studentQRCodeLoginTokenEffectiveTime;
	
	/** 短信验证码有效时间，单位豪秒 */
	private long smsVerificationCodeEffectiveTime;

	/** 构造方法 */
	private ProjectPrivateConfigModel() {}

	/**
	 * 获取微信公众号APP ID
	 * @return 微信公众号APP ID
	 */
	public String getWpAppId() {
		return wpAppId;
	}

	/**
	 * 获取微信公众号APP SECRET
	 * @return 微信公众号APP SECRET
	 */
	public String getWpAppSecret() {
		return wpAppSecret;
	}

	/**
	 * 获取学员二维码登录访问令牌有效时间，单位豪秒
	 * @return 学员二维码登录访问令牌有效时间
	 */
	public long getStudentQRCodeLoginTokenEffectiveTime() {
		return studentQRCodeLoginTokenEffectiveTime;
	}

	public boolean isWindow() {
		return isWindow;
	}

	public long getSmsVerificationCodeEffectiveTime() {
		return smsVerificationCodeEffectiveTime;
	}
}
