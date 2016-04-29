package com.example.studentmanagementsystemproject;

import android.app.Activity;
import android.content.Intent;
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

public class MainActivity extends Activity {
	SQLiteDatabase db;
	ListView listView;
	MyArrayAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		try {
			setContentView(R.layout.main_layout);
			MyDatabaseHelper helper = new MyDatabaseHelper(this,
					"ClassTable.db", null, 1);
			db = helper.getReadableDatabase();
			listView = (ListView) findViewById(R.id.listView1);
			DatabaseControl.LncomingDatabase(db,adapter);
			adapter = new MyArrayAdapter(this,R.layout.list_item_layout, DatabaseControl.getList());
		} catch (Exception e) {
			Log.i("ok", "Log1=" + e);
		}
			listView.setAdapter(adapter);
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
			Intent addintent = new Intent(this, AddActivity.class);
			startActivity(addintent);
			break;
		case R.id.removeitem:
			Intent removeintent = new Intent(this, RemoveActivity.class);
			startActivity(removeintent);
			break;
		case R.id.modifyitem:
			Intent modifyintent = new Intent(this, ModifyActivity.class);
			startActivity(modifyintent);
			break;
		default:
			break;
		}
		return true;
	}
}
