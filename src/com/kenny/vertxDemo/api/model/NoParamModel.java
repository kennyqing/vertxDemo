package com.kenny.vertxDemo.api.model;

import com.byhealth.h5.core.BaseModel;

/**
 * 无参数数据模型，不可以实例化
 * @author Kenny
 *
 */
public class NoParamModel extends BaseModel{
	/** 构造方法 */
	private NoParamModel() {}

	@Override
	public boolean isParametersValid() {
		return true;
	}

}
