package com.beta.zhuoyue.zhuoyueshudian.UI.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.beta.zhuoyue.zhuoyueshudian.R;
import com.beta.zhuoyue.zhuoyueshudian.UI.View.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevein on 2018/9/25.21:20
 */

public class FirstFragment extends android.support.v4.app.Fragment  {
	private View mView;
	private Banner       banner;
	private List<String> imageUrl;

	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		mView = inflater.inflate(R.layout.f_firstpage_main, null);
		initDate();
		initView();

		return mView;

	}


	private void initDate() {
		//图片地址
		imageUrl = new ArrayList<>();
		imageUrl.add("http://111.230.204.150/img/examples/lun01.jpg");
		imageUrl.add("http://111.230.204.150/img/examples/lun02.jpg");
		imageUrl.add("http://111.230.204.150/img/examples/lun03.jpg");

	}
	private void initView() {
		banner = (Banner) mView.findViewById(R.id.banner);
		banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
		banner.setImageLoader(new GlideImageLoader());
		banner.setImages(imageUrl);
		banner.setDelayTime(3000);
		banner.start();
	}

}
