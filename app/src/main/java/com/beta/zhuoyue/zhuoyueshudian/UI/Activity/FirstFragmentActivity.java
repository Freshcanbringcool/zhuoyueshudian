package com.beta.zhuoyue.zhuoyueshudian.UI.Activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import com.beta.zhuoyue.zhuoyueshudian.Model.FirstFragmentPAdapter;
import com.beta.zhuoyue.zhuoyueshudian.R;
import com.beta.zhuoyue.zhuoyueshudian.UI.Fragment.BookCaseFragment;
import com.beta.zhuoyue.zhuoyueshudian.UI.Fragment.ClasActionFragment;
import com.beta.zhuoyue.zhuoyueshudian.UI.Fragment.DirectMessageFragment;
import com.beta.zhuoyue.zhuoyueshudian.UI.Fragment.FirstFragment;
import com.beta.zhuoyue.zhuoyueshudian.UI.Fragment.MyselfFragment;

import java.util.ArrayList;

/**
 * Created by Kevein on 2018/9/25.21:01
 * 2018.10.7下午进行数据修改重新进行命名
 */

public class FirstFragmentActivity extends FragmentActivity {
	private Intent  homeIntent;//新增一个跳转的方式使得数据能够返回
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

	//实现Tab滑动效果
	private ViewPager mViewPager;


	//动画图片的宽度
	private int bmpW;

	//当前页卡的编号
	private int currIndex = 0;

	//存放Fragment
	private ArrayList<Fragment> mFragmentArrayList;
	//管理Fragment
	private FragmentManager     mFragmentManager;

	private Context mContext;

	private static final String TAG = "FirstFragmentActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_main);
		mContext = this;

