package com.kenny.vertxDemo.api.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.byhealth.h5.config.ErrorConfig;
import com.byhealth.h5.core.ApiReturnObject;
import com.byhealth.h5.core.BridgeListenner;
import com.byhealth.h5.core.SqlDao;
import com.byhealth.h5.core.bean.db.RecordBean;
import com.byhealth.h5.util.JsonUtil;
import com.esotericsoftware.minlog.Log;
import com.kenny.vertxDemo.api.model.user.vo.UserInfoVoModel;
import com.kenny.vertxDemo.config.TableConfig;
import com.kenny.vertxDemo.config.TipsConfig;

import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;

public class UserDao extends SqlDao{

	public UserDao(BridgeListenner bridgeListenner, RoutingContext rc) {
		super(bridgeListenner, rc);
	}
	
	/**
	 * Dao初始化方法，在new了Dao对象后必须显示调用。
	 * @param done 回调方法
	 */
	public void init(Handler<Void> done){
		super.connect(res -> {
			done.handle(null);
		});
	}

	
	public void queryUserInfo() {
		Log.info("UserDao queryUserInfo查询用户信息");
		
		HashMap<String, Object> conditionMap = new HashMap<>();
		ArrayList<String> returnFieldArray = new ArrayList<>();
		ArrayList<String> orderByFieldArray = new ArrayList<>();
		
		returnFieldArray.add(TableConfig.USER_TABLE_FIELD_USER_ID);
		returnFieldArray.add(TableConfig.USER_TABLE_FIELD_USER_NAME);
		returnFieldArray.add(TableConfig.USER_TABLE_FIELD_PASSWORD);
		returnFieldArray.add(TableConfig.USER_TABLE_FIELD_PHONE);
		
		
		//conditionMap.put(TableConfig.USER_TABLE_FIELD_USER_ID, id);
		orderByFieldArray.add(TableConfig.USER_TABLE_FIELD_USER_ID);
		
		RecordBean recordBean = new RecordBean(TableConfig.USER_TABLE_NAME, returnFieldArray);
		recordBean.setConditionMap(conditionMap);
		recordBean.setOrderByFieldArray(orderByFieldArray);
		
		super.queryRecords(recordBean, resultSetRes -> {
			
			try {
				if(resultSetRes.getRows().size() == 0) {
					ApiReturnObject aro = new ApiReturnObject("没有获取到用户信息");
												
					super.success(aro);
				}else {
					List<UserInfoVoModel> userList = new ArrayList<>();
					
					for (JsonObject object : resultSetRes.getRows()) {
						
						try {
							UserInfoVoModel userModel =  JsonUtil.getGsonForLowerCaseWithUnderscores().fromJson(object.toString(), UserInfoVoModel.class);
							userList.add(userModel);
						} catch (Exception e) {
							super.fail(ErrorConfig.SQL_ERROR, TipsConfig.QUERY_USER_INFO_FAILED);
							Log.error(e.getMessage(), e);
							return;
						}
					}
					
					Map<String,Object> resMap = new HashMap<>();
					resMap.put("userList", userList);
					
					ApiReturnObject aro = new ApiReturnObject("获取用户信息成功");
					aro.setReturnObject(resMap);
												
					super.success(aro);
				}
			} catch (Exception e) {
				super.fail(ErrorConfig.SQL_ERROR, TipsConfig.QUERY_USER_INFO_FAILED);
				Log.error(e.getMessage(), e);
				return;
			}
		});		
	}

}
