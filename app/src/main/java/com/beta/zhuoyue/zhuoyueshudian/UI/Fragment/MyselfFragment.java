package com.beta.zhuoyue.zhuoyueshudian.UI.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.beta.zhuoyue.zhuoyueshudian.R;
import com.beta.zhuoyue.zhuoyueshudian.UI.Activity.MyMs_MessageActivity;

/**
 * Created by Kevein on 2018/9/25.21:22
 */

public class MyselfFragment extends android.support.v4.app.Fragment {
	private LinearLayout my_mysetting;//我的设置
	private LinearLayout my_mystar;//我的收藏
	private LinearLayout my_mess;//消息动态
	private LinearLayout my_getnew;//提点意见
	private LinearLayout my_love;//阅读爱好

	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.f_myself_main, container, false);
		my_mysetting = (LinearLayout) view.findViewById(R.id.ms_mysetting);
		my_mystar = (LinearLayout) view.findViewById(R.id.ms_mystar);
		my_mess = (LinearLayout) view.findViewById(R.id.ms_mess);
		my_getnew = (LinearLayout) view.findViewById(R.id.ms_getnew);
		my_love = (LinearLayout) view.findViewById(R.id.ms_love);
		initaction();
		return view;
	}


	private void initaction() {
		my_mess.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent1 = new Intent(getActivity(), MyMs_MessageActivity.class);//跳转到消息动态的IM的消息页面

				startActivity(intent1);

			}
		});
	}

}
