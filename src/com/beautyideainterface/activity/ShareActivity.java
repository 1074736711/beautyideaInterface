package com.beautyideainterface.activity;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.ShareSDKUIShell;
import cn.sharesdk.onekeyshare.theme.classic.PlatformGridView;
import cn.sharesdk.sina.weibo.SinaWeibo;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ShareActivity extends Activity {
	Button btn;
	Platform sina = null;
	public static final int ACTION_SHARE=1;
	public static final int ACTION_AUTHORIZE=2;
	public static final int ACTION_CANCLE=3;
	public static final int ACTION_UNCONNECT=4;
	Handler handler =new Handler(){
	 public void handleMessage(Message msg) {
		  switch (msg.arg1) {
		case ACTION_SHARE:
					Toast.makeText(ShareActivity.this, "分享成功", Toast.LENGTH_SHORT).show();
			break;
		case ACTION_AUTHORIZE:
	
			break;
		case ACTION_CANCLE:
			break;
		
		case ACTION_UNCONNECT:
			break;

		}
		  
	 };
		
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.beauty_shares);
		ShareSDK.initSDK(this);	
	
	}
	
	public void sinaweiboShare(String title,String imageurl){
					sina = ShareSDK.getPlatform(SinaWeibo.NAME);
					sina.setPlatformActionListener(new PlatformActionListener() {
							Message message  =new Message();	 
						@Override
						public void onError(Platform arg0, int arg1, Throwable arg2) {
							
						}
						
						@Override
						public void onComplete(Platform arg0, int action, HashMap<String, Object> arg2) {
							if(action==Platform.ACTION_AUTHORIZING){
								message.arg1  = ACTION_AUTHORIZE;
								handler.sendMessage(message);
							}
							else 
							if(action==Platform.ACTION_SHARE)
						{
								 	  message.arg1 = ACTION_SHARE;
								 	  handler.sendMessage(message);
						}
						}
						
						@Override
						public void onCancel(Platform arg0, int arg1) {
						
							
						}
					});
	}
}