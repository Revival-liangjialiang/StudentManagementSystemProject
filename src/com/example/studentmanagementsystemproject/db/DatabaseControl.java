package com.example.studentmanagementsystemproject.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class DatabaseControl {
	public static SQLiteDatabase db;

	public static void LncomingDatabase(SQLiteDatabase arg0) {
		db = arg0;
	}

	public static void addData(ContentValues values,Context context) {
		db.insert("ClassTable", null, values);
		Toast.makeText(context, "Ìí¼Ó³É¹¦", Toast.LENGTH_SHORT).show();
	}
	public static Cursor getData(){
		Cursor cursor = db.query("ClassTable", null,null, null, null, null, null);
		return cursor;
	}
}
