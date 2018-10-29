package com.beta.zhuoyue.zhuoyueshudian.UI.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.beta.zhuoyue.zhuoyueshudian.R;

import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Created by Kevein on 2018/9/25.21:21
 */

public class ClasActionFragment extends android.support.v4.app.Fragment {



	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

		return inflater.inflate(R.layout.f_classification_main, container, false);
	}

}
