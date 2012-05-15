package com.android.MyAdapters;

import java.util.ArrayList;
import java.util.zip.Inflater;

import com.android.ListViewApplication.R;
import com.android.MyClasses.InfoClass;

import android.app.Activity;
import android.content.Context;
import android.sax.RootElement;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyAdapter extends ArrayAdapter<InfoClass> 
{
	Activity context;
	ArrayList<InfoClass> arrayInfo;

	public MyAdapter(Activity context, ArrayList<InfoClass> arrayInfo) {
		super(context,R.layout.list_item,R.id.text,arrayInfo);
		this.context=context;
		this.arrayInfo=arrayInfo;
	}


	@Override
	public int getCount() {
		return arrayInfo.size();
	}

	@Override
	public InfoClass getItem(int position) {
		
		return arrayInfo.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}


	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LinearLayout layout=null;
		TextView text;
		
		InfoClass info=arrayInfo.get(position);
		if(layout==null){
			LayoutInflater inflater=context.getLayoutInflater();
			layout=(LinearLayout)inflater.inflate(R.layout.list_item,null);
		}
		else {
			layout=(LinearLayout)convertView;
		}
		text=(TextView)layout.findViewById(R.id.text);
		text.setText(info.getiName()+"\t"+info.getiAge());
		
		
		return layout;
	}


}
