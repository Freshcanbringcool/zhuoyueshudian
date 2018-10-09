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
	private ImageView entx, enweibo, enwinxin, en_phone;
	private TextView jc_register, jc_login;
	private Button jc_random;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.openpage);
		initview();
		initaction();
	}

	private void initview() {
		entx = (ImageView) findViewById(R.id.en_tx);
		enweibo = (ImageView) findViewById(R.id.en_weibo);
		en_phone = (ImageView) findViewById(R.id.en_phone);
		jc_register = (TextView) findViewById(R.id.jc_register);
		jc_login = (TextView) findViewById(R.id.jc_login);
		jc_random = (Button) findViewById(R.id.jc_random);

	}

	private void initaction() {
		jc_register.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent_re = new Intent(GuideOpenActivity.this, RegistereActivity.class);
				startActivity(intent_re);
				return;
			}
		});
		jc_login.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent_lg = new Intent(GuideOpenActivity.this, LoginActivity.class);
				startActivity(intent_lg);
				return;
			}
		});
		en_phone.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent_ph = new Intent(GuideOpenActivity.this, LoginActivity.class);
				startActivity(intent_ph);
				return;

			}
		});
		jc_random.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent_rn = new Intent(GuideOpenActivity.this, FirstFragmentActivity.class);
				startActivity(intent_rn);
				return;
			}
		});

	}
}
