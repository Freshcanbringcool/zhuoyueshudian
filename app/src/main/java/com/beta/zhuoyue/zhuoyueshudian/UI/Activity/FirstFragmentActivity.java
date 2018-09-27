package com.beta.zhuoyue.zhuoyueshudian.UI.Activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.beta.zhuoyue.zhuoyueshudian.R;
import com.beta.zhuoyue.zhuoyueshudian.UI.Fragment.BookCaseFragment;
import com.beta.zhuoyue.zhuoyueshudian.UI.Fragment.ClasActionFragment;
import com.beta.zhuoyue.zhuoyueshudian.UI.Fragment.FirstFragment;
import com.beta.zhuoyue.zhuoyueshudian.UI.Fragment.MyselfFragment;

/**
 * Created by Kevein on 2018/9/25.21:01
 */

public class FirstFragmentActivity extends Activity implements View.OnClickListener{
	//定义四个Fragment
	private Fragment firstpageFragment = new FirstFragment();			//首页
	private Fragment clasactionFragment = new ClasActionFragment();		//书架
	private Fragment bookcaseFragment = new BookCaseFragment();				//分类
	private Fragment myselfFragment = new MyselfFragment();				//我的


	//定义四个Fragment布局ly=Layout,fr=Frame;
	private FrameLayout firstpage_fr_ly,clasaction_fr_ly,bookcase_fr_ly,myself_fr_ly;

	//定义Fragment布局中的图片组件
	private ImageView firstpage_fr_im,clasaction_fr_im,bookcase_fr_im,myself_fr_im;

	//定义四个Fragment布局中的图片对应文字tv=textview;
	private TextView firstpage_fr_tv,clasaction_fr_tv,bookcase_fr_tv,myself_fr_tv;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		// 去除标题
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.firstpage_fragment_main);
		//初始化组件
		initview();
		//初始化按钮单击组件
		initClickEvent();
		//初始化Fragment
		initFragment();
	}
	//初始化全部Fragment
	private void initFragment()
	{
		FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
		if (!firstpageFragment.isAdded())
		{
			fragmentTransaction.add(R.id.content,firstpageFragment);
			fragmentTransaction.hide(firstpageFragment);
		}
		if (!bookcaseFragment.isAdded())
		{
			fragmentTransaction.add(R.id.content,bookcaseFragment);
			fragmentTransaction.hide(firstpageFragment);
		}
		if (!clasactionFragment.isAdded())
		{
			fragmentTransaction.add(R.id.content,clasactionFragment);
			fragmentTransaction.hide(clasactionFragment);
		}
		if (!myselfFragment.isAdded())
		{
			fragmentTransaction.add(R.id.content,myselfFragment);
			fragmentTransaction.hide(myselfFragment);
		}
		hideAllFragment(fragmentTransaction);
		//默认显示第一个fragement
		fragmentTransaction.show(firstpageFragment);
		fragmentTransaction.commit();
	}
	//隐藏所有的Fragment
	private void hideAllFragment(FragmentTransaction fragmentTransaction)
	{
		fragmentTransaction.hide(firstpageFragment);
		fragmentTransaction.hide(bookcaseFragment);
		fragmentTransaction.hide(clasactionFragment);
		fragmentTransaction.hide(myselfFragment);

	}
	private void initview()				//初始化组件
	{
		firstpage_fr_ly=(FrameLayout)findViewById(R.id.firstpage_f_Layout);
		bookcase_fr_ly=(FrameLayout)findViewById(R.id.bookcase_f_tLayout);
		clasaction_fr_ly=(FrameLayout)findViewById(R.id.clasactionLayout);
		myself_fr_ly=(FrameLayout)findViewById(R.id.myselfLayout);
		firstpage_fr_im=(ImageView)findViewById(R.id.firstpage_im);
		firstpage_fr_tv=(TextView)findViewById(R.id.firstpageTextView);
		bookcase_fr_im=(ImageView)findViewById(R.id.bookcaseImageView);
		bookcase_fr_tv=(TextView)findViewById(R.id.bookcaseTextView);
		clasaction_fr_im=(ImageView)findViewById(R.id.clasactionImageView);
		clasaction_fr_tv=(TextView)findViewById(R.id.clasactionTextView);
		myself_fr_im=(ImageView)findViewById(R.id.myselfImageView);
		myself_fr_tv=(TextView)findViewById(R.id.myselfTextView);
	}
	private void initClickEvent()		//初始化按钮单击组件
	{
		firstpage_fr_ly.setOnClickListener(this);
		bookcase_fr_ly.setOnClickListener(this);
		clasaction_fr_ly.setOnClickListener(this);
		myself_fr_ly.setOnClickListener(this);
	}
	public void onClick(View v) {
			switch (v.getId())
			{
				case R.id.firstpage_f_Layout:
					//点击首页
					clickTab(firstpageFragment);
					break;
				case R.id.bookcase_f_tLayout:
						//点击书架
						clickTab(bookcaseFragment);
					break;
				case R.id.clasactionLayout:
					//点击分类
					clickTab(clasactionFragment);
					break;
				case R.id.myselfLayout:
					//点击我的
					clickTab(myselfFragment);
					break;

					default:
						break;
			}

	}
	private void clickTab(Fragment tabFragment)
	{
		//清除上次选中的状态
		clearSelected();

		FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

		//隐藏所有Fragemnt
		hideAllFragment(fragmentTransaction);

		//显示Fragment
		fragmentTransaction.show(tabFragment);

		//提交事务
		fragmentTransaction.commit();

		//改变Tab样式，设置为选中状态
		changeTabStyle(tabFragment);
	}
	//清除上次选中状态
	private void clearSelected()
	{
		if(!firstpageFragment.isHidden())
		{
			firstpage_fr_im.setImageResource(R.drawable.ic_first_page1);
			firstpage_fr_tv.setTextColor(Color.parseColor("#101010"));
		}
		if(!bookcaseFragment.isHidden())
		{
			bookcase_fr_im.setImageResource(R.drawable.ic_bookcase);
			bookcase_fr_tv.setTextColor(Color.parseColor("#101010"));
		}
		if(!clasactionFragment.isHidden())
		{
			clasaction_fr_im.setImageResource(R.drawable.ic_clasaction);
			clasaction_fr_tv.setTextColor(Color.parseColor("#101010"));
		}
		if(!myselfFragment.isHidden())
		{
			myself_fr_im.setImageResource(R.drawable.ic_myself);
			myself_fr_tv.setTextColor(Color.parseColor("#101010"));
		}

	}
	//检测Fragment的状态改变样式
	private void changeTabStyle(Fragment tabFragment)
	{
		if(tabFragment instanceof FirstFragment)
		{
			firstpage_fr_im.setImageResource(R.drawable.ic_first_page1_c);
			firstpage_fr_tv.setTextColor(Color.parseColor("#008b8b"));
		}
		if(tabFragment instanceof BookCaseFragment)
		{
			bookcase_fr_im.setImageResource(R.drawable.ic_bookcase_c);
			bookcase_fr_tv.setTextColor(Color.parseColor("#008b8b"));
		}
		if(tabFragment instanceof ClasActionFragment)
		{
			clasaction_fr_im.setImageResource(R.drawable.ic_clasaction_c);
			clasaction_fr_tv.setTextColor(Color.parseColor("#008b8b"));
		}
		if(tabFragment instanceof MyselfFragment)
		{
			myself_fr_im.setImageResource(R.drawable.ic_myself_c);
			myself_fr_tv.setTextColor(Color.parseColor("#008b8b"));
		}

	}
}
