package com.example.studentmanagementsystemproject.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.example.studentmanagementsystemproject.MainActivity;
import com.example.studentmanagementsystemproject.R;

public class ModifyActivity extends Activity implements OnClickListener {
	EditText et;
	Button b;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.modify_layout);
		et = (EditText) findViewById(R.id.ModifyActivityeditText);
		b = (Button) findViewById(R.id.NextStepbutton);
		b.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		String str = et.getText().toString();
		Intent intent = new Intent(this, Modify1_Activity.class);
		intent.putExtra("value",str);
		startActivity(intent);
		finish();
	}
	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
}
