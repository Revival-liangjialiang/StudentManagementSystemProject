package com.example.studentmanagementsystemproject.other;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.studentmanagementsystemproject.R;

public class MyArrayAdapter extends ArrayAdapter<single> {
	Context context;
	int item_layout;
	TextView tv;

	public MyArrayAdapter(Context context, int itemLayout_id, List<single> list) {
		super(context, itemLayout_id, list);
		this.context = context;
		this.item_layout = itemLayout_id;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view;
		single s = getItem(position);
		if (convertView == null) {
			view = LayoutInflater.from(getContext()).inflate(item_layout, null);
			efficiency c = new efficiency();
			tv = (TextView) view.findViewById(R.id.idTV);
			tv.setText(s.getId() + "");
			c.idtv = tv;

			tv = (TextView) view.findViewById(R.id.nameTV);
			tv.setText(s.getName());
			c.nametv = tv;

			tv = (TextView) view.findViewById(R.id.sexTV);
			tv.setText(s.getSex());
			c.sextv = tv;

			tv = (TextView) view.findViewById(R.id.birthTV);
			tv.setText(s.getBirth());
			c.birthtv = tv;

			tv = (TextView) view.findViewById(R.id.mobilephoneTV);
			tv.setText(s.getMobile_phone());
			c.mobilephonetv = tv;

			tv = (TextView) view.findViewById(R.id.addressTV);
			tv.setText(s.getAddress());
			c.addresstv = tv;
			view.setTag(c);
		} else {
			view = convertView;
			efficiency c = (efficiency)view.getTag();
			tv = c.idtv;
			tv.setText(s.getId() + "");
			
			tv = c.nametv;
			tv.setText(s.getName());

			tv = c.sextv;
			tv.setText(s.getSex());
			

			tv = c.birthtv;
			tv.setText(s.getBirth());
			

			tv = c.mobilephonetv;
			tv.setText(s.getMobile_phone());
		

			tv = c.addresstv;
			tv.setText(s.getAddress());
		}
		return view;
	}
	class efficiency{
		TextView idtv,nametv,sextv,birthtv,mobilephonetv,addresstv;
	}
}
