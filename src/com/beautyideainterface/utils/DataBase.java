package com.beautyideainterface.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DataBase {
	DBhelper dbhelper;
	Context context;
	
			public DataBase (Context context){
					super();
					this.context = context;
					dbhelper = DBhelper.newInstance(context);
			}
			public void add(String rsID){
					SQLiteDatabase  sqLiteDatabase  = dbhelper.getWritableDatabase();
					ContentValues  values  = new ContentValues();
					values.put("rsId", rsID);
					 sqLiteDatabase.insert("BeautyIdeaInterface", null, values);
			}
			  public String getrsID(){
				return null;
				  
			  }
}
