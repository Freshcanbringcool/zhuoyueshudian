package com.beta.zhuoyue.zhuoyueshudian.UI.Activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.beta.zhuoyue.zhuoyueshudian.Presenter.RegistUtil;
import com.beta.zhuoyue.zhuoyueshudian.R;

/**
 * Created by Kevein on 2018/9/22.12:13
 */

public class RegistereActivity extends Activity {
	private EditText et_account;
	private EditText et_password;
	private Button   btn_regist;
	private TextView bt_agree;//用户协议
	private TextView weak, in, strong;
	private ToggleButton checkeye;


	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.register_main);
		Intent intent = getIntent();
		initview();//引用绑定的控件
		initaction();//引用绑定动作的行为
	}

	private void initview() {
		et_account = (EditText) findViewById(R.id.in_account);
		et_password = (EditText) findViewById(R.id.in_pass);
		btn_regist = (Button) findViewById(R.id.bt_register);//绑定注册按钮
		bt_agree = (TextView) findViewById(R.id.usertext);//绑定用户协议提示
		weak = (TextView) findViewById(R.id.pwd_weak);//绑定弱密码文字提示
		in = (TextView) findViewById(R.id.pwd_in);//绑定中密码文字提示
		strong = (TextView) findViewById(R.id.pwd_strong);//绑定强密码文字提示
		checkeye = (ToggleButton) findViewById(R.id.TogglePwd);//明文密文切换显示

	}

	private void initaction() {
		et_password.addTextChangedListener(new TextWatcher() {


			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				String str = et_password.getText().toString().trim();
				int length = str.length();
				if (length > 0) {
					if (!RegistUtil.isNumberLetter(str)) {
						str = str.substring(0, length - 1);
						et_password.setText(str);
						String str1 = et_password.getText().toString().trim();
						et_password.setSelection(str1.length());
						et_password.setError("密码只能是字母和数字");
					}
					//当输入框为0时
					if (str.length() == 0) {
						weak.setBackgroundColor(Color.rgb(205, 205, 205));
						in.setBackgroundColor(Color.rgb(205, 205, 205));
						strong.setBackgroundColor(Color.rgb(205, 205, 205));
					}
					//当输入为弱密码时
					if (str.matches("^[0-9]+$")) {
						weak.setBackgroundColor(Color.rgb(255, 129, 128));
						in.setBackgroundColor(Color.rgb(205, 205, 205));
						strong.setBackgroundColor(Color.rgb(205, 205, 205));
					}
					//输入的纯小写字母为弱
					else if (str.matches("^[a-z]+$")) {
						weak.setBackgroundColor(Color.rgb(255, 129, 128));
						in.setBackgroundColor(Color.rgb(205, 205, 205));
						strong.setBackgroundColor(Color.rgb(205, 205, 205));
					}
					//输入的纯大写字母为弱
					else if (str.matches("^[A-Z]+$")) {
						weak.setBackgroundColor(Color.rgb(255, 129, 128));
						in.setBackgroundColor(Color.rgb(205, 205, 205));
						strong.setBackgroundColor(Color.rgb(205, 205, 205));
					}
					//输入的大写字母和数字，输入的字符小于7个密码为弱
					else if (str.matches("^[A-Z0-9]{1,5}")) {
						weak.setBackgroundColor(Color.rgb(255, 129, 128));
						in.setBackgroundColor(Color.rgb(205, 205, 205));
						strong.setBackgroundColor(Color.rgb(205, 205, 205));
					}
					//输入的小写字母和数字，输入的字符大于7个密码为中
					else if (str.matches("^[a-z0-9]{6,16}")) {
						weak.setBackgroundColor(Color.rgb(255, 129, 128));
						in.setBackgroundColor(Color.rgb(255, 184, 77));
						strong.setBackgroundColor(Color.rgb(205, 205, 205));
					}
					//输入的大写字母和小写字母，输入的字符小于7个密码为弱
					else if (str.matches("^[A-Za-z]{1,5}")) {
						weak.setBackgroundColor(Color.rgb(255, 129, 128));
						in.setBackgroundColor(Color.rgb(205, 205, 205));
						strong.setBackgroundColor(Color.rgb(205, 205, 205));
					}
					//输入的大写字母和小写字母，输入的字符大于7个密码为中
					else if (str.matches("^[A-Za-z]{6,16}")) {
						weak.setBackgroundColor(Color.rgb(255, 129, 128));
						in.setBackgroundColor(Color.rgb(255, 184, 77));
						strong.setBackgroundColor(Color.rgb(205, 205, 205));
					}
					//输入的大写字母和小写字母和数字，输入的字符小于5个个密码为弱
					else if (str.matches("^[A-Za-z0-9]{1,5}")) {
						weak.setBackgroundColor(Color.rgb(255, 129, 128));
						in.setBackgroundColor(Color.rgb(205, 205, 205));
						strong.setBackgroundColor(Color.rgb(205, 205, 205));
					}
					//输入的大写字母和小写字母和数字，输入的字符大于6个个密码为中
					else if (str.matches("^[A-Za-z0-9]{6,8}")) {
						weak.setBackgroundColor(Color.rgb(255, 129, 128));
						in.setBackgroundColor(Color.rgb(255, 184, 77));
						strong.setBackgroundColor(Color.rgb(205, 205, 205));
					}
					//输入的大写字母和小写字母和数字，输入的字符大于8个密码为强
					else if (str.matches("^[A-Za-z0-9]{9,16}")) {
						weak.setBackgroundColor(Color.rgb(255, 129, 128));
						in.setBackgroundColor(Color.rgb(255, 184, 77));
						strong.setBackgroundColor(Color.rgb(113, 198, 14));
					}

				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {

			}

			@Override
			public void afterTextChanged(Editable s) {

			}
		});
		et_account.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {

			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				String str = et_account.getText().toString().trim();
				int length = str.length();
				if (length > 0) {
					if (RegistUtil.isContainChinese(str)) {
						str = str.substring(0, length - 1);
						et_account.setText(str);
						String str1 = et_account.getText().toString().trim();
						et_account.setSelection(str1.length());
						et_account.setError("手机号不能输入中文");
					}
				}
			}

			@Override
			public void afterTextChanged(Editable s) {

			}
		});
		checkeye.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if (isChecked) {
					//如果选中，显示密码
					et_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
				} else {
					//否则隐藏密码
					et_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
				}
			}
		});
		bt_agree.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent in_agreement = new Intent(RegistereActivity.this, UseragreeActivity.class);
				startActivity(in_agreement);

			}
		});


	}

	public class RegisterOnClickListener implements View.OnClickListener {


		@Override
		public void onClick(View v) {
			String str_account = et_account.getText().toString().trim();
			String str_password = et_account.getText().toString().trim();

			if (TextUtils.isEmpty(str_account)) {
				et_account.setError("请输入手机号");
				et_account.setFocusable(true);
				et_account.requestFocus();
				return;

			}
			if (RegistUtil.isMobileNo(str_account)) {
				et_account.setError("手机号格式不正确");
				et_account.setFocusable(true);
				et_account.requestFocus();
			}
			if (RegistUtil.strLength(str_account) > 11) {
				et_account.setError("手机号长度不能低于11位");
				et_account.setFocusable(true);
				et_account.requestFocus();
			}
			if (RegistUtil.strLength(str_account) <= 14) {
				et_account.setError("手机号长度不得高于14位");
				et_account.setFocusable(true);
				et_account.requestFocus();
			}
			if (TextUtils.isEmpty(str_password)) {
				et_password.setError("请输入密码");
				et_password.setFocusable(true);
				et_password.requestFocus();
			}
			if (RegistUtil.strLength(str_password) > 6) {
				et_password.setError("密码不得小于6位");
				et_password.setFocusable(true);
				et_password.requestFocus();
			}
			if (RegistUtil.strLength(str_password) < 18) {
				et_password.setError("密码不得大于18位");
				et_password.setFocusable(true);
				et_password.requestFocus();
			}

		}
	}
}
