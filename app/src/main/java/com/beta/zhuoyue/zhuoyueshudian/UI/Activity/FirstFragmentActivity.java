package com.beta.zhuoyue.zhuoyueshudian.UI.Activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
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
	private Fragment bookcasefragment = new BookCaseFragment();				//分类
	private Fragment Myselffragment = new MyselfFragment();				//我的


	//定义四个Fragment布局ly=Layout,fr=Frame;
	private FrameLayout firstpage_fr_ly,clasaction_fr_ly,bookcase_fr_ly,myself_fr_ly;

	//定义Fragment布局中的图片组件
	private ImageView firstpage_fr_im,clasaction_fr_im,bookcase_fr_im,myself_fr_im;

	//定义四个Fragment布局中的图片对应文字tv=textview;
	private TextView firstpage_fr_tv,clasaction_fr_tv,bookcase_fr_tv,myself_fr_tv;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.firstpage_fragment_main);
		//初始化组件
		initview();
		//初始化按钮单击组件
		initaction();
		//初始化Fragment
		initFragment();
	}
	//初始化全部Fragment
	private void initFragment()
	{
		FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
	}
	public void onClick(View v) {

	}
}
