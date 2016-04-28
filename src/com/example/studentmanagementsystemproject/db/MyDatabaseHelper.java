package com.example.studentmanagementsystemproject.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper {
	public static final String CREATE_TABLE = "create table ClassTable("
			+"id integer primary key autoincrement,"
			+"name text,"
			+"sex text,"
			+"birth text,"
			+"mobile_phone text,"
			+"address text)";
	
	public MyDatabaseHelper(Context context,String name,CursorFactory factory,int version) {
		super(context,name,factory,version);
	}

	@Override
	public void onCreate(SQLiteDatabase arg0) {
		arg0.execSQL(CREATE_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

}
