package com.beautyideainterface.utils;

import java.util.ArrayList;

import android.util.Log;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.beautyideainterface.bean.List_informations;
import com.beautyideainterface.bean.Comments;

public class ParseJson {
	String json;
	  	 	 public ParseJson (String json){
	  	 		 this.json = json;
	  	 	 }
	 public ArrayList<List_informations>parselistInfo(){
		  JSONObject jsonObject = JSONObject.parseObject(json);
		  Log.i("jsonObject", jsonObject.toJSONString());
		  
		  	JSONArray resources = JSONArray.parseArray(jsonObject.getString("resources"));
		  	Log.i("resources", resources.toJSONString());
		  	ArrayList<List_informations> temp_datasource=  (ArrayList<List_informations>) 
		  											resources.parseArray(resources.toJSONString(), List_informations.class);
		 return temp_datasource; 
	 }
	 public ArrayList<Comments> parseComments(){
		  JSONObject jsonObject = JSONObject.parseObject(json);
		  
		  JSONArray comments  =JSONArray.parseArray(jsonObject.getString("comments"));
		  Log.i("comments", comments.toJSONString());
		  ArrayList<Comments> temp_datasource =(ArrayList<Comments>)
				  								comments.parseArray(comments.toJSONString(), Comments.class);
		 return temp_datasource;
	 }
}
