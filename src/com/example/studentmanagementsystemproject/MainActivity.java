package com.example.studentmanagementsystemproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.studentmanagementsystemproject.activity.AddActivity;
import com.example.studentmanagementsystemproject.activity.ModifyActivity;
import com.example.studentmanagementsystemproject.activity.RemoveActivity;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
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
