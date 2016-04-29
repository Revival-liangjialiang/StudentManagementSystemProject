package com.example.studentmanagementsystemproject.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.studentmanagementsystemproject.R;
import com.example.studentmanagementsystemproject.db.DatabaseControl;

public class RemoveActivity extends Activity implements OnClickListener{
	Button b;
	EditText et;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.remove_layout);
		b = (Button) findViewById(R.id.removebutton);
		et = (EditText) findViewById(R.id.removeeditText);
		b.setOnClickListener(this);
	}
	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
	@Override
	public void onClick(View v) {
		String str = et.getText().toString();
		DatabaseControl.removeData(str);
		DatabaseControl.clearList();
		DatabaseControl.getList();
		Toast.makeText(this, "É¾³ý³É¹¦", Toast.LENGTH_SHORT).show();
		finish();
	}
}
