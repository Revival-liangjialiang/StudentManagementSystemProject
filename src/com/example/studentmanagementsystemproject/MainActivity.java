package com.example.studentmanagementsystemproject;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.studentmanagementsystemproject.activity.AddActivity;
import com.example.studentmanagementsystemproject.activity.ModifyActivity;
import com.example.studentmanagementsystemproject.activity.RemoveActivity;
import com.example.studentmanagementsystemproject.db.DatabaseControl;
import com.example.studentmanagementsystemproject.db.MyDatabaseHelper;
import com.example.studentmanagementsystemproject.other.MyArrayAdapter;
import com.example.studentmanagementsystemproject.other.single;

public class MainActivity extends Activity {
	SQLiteDatabase db;
	Cursor cursor;
	ListView listView;
	List<single> list = new ArrayList<single>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		try {
			setContentView(R.layout.main_layout);
			MyDatabaseHelper helper = new MyDatabaseHelper(this,"ClassTable.db",null,1);
			db = helper.getReadableDatabase();
			listView = (ListView) findViewById(R.id.listView1);
			DatabaseControl.LncomingDatabase(db);
			cursor = DatabaseControl.getData();
		} catch (Exception e) {
			Log.i("ok", "Log1="+e);
		}
		try{
		if(cursor.moveToFirst()){
			do{
				Log.i("ok", "id="+cursor.getInt(cursor.getColumnIndex("id")));
				Log.i("ok", "name="+cursor.getString(cursor.getColumnIndex("name")));
				Log.i("ok", "sex="+cursor.getString(cursor.getColumnIndex("sex")));
				Log.i("ok", "birth="+cursor.getString(cursor.getColumnIndex("birth")));
				Log.i("ok", "mobile_phone="+cursor.getString(cursor.getColumnIndex("mobile_phone")));
				single s = new single();
				s.setId(cursor.getInt(cursor.getColumnIndex("id")));
				
				s.setName(cursor.getString(cursor.getColumnIndex("name")));
				
				s.setSex(cursor.getString(cursor.getColumnIndex("sex")));
				
				s.setBirth(cursor.getString(cursor.getColumnIndex("birth")));
				
				s.setMobile_phone(cursor.getString(cursor.getColumnIndex("mobile_phone")));
				s.setAddress(cursor.getString(cursor.getColumnIndex("address")));
				list.add(s);
			}while(cursor.moveToNext());
			cursor.close();
		}
		}catch(Exception e){
			Log.i("ok", "Log2="+e);				
		}
		try{
		listView.setAdapter(new MyArrayAdapter(this,R.layout.list_item_layout,list));
		}catch(Exception e){
			Log.i("ok", "Log3="+e);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		switch (id) {
		case R.id.additem:
			Intent addintent = new Intent(this,AddActivity.class);
			startActivity(addintent);
			finish();
			break;
		case R.id.removeitem:
			Intent removeintent = new Intent(this,RemoveActivity.class);
			startActivity(removeintent);
			break;
		case R.id.modifyitem:
			Intent modifyintent = new Intent(this,ModifyActivity.class);
			startActivity(modifyintent);
			break;
		default:
			break;
		}
		return true;
	}
}
