package com.kenny.vertxDemo.config;

import com.byhealth.h5.config.GlobalConfig;
import com.byhealth.h5.util.JsonUtil;
import com.kenny.vertxDemo.api.model.ProjectPrivateConfigModel;

public final class ProjectPrivateCofnig {
	/** 是否是Window平台 */
	public static final boolean IS_WINDOWS_PLATFOMR;
	
//	/** 微信公众号APP ID */
//	public static final String WP_APP_ID;
//	
//	/** 微信公众号APP SECRET */
//	public static final String WP_APP_SECRET;
//	
//	/** 学员二维码登录访问令牌有效时间，单位豪秒  */
//	public static final long STUDENT_QR_CODE_LOGIN_TOKEN_EFFECTIVE_TIME;
//	
//	/** 短信验证码有效时间，单位毫秒  */
//	public static final long SMS_VERIFICATION_CODE_EFFECTIVE_TIME;

	static {
		ProjectPrivateConfigModel  ppcm = JsonUtil.getGson().fromJson(GlobalConfig.PROJECT_PRIVATE_CONFIG, ProjectPrivateConfigModel.class);
		
		IS_WINDOWS_PLATFOMR = ppcm.isWindow();
//		WP_APP_ID = ppcm.getWpAppId();
//		WP_APP_SECRET = ppcm.getWpAppSecret();
//		STUDENT_QR_CODE_LOGIN_TOKEN_EFFECTIVE_TIME = ppcm.getStudentQRCodeLoginTokenEffectiveTime() * 1000;
//		SMS_VERIFICATION_CODE_EFFECTIVE_TIME = ppcm.getSmsVerificationCodeEffectiveTime()*1000;
	}

	/** 不让类实例化 */
	private ProjectPrivateCofnig() {
		throw new AssertionError();
	}
}