		// 初始化控件
		initView();
		// 初始化底部按钮事件
		initEvent();
		// 初始化并设置当前Fragment
		initFragment();
		//初始化ViewPager
		InitViewPager();

	}

	@Override
	public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
		return super.onCreateView(parent, name, context, attrs);
	}

	//初始化页面内容区
	private void InitViewPager()
	{
		mViewPager = (ViewPager) findViewById(R.id.vp);
		mViewPager.setAdapter(new FirstFragmentPAdapter(mFragmentManager,mFragmentArrayList));

		//让ViewPager缓存4个页面
		mViewPager.setOffscreenPageLimit(4);
		//设置默认打开第一个页面
		mViewPager.setCurrentItem(0);
		//将图片和文字回复默认设置
		restartBotton();
		//设置ViewPager页面滑动监听事件
		mViewPager.setOnPageChangeListener(new FirstPageChangeListener());

	}
	/**
	 * 头标点击监听
	 * @author weizhi
	 * @version 1.0
	 */
	public class FirstClickListener implements View.OnClickListener{
		private int index = 0 ;
		public FirstClickListener(int i) {
			index = i;
		}

		@Override
		public void onClick(View v) {
			mViewPager.setCurrentItem(index);
		}
	}
	public class FirstPageChangeListener implements ViewPager.OnPageChangeListener{
		@Override
		public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

		}

		@Override
		public void onPageSelected(int position) {

			switch (position)
			{
				//当前为页卡1
				case 0:
					//从页卡1跳转转到页卡2
					if(currIndex == 1){
						restartBotton();
						iv_address.setImageResource(R.drawable.ic_bookcase);
						tv_home.setTextColor(Color.rgb(0, 0, 0));
					}else if(currIndex == 2){//从页卡1跳转转到页卡3
						restartBotton();
						iv_friend.setImageResource(R.drawable.ic_clasaction);
						tv_setting.setTextColor(Color.rgb(0, 0, 0));
					}
					else if (currIndex == 3) {//从页面卡1跳转卡4
						restartBotton();
						iv_setting.setImageResource(R.drawable.ic_myself);
						tv_setting.setTextColor(Color.rgb(0, 0, 0));
					}
					break;

				//当前为页卡2
				case 1:
					//从页卡2跳转转到页卡1
					if (currIndex == 0) {
						restartBotton();
						iv_home.setImageResource(R.drawable.ic_first_page1);
						tv_home.setTextColor(Color.rgb(0, 0, 0));
					} else if (currIndex == 2) { //从页卡2跳转转到页卡3

						restartBotton();
						iv_friend.setImageResource(R.drawable.ic_clasaction);
						tv_friend.setTextColor(Color.rgb(0, 0, 0));
					}
					else if(currIndex == 3) {//卡2跳卡4

						restartBotton();
						iv_setting.setImageResource(R.drawable.ic_myself);
						tv_setting.setTextColor(Color.rgb(0, 0, 0));
					}
					break;

				//当前为页卡3
				case 2:
					//从页卡3跳转转到页卡1
					if (currIndex == 0) {

						restartBotton();
						iv_home.setImageResource(R.drawable.ic_first_page1);
						tv_home.setTextColor(Color.rgb(0, 0, 0));

					} else if (currIndex == 1) {//从页卡3跳转转到页卡2

						restartBotton();
						iv_address.setImageResource(R.drawable.ic_bookcase);
						tv_address.setTextColor(Color.rgb(0, 0, 0));
					}
					else if(currIndex == 3) {//3-4

						restartBotton();
						iv_setting.setImageResource(R.drawable.ic_myself);
						tv_setting.setTextColor(Color.rgb(0, 0, 0));
					}
				case 3:
					//从页卡4跳转转到页卡1
					if (currIndex == 0) {

						restartBotton();
						iv_home.setImageResource(R.drawable.ic_first_page1);
						tv_home.setTextColor(Color.rgb(0, 0, 0));

					} else if (currIndex == 1) {//从页卡4跳转转到页卡2

						restartBotton();
						iv_address.setImageResource(R.drawable.ic_bookcase);
						tv_address.setTextColor(Color.rgb(0, 0, 0));
					}
					else if(currIndex == 2) {//4-2

						restartBotton();
						iv_friend.setImageResource(R.drawable.ic_clasaction);
						tv_friend.setTextColor(Color.rgb(0, 0, 0));
					}
					currIndex = position;


					break;
				}
			}

		@Override
		public void onPageScrollStateChanged(int state) {

		}
	}



	private void initEvent() {
		// 设置按钮监听
		ll_home.setOnClickListener(new FirstClickListener(0));
		ll_address.setOnClickListener(new FirstClickListener(1));
		ll_friend.setOnClickListener(new FirstClickListener(2));
		ll_setting.setOnClickListener(new FirstClickListener(3));

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
private void initFragment()
{
	mFragmentArrayList =new ArrayList<Fragment>();
	mFragmentArrayList.add(new FirstFragment());
	mFragmentArrayList.add(new BookCaseFragment());
	mFragmentArrayList.add(new ClasActionFragment());
	mFragmentArrayList.add(new MyselfFragment());

	mFragmentManager = getSupportFragmentManager();
	firstFragment = new FirstFragment();
	mFragmentManager.beginTransaction().add(R.id.vp,firstFragment).commit();
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

	@Override
	protected void onNewIntent(Intent intent) {
		homeIntent = intent;
		super.onNewIntent(intent);
	}
public void showFragment(int position)//显示返回跳转需要的fragment
{
	hideFragments();
	Fragment fragment = mFragmentArrayList.get(position);
	FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
	ft.show(fragment);
	ft.commit();

}
	public void hideFragments() {
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		for(Fragment fragment : mFragmentArrayList) {
			if(fragment != null) {
				ft.hide(fragment);
			}
		}
		ft.commit();
	}

	//Fragment的返回跳从这里进行接收
	@Override
	protected void onResume() {
		/**
		 * 设置为竖屏
		 */
		if(getRequestedOrientation()!= ActivityInfo.SCREEN_ORIENTATION_PORTRAIT){
			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		}

		//Fragment进行跳转的时候开启ID2也就是BookCaseFragment进行页面的接收
		int id = getIntent().getIntExtra("id",0);//FirstFragment
		if(id == 1)//如果返回的ID是2也就是BOOKCASEFragment页面
		{
			FragmentManager bc_Fragment = getSupportFragmentManager();
			FragmentTransaction ft =bc_Fragment.beginTransaction();
			BookCaseFragment bck = new BookCaseFragment();
			ft.replace(R.id.file_list,bck);
			ft.commit();
			mViewPager.setCurrentItem(1);
			//帮助跳转到指定子fragment
			Intent i  = new Intent();
			i.setClass(FirstFragmentActivity.this,BookCaseFragment.class);
			i.putExtra("id",1);
		}
		super.onResume();
	}

}
