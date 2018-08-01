package com.kenny.vertxDemo.start;

import com.kenny.vertxDemo.verticle.DeployVerticle;

import io.vertx.core.AbstractVerticle;

public class CommandLineStart extends AbstractVerticle{
	
	/** 默认构造方法 */
	public CommandLineStart() {}

	@Override
	public void start() {
		new DeployVerticle();
	}
	
}
