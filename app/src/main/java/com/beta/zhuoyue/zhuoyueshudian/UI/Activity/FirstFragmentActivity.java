package com.beta.zhuoyue.zhuoyueshudian.UI.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.beta.zhuoyue.zhuoyueshudian.R;
import com.beta.zhuoyue.zhuoyueshudian.UI.Fragment.BookCaseFragment;
import com.beta.zhuoyue.zhuoyueshudian.UI.Fragment.ClasActionFragment;
import com.beta.zhuoyue.zhuoyueshudian.UI.Fragment.FirstFragment;
import com.beta.zhuoyue.zhuoyueshudian.UI.Fragment.MyselfFragment;

/**
 * Created by Kevein on 2018/9/25.21:01
 * 2018.10.7下午进行数据修改重新进行命名
 */

public class FirstFragmentActivity extends FragmentActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {
	// 底部菜单4个Linearlayout
	private LinearLayout ll_home;
	private LinearLayout ll_address;
	private LinearLayout ll_friend;
	private LinearLayout ll_setting;

	// 底部菜单4个ImageView
	private ImageView iv_home;
	private ImageView iv_address;
	private ImageView iv_friend;
	private ImageView iv_setting;

	// 底部菜单4个菜单标题
	private TextView tv_home;
	private TextView tv_address;
	private TextView tv_friend;
	private TextView tv_setting;

	// 4个Fragment
	private android.support.v4.app.Fragment bookcaseFragment;
	private android.support.v4.app.Fragment clasactionFragment;
	private android.support.v4.app.Fragment firstFragment;
	private android.support.v4.app.Fragment myselfFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_main);


		// 初始化控件
		initView();
		// 初始化底部按钮事件
		initEvent();
		// 初始化并设置当前Fragment
		initFragment(0);

	}

	@Override
	public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

	}

	@Override
	public void onPageSelected(int position) {

	}

	@Override
	public void onPageScrollStateChanged(int state) {

	}

	@Override
	public void onClick(View v) {
		// 在每次点击后将所有的底部按钮(ImageView,TextView)颜色改为灰色，然后根据点击着色
		restartBotton();
		// ImageView和TetxView置为黑色，页面随之跳转
		switch (v.getId()) {
			case R.id.ll_home:
				iv_home.setImageResource(R.drawable.ic_first_page1);
				tv_home.setTextColor(Color.rgb(0, 0, 0));
				initFragment(0);
				break;
			case R.id.ll_address:
				iv_address.setImageResource(R.drawable.ic_bookcase);
				tv_address.setTextColor(Color.rgb(0, 0, 0));
				initFragment(1);
				break;
			case R.id.ll_friend:
				iv_friend.setImageResource(R.drawable.ic_clasaction);
				tv_friend.setTextColor(Color.rgb(0, 0, 0));
				initFragment(2);
				break;
			case R.id.ll_setting:
				iv_setting.setImageResource(R.drawable.ic_myself);
				tv_setting.setTextColor(Color.rgb(0, 0, 0));
				initFragment(3);
				break;

			default:
				break;
		}
	}

	private void initFragment(int index) {
		// 由于是引用了V4包下的Fragment，所以这里的管理器要用getSupportFragmentManager获取
		FragmentManager fragmentManager = getSupportFragmentManager();
		// 开启事务
		android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
		// 隐藏所有Fragment
		hideFragment(transaction);
		switch (index) {
			case 0:
				if (bookcaseFragment == null) {
					bookcaseFragment = new FirstFragment();
					transaction.add(R.id.fl_content, bookcaseFragment);
				} else {
					transaction.show(bookcaseFragment);
				}
				break;
			case 1:
				if (clasactionFragment == null) {
					clasactionFragment = new BookCaseFragment();
					transaction.add(R.id.fl_content, clasactionFragment);
				} else {
					transaction.show(clasactionFragment);
				}

				break;
			case 2:
				if (firstFragment == null) {
					firstFragment = new ClasActionFragment();
					transaction.add(R.id.fl_content, firstFragment);
				} else {
					transaction.show(firstFragment);
				}

				break;
			case 3:
				if (myselfFragment == null) {
					myselfFragment = new MyselfFragment();
					transaction.add(R.id.fl_content, myselfFragment);
				} else {
					transaction.show(myselfFragment);
				}

				break;

			default:
				break;
		}

		// 提交事务
		transaction.commit();

	}

	//隐藏Fragment
	private void hideFragment(android.support.v4.app.FragmentTransaction transaction) {
		if (bookcaseFragment != null) {
			transaction.hide(bookcaseFragment);
		}
		if (clasactionFragment != null) {
			transaction.hide(clasactionFragment);
		}
		if (firstFragment != null) {
			transaction.hide(firstFragment);
		}
		if (myselfFragment != null) {
			transaction.hide(myselfFragment);
		}

	}

	private void initEvent() {
		// 设置按钮监听
		ll_home.setOnClickListener(this);
		ll_address.setOnClickListener(this);
		ll_friend.setOnClickListener(this);
		ll_setting.setOnClickListener(this);

	}

	private void initView() {

		// 底部菜单4个Linearlayout
		this.ll_home = (LinearLayout) findViewById(R.id.ll_home);
		this.ll_address = (LinearLayout) findViewById(R.id.ll_address);
		this.ll_friend = (LinearLayout) findViewById(R.id.ll_friend);
		this.ll_setting = (LinearLayout) findViewById(R.id.ll_setting);

		// 底部菜单4个ImageView
		this.iv_home = (ImageView) findViewById(R.id.iv_home);
		this.iv_address = (ImageView) findViewById(R.id.iv_address);
		this.iv_friend = (ImageView) findViewById(R.id.iv_friend);
		this.iv_setting = (ImageView) findViewById(R.id.iv_setting);

		// 底部菜单4个菜单标题
		this.tv_home = (TextView) findViewById(R.id.tv_home);
		this.tv_address = (TextView) findViewById(R.id.tv_address);
		this.tv_friend = (TextView) findViewById(R.id.tv_friend);
		this.tv_setting = (TextView) findViewById(R.id.tv_setting);

	}

	private void restartBotton() {
		// ImageView置为墨色
		iv_home.setImageResource(R.drawable.ic_first_page1_c);
		iv_address.setImageResource(R.drawable.ic_bookcase_c);
		iv_friend.setImageResource(R.drawable.ic_clasaction_c);
		iv_setting.setImageResource(R.drawable.ic_myself_c);
		// TextView置为白色
		tv_home.setTextColor(Color.rgb(120, 144, 156));
		tv_address.setTextColor(Color.rgb(120, 144, 156));
		tv_friend.setTextColor(Color.rgb(120, 144, 156));
		tv_setting.setTextColor(Color.rgb(120, 144, 156));
	}

}
