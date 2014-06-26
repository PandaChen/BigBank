package com.org.util;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class MyAdapter extends SimpleAdapter {
	private int[] mTo;
	private String[] mFrom;
	private List<? extends Map<String, ?>> mData;
	private int mResource;
	private LayoutInflater mInflater;

	public MyAdapter(Context context, List<? extends Map<String, ?>> data,
			int resource, String[] from, int[] to) {
		super(context, data, resource, from, to);
		mData = data;
		mResource = resource;
		mFrom = from;
		mTo = to;
		mInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		View v;
		v = mInflater.inflate(mResource, parent, false);
		final Map<String, ?> dataSet = mData.get(position);
		if (dataSet == null) {
			return null;
		}
		for (int i = 0; i < mTo.length; i++) {
			View vi = v.findViewById(mTo[i]);	
				((TextView) vi).setText(dataSet.get(mFrom[i]).toString());
		}
		return v;
	}
};
