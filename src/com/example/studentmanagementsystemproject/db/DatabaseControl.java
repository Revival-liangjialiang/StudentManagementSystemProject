package com.example.studentmanagementsystemproject.db;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.studentmanagementsystemproject.other.MyArrayAdapter;
import com.example.studentmanagementsystemproject.other.single;

public class DatabaseControl {
	public static Cursor cursor;
	public static SQLiteDatabase db;
	public static MyArrayAdapter adapter;
	public static Context context;
	public static List<single> list = new ArrayList<single>();

	public static void LncomingDatabase(SQLiteDatabase arg0,MyArrayAdapter arg1) {
		db = arg0;
		adapter = arg1;
	}

	public static void addData(ContentValues values, Context arg0) {
		db.insert("ClassTable", null, values);
		context = arg0;
	}

	public static Cursor getData() {
		Cursor cursor = db.query("ClassTable", null, null, null, null, null,
				null);
		return cursor;
	}
        //得到指定数据。
	public static Cursor getAppointData(String str) {
		Cursor cursor = db.query("ClassTable", null, "id = ?",
				new String[] { str }, null, null, null);
		return cursor;
	}
	//设置指定数据。
	public static void setData(ContentValues values, String str) {
		db.update("ClassTable", values, "id = ?", new String[] { str });
	}
	public static void RefreshListView(){
		adapter.notifyDataSetChanged();
	}
	public static List<single> getList(){
		cursor = getData();
		if (cursor.moveToFirst()) {
			do {
				single s = new single();
				s.setId(cursor.getInt(cursor.getColumnIndex("id")));

				s.setName(cursor.getString(cursor.getColumnIndex("name")));

				s.setSex(cursor.getString(cursor.getColumnIndex("sex")));

				s.setBirth(cursor.getString(cursor.getColumnIndex("birth")));

				s.setMobile_phone(cursor.getString(cursor
						.getColumnIndex("mobile_phone")));
				s.setAddress(cursor.getString(cursor
						.getColumnIndex("address")));
				list.add(s);
			} while (cursor.moveToNext());
			cursor.close();
		}
		return list;
	}
	//清空List。
	public static void clearList(){
		list.clear();
	}
	public static void removeData(String str){
		db.delete("ClassTable", "id = ?", new String[] {str});
	}
}
