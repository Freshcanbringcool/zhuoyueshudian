package com.beta.zhuoyue.zhuoyueshudian.UI.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.beta.zhuoyue.zhuoyueshudian.R;

/**
 * Created by Kevein on 2018/9/23.15:29
 */

public class GuideOpenActivity extends Activity {
	private ImageView en_tx,en_weibo,en_winxin,en_phone;
	private TextView jc_register,jc_login;
	private Button jc_random;


	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.openpage_main);
		initview();
		initaction();
	}
	private void initview()
	{
		en_tx = (ImageView)findViewById(R.id.en_tx);
		en_weibo=(ImageView)findViewById(R.id.en_weibo);
		en_phone = (ImageView)findViewById(R.id.en_phone);
		jc_register = (TextView) findViewById(R.id.jc_register);
		jc_login =(TextView) findViewById(R.id.jc_login);


	}
	private void initaction()
	{
		jc_register.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent_re = new Intent(GuideOpenActivity.this,RegistereActivity.class);
				startActivity(intent_re);
			}
		});
		jc_login.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent_lg = new Intent(GuideOpenActivity.this,LoginActivity.class);
				startActivity(intent_lg);
			}
		});
		en_phone.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent_ph = new Intent(GuideOpenActivity.this,LoginActivity.class);
				startActivity(intent_ph);
			}
		});


	}
}
