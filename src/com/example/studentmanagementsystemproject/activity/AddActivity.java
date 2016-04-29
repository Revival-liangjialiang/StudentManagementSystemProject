package com.example.studentmanagementsystemproject.activity;

import android.app.Activity;
import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.example.studentmanagementsystemproject.R;
import com.example.studentmanagementsystemproject.db.DatabaseControl;

public class AddActivity extends Activity implements OnClickListener{
	Button addButton;
	ContentValues values = new ContentValues();
	EditText nameET,sexET,birthET,mobile_phoneET,addressET;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_layout);
		addButton = (Button) findViewById(R.id.addbutton);
		addButton.setOnClickListener(this);
		nameET = (EditText)findViewById(R.id.nameET);
		sexET= (EditText)findViewById(R.id.sexET);
		birthET= (EditText)findViewById(R.id.birthET);
		mobile_phoneET= (EditText)findViewById(R.id.mobilephoneET);
		addressET= (EditText)findViewById(R.id.addressET);
	}
	@Override
	public void onClick(View v) {
		values.put("name",nameET.getText().toString());
		values.put("sex",sexET.getText().toString());
		values.put("birth",birthET.getText().toString());
		values.put("mobile_phone",mobile_phoneET.getText().toString());
		values.put("address",addressET.getText().toString());
		DatabaseControl.addData(values,this);
		values.clear();
		DatabaseControl.clearList();
		DatabaseControl.getList();
		finish();
	}
}
