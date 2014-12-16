package com.beautyideainterface.activity;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
import com.beautyideainterface.bean.List_informations;
import com.beautyideainterface.utils.BaseActivity;
import com.beautyideainterface.utils.ParseJson;
import com.beautyideainterface.utils.Path_Url;

@SuppressLint("NewApi")
public class mainActivity extends Activity{
	TextView  tv ;
		  @Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			
			setContentView(R.layout.mainlayout); 
			final StringBuffer sb  =new StringBuffer();
			tv = (TextView) findViewById(R.id.text);
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
			 Button button= (Button) findViewById(R.id.button1);
			  button.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
						Intent intent = new Intent(mainActivity.this, TestActivity.class);
					
						startActivity(intent);
						overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
				}
			});
			
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
}	
