package com.kenny.vertxDemo.api.model.user.po;

import com.byhealth.h5.core.BaseModel;
import com.kenny.vertxDemo.config.ParameterInvalidTipsConfig;

public class QueryUserInfoByUserIdPoModel extends BaseModel{
	private Integer userId;
	
	public Integer getUserId() {
		return userId;
	}

	private QueryUserInfoByUserIdPoModel() {}

	@Override
	public boolean isParametersValid() {
		if(userId == null) {
			//setParameterInvalidTip("课程ID不正确");
			setParameterInvalidTip(ParameterInvalidTipsConfig.INVALID_USER_ID);
			return false;
		}
		
		return true;
	}

	@Override
	public String toString() {
		return "QueryUserInfoByUserIdPoModel [userId=" + userId + "]";
	}

	
}
