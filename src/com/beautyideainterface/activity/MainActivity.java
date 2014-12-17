package com.beautyideainterface.activity;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.beautyideainterface.adapter.TabPagerAdapter;
import com.beautyideainterface.bean.List_informations;
import com.beautyideainterface.fragment.MainFragment;
import com.beautyideainterface.fragment.SecondFragment;
import com.beautyideainterface.utils.BaseActivity;
import com.beautyideainterface.utils.ParseJson;
import com.beautyideainterface.utils.Path_Url;

@SuppressLint("NewApi")
public class MainActivity extends FragmentActivity implements ActionBar.TabListener, ViewPager.OnPageChangeListener {
	private ViewPager mViewPager;
	private ArrayList<View> mViews;
	private TabPagerAdapter mPagerAdapter;
	private ActionBar mActionBar;
	private ArrayList<Tab> mTabs;
	TextView  tv ;
		  @Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			
			setContentView(R.layout.mainlayout); 
			final StringBuffer sb  =new StringBuffer();
//			tv = (TextView) findViewById(R.id.text);
			RequestQueue queue  = Volley.newRequestQueue(this);
			StringRequest request = new StringRequest(Path_Url.PATH_URL1+0+Path_Url.PATH_URL2,
										new Listener<String>() {

											@Override
											public void onResponse(
													String response) {
												ArrayList<List_informations>temp=new ParseJson(response).parselistInfo();
												for(List_informations info :temp)
												{
													//sb.append(info);
													sb.append(info.toString()+"\n");
										
												}
												Log.i("sb", sb.toString());
											}
										}, new ErrorListener() {

											@Override
											public void onErrorResponse(
													VolleyError error) {
												
											}
										});
			queue.add(request);
//			 Button button= (Button) findViewById(R.id.button1);
//			  button.setOnClickListener(new OnClickListener() {
//
//				@Override
//				public void onClick(View v) {
//						Intent intent = new Intent(MainActivity.this, TestActivity.class);
//
//						startActivity(intent);
//						overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
//				}
//			});

			  configureActionBar();
			
//			 ActionBar actionBar  = this.getActionBar(); 
//			 actionBar.setDisplayHomeAsUpEnabled(true);	
//			 actionBar.setDisplayShowHomeEnabled(true);	
//			 actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
//			 Tab  aTab = actionBar.newTab();
//			 Tab  bTab = actionBar.newTab();
//			 aTab.setText("1");
//			 bTab.setText("2");
//			 actionBar.addTab(aTab);
//			 actionBar.addTab(bTab);
			// aTab.setTabListener(listener)
		}

	private void configureActionBar(){
		mActionBar = getActionBar();
//		mActionBar.setDisplayHomeAsUpEnabled(true);
//		mActionBar.setDisplayShowHomeEnabled(true);
		mActionBar.setHomeButtonEnabled(true);
		mActionBar.setIcon(R.drawable.ic_menu_32px);
		mActionBar.setTitle(R.string.activity_title);
		mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		mTabs = new ArrayList<Tab>();
		Tab mainTab = mActionBar.newTab() ;
		Tab secondTab = mActionBar.newTab();
		mainTab.setText(getResources().getString(R.string.mainTab));
		secondTab.setText(getResources().getString(R.string.secondTab));

		mainTab.setTabListener(this);
		secondTab.setTabListener(this);
		mTabs.add(mainTab);
		mTabs.add(secondTab);
		mActionBar.addTab(mainTab);
		mActionBar.addTab(secondTab);

		//初始化viewpager
		mViewPager = (ViewPager) findViewById(R.id.activity_viewPager);
		mViews =new ArrayList<View>();
		mViews.add(LayoutInflater.from(this).inflate(R.layout.fragment_main,null));
		mViews.add(LayoutInflater.from(this).inflate(R.layout.fragment_second,null));

		mPagerAdapter = new TabPagerAdapter(getSupportFragmentManager());
		mViewPager.setAdapter(mPagerAdapter);
		mViewPager.setOnPageChangeListener(this);


	}


	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		if (mViewPager!=null){
			mViewPager.setCurrentItem(tab.getPosition());
		}
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {

	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {

	}



	@Override
	public void onPageScrolled(int i, float v, int i1) {

	}

	@Override
	public void onPageSelected(int i) {
		mViewPager.setCurrentItem(i);
		mActionBar.selectTab(mTabs.get(i));
	}

	@Override
	public void onPageScrollStateChanged(int i) {

	}
}
