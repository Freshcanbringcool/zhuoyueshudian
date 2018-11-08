package com.beta.zhuoyue.zhuoyueshudian.UI.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.beta.zhuoyue.zhuoyueshudian.R;
import com.beta.zhuoyue.zhuoyueshudian.UI.Activity.FirstFragmentActivity;
import com.beta.zhuoyue.zhuoyueshudian.UI.View.GlideImageLoader;
import com.beta.zhuoyue.zhuoyueshudian.UI.View.TitlebarView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import zxing.activity.CaptureActivity;

/**
 * Created by Kevein on 2018/9/25.21:20
 */

public class FirstFragment extends android.support.v4.app.Fragment {
	private View         mView;
	private Banner       banner;//主页显示的banner轮播图
	private List<String> imageUrl;//图片的地址

	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		mView = inflater.inflate(R.layout.f_firstpage_main, null);
		initDate();
		initView();
/*因为考虑到null的事件所以标题栏的点击事件就切换到onCreateView中*/
		TitlebarView titlebarView = (TitlebarView) mView.findViewById(R.id.title);
		titlebarView.setTitleSize(20);
		titlebarView.setTitle("首页");
		titlebarView.setOnViewClick(new TitlebarView.onViewClick() {
			@Override
			public void leftClick() {
				Intent intenti = new Intent(getActivity(), CaptureActivity.class);
				startActivity(intenti);


			}

			@Override
			public void rightClick() {

				Toast.makeText(getActivity(), "分享", Toast.LENGTH_SHORT).show();

			}
		});

		return mView;
	}


	private void initDate() {
		//图片地址
		imageUrl = new ArrayList<>();
		/*连接的图片地址为服务器的图片地址，后面可以根据网页的地址进行更改*/
		imageUrl.add("http://111.230.204.150/img/examples/lun01.jpg");
		imageUrl.add("http://111.230.204.150/img/examples/lun02.jpg");
		imageUrl.add("http://111.230.204.150/img/examples/lun03.jpg");
	}

	private void initView() {

		banner = (Banner) mView.findViewById(R.id.banner);
		banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
		banner.setImageLoader(new GlideImageLoader());//使用Glide导入图片
		banner.setImages(imageUrl);/*设置轮播图的URL*/
		banner.setDelayTime(3000);	/*设置轮播图转换的时间*/
		banner.start();
	}

	/*
1.onActivityCreated  控件的初始化    getActivity().findViewById(R.id.button);

2.onActivityCreated     点击事件

这里特别注意的是 如果使用getActivity().findViewById(R.id.button);
这种方法查找控件，则该语句必须写在onActivityCreated方法中。
因为fragment在执行onCreateView()方法的时候上一层的activity还没有调用oncreate方法。
这时候fragment中的onCreateView()方法使用getactivity()得到的是null
运行时直接   nullpointerexception
*/
	private void initTitle() {
		TitlebarView titlebarView = (TitlebarView) mView.findViewById(R.id.title);
		titlebarView.setTitleSize(20);
		titlebarView.setTitle("首页");
		titlebarView.setOnViewClick(new TitlebarView.onViewClick() {
			@Override
			public void leftClick() {
				Intent intenti = new Intent(getActivity(), CaptureActivity.class);
				startActivity(intenti);


			}

			@Override
			public void rightClick() {

				Toast.makeText(getActivity(), "分享", Toast.LENGTH_SHORT).show();

			}
		});
	}

}
