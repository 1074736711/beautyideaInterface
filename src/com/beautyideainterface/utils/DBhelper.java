package com.beautyideainterface.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelper extends SQLiteOpenHelper{
	 static DBhelper dBhelper ;
	public DBhelper(Context context) {
		super(context,"BeautyIdeaInterface", null, 1);
	}
	  public static DBhelper newInstance(Context context){
		  if(dBhelper==null)
		  {
			  dBhelper  =new DBhelper(context);
			  return dBhelper;
		  }
		  else 
			  return dBhelper;
		  
	  }
	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql ="create table favorite(_id Interger primarykey autoincrement"
				+ "rsId"
				+ "date"
				+ "time"
				+ "icon"
				+ "title)";
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
	}
	
}
