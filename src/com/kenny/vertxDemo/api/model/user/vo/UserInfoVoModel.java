package com.kenny.vertxDemo.api.model.user.vo;

import com.byhealth.h5.core.BaseModel;

public class UserInfoVoModel extends BaseModel{
	private Integer userId;
	
	private String userName;
	
	private String password;
	
	private String phone;
	
	private UserInfoVoModel() {}

	@Override
	public String toString() {
		return "UserInfoVoModel [userId=" + userId + ", userName=" + userName + ", password=" + password + ", phone="
				+ phone + "]";
	}

	@Override
	public boolean isParametersValid() {
		return true;
	}	
}
