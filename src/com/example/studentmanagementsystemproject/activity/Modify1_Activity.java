package com.example.studentmanagementsystemproject.activity;


import java.util.List;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.example.studentmanagementsystemproject.R;
import com.example.studentmanagementsystemproject.db.DatabaseControl;
import com.example.studentmanagementsystemproject.other.single;

public class Modify1_Activity extends Activity implements OnClickListener{
	Cursor cursor;
	Button b;
	Intent intent;
	EditText nameET,sexET,birthET,mobile_phoneET,addressET;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.modify1_layout);
		intent = getIntent();
		b = (Button) findViewById(R.id.modifybutton);
		b.setOnClickListener(this);
		nameET = (EditText)findViewById(R.id.modifynameET);
		sexET = (EditText)findViewById(R.id.modifysexET);
		birthET = (EditText)findViewById(R.id.modifybirthET);
		mobile_phoneET = (EditText)findViewById(R.id.modifymobilephoneET);
		addressET = (EditText)findViewById(R.id.modifyaddressET);
		cursor = DatabaseControl.getAppointData(intent.getStringExtra("value"));
		cursor.moveToFirst();
		nameET.setText(cursor.getString(cursor.getColumnIndex("name")));
		sexET.setText(cursor.getString(cursor.getColumnIndex("sex")));
		birthET.setText(cursor.getString(cursor.getColumnIndex("birth")));
		mobile_phoneET.setText(cursor.getString(cursor.getColumnIndex("mobile_phone")));
		addressET.setText(cursor.getString(cursor.getColumnIndex("address")));
	}
	@Override
	public void onClick(View v) {
		ContentValues values = new ContentValues();
		values.put("name", nameET.getText().toString());
		values.put("sex", sexET.getText().toString());
		values.put("birth", birthET.getText().toString());
		values.put("mobile_phone", mobile_phoneET.getText().toString());
		values.put("address", addressET.getText().toString());
		DatabaseControl.setData(values,intent.getStringExtra("value"));
			DatabaseControl.clearList();
			DatabaseControl.getList();
		finish();
	}
}
