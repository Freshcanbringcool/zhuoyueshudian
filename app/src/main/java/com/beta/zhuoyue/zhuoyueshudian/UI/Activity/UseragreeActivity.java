package com.beta.zhuoyue.zhuoyueshudian.UI.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.beta.zhuoyue.zhuoyueshudian.R;

/**
 * Created by Kevein on 2018/9/23.14:04
 */

public class UseragreeActivity extends Activity {
	private ImageView exit;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.useragreement);
		initaction();
		initview();
	}

	private void initview() {
		exit = (ImageView) findViewById(R.id.exit_useraggreement);
	}

	private void initaction() {
		exit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(UseragreeActivity.this, RegistereActivity.class);
				startActivity(intent);

			}
		});
	}

}
