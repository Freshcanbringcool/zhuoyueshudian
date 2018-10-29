package com.beta.zhuoyue.zhuoyueshudian.UI.View;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by Kevein on 2018/10/29.18:08
 */

public class GlideImageLoader extends ImageLoader {

	@Override
	public void displayImage(Context context, Object path, ImageView imageView) {
		//Glide 加载图片用法
		Glide.with(context).load(path).into(imageView);
	}
}
