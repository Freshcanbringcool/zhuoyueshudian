package com.beta.zhuoyue.zhuoyueshudian.UI.Activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.beta.zhuoyue.zhuoyueshudian.R;
import com.beta.zhuoyue.zhuoyueshudian.UI.Common.MyMs_MessageAdapter;
import com.beta.zhuoyue.zhuoyueshudian.UI.Fragment.DirectMessageFragment;
import com.beta.zhuoyue.zhuoyueshudian.UI.Fragment.DynamicFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevein on 2018/10/9.10:42
 */
/*
* 点击消息页面跳转之后的页面*/
public class MyMs_MessageActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {
	private TabLayout           tabLayout;
	private ViewPager           ms_viewPager;
	private MyMs_MessageAdapter viewPagerAdapter;
	//TabLayout标签
	private String[]       titles    = new String[]{"动态", "私信"};
	private List<Fragment> fragments = new ArrayList<>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		// 去除标题
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.f_ms_message_main);
		if (getSupportActionBar() != null){

			getSupportActionBar().hide();

		}
		init();

	}

	private void init() {
		tabLayout = (TabLayout) findViewById(R.id.tab_layou);
		ms_viewPager = (ViewPager) findViewById(R.id.view_pager);
		//设置TabLayout标签的显示方式
		tabLayout.setTabMode(TabLayout.MODE_FIXED);
		//循环注入标签
		for (String tab : titles) {
			tabLayout.addTab(tabLayout.newTab().setText(tab));
		}
		//设置TabLayout点击事件
		tabLayout.setOnTabSelectedListener(this);

		fragments.add(new DirectMessageFragment());
		fragments.add(new DynamicFragment());

		viewPagerAdapter = new MyMs_MessageAdapter(getSupportFragmentManager(), titles, fragments);
		ms_viewPager.setAdapter(viewPagerAdapter);
		tabLayout.setupWithViewPager(ms_viewPager);
	}

	@Override
	public void onTabSelected(TabLayout.Tab tab) {
		ms_viewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(TabLayout.Tab tab) {

	}

	@Override
	public void onTabReselected(TabLayout.Tab tab) {

	}
}
