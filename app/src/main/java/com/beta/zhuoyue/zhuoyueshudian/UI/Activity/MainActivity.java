package com.beta.zhuoyue.zhuoyueshudian.UI.Activity;

import android.app.Application;

import org.xutils.x;

/**
 * Created by Kevein on 2018/9/18.16:58
 */

public class MainActivity extends Application {
	@Override
	public void onCreate() {
		super.onCreate();
		x.Ext.init(this);
		x.Ext.setDebug(false); //输出debug日志，开启会影响性能

	}
}
