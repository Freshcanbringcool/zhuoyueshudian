package com.beta.zhuoyue.zhuoyueshudian.UI.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.beta.zhuoyue.zhuoyueshudian.R;

/**
 * Created by Kevein on 2018/9/19.15:22
 */
/*欢迎界面*/
public class GuideActivity extends Activity {
	//声明控件对象
	private TextView textView;
	private int count = 3;
	private Animation animation;
	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			if (msg.what == 0) {
				textView.setText(getCount() + "");
				handler.sendEmptyMessageDelayed(0, 1000);
				animation.reset();
				textView.startAnimation(animation);
			}

		}

		;

	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 去除标题
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.guide_main);
		// 初始化控件对象
		textView = (TextView) findViewById(R.id.textView);
		animation = AnimationUtils.loadAnimation(this, R.anim.animation_text);
		//textView.startAnimation(animation);
		handler.sendEmptyMessageDelayed(0, 1000);

	}

	private int getCount() {
		count--;
		if (count == 0) {
			Intent intent = new Intent(this, MainActivity.class);
			startActivity(intent);
			finish();
		}
		return count;
	}

}
