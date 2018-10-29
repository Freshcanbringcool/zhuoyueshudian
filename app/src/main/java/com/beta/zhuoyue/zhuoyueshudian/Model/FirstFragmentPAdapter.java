package com.beta.zhuoyue.zhuoyueshudian.Model;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Kevein on 2018/10/24.15:41
 */

public class FirstFragmentPAdapter extends FragmentPagerAdapter {

	//存放Fragment的数组
	private ArrayList<Fragment> fragmentsList;

	public FirstFragmentPAdapter(FragmentManager fm, ArrayList<Fragment> fragmentsList) {
		super(fm);
		this.fragmentsList = fragmentsList;
	}

	@Override
	public Fragment getItem(int position) {

		return fragmentsList.get(position);
	}

	@Override
	public int getCount() {
		return fragmentsList.size();
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		super.destroyItem(container, position, object);
	}

}
