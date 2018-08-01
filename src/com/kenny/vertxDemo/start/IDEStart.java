package com.kenny.vertxDemo.start;

import com.kenny.vertxDemo.verticle.DeployVerticle;

/**
 * <p> IDE启动系统的主入口。</p>
 * @author Kenny
 *
 */
public class IDEStart {
	/** 默认构造方法 */
	public IDEStart() {}

	/**
	 * 静态main方法
	 * @param args 字符串参数数组
	 */
	public static void main(String[] args) {
		new DeployVerticle();
	}
}
