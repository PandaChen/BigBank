package com.org.lxh;

import java.util.ArrayList;
import java.util.HashMap;


import com.org.util.BigBankDBOpenHelper;
import com.org.util.MyAdapter;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

public class detail_list_Activity extends Activity{
	private BigBankDBOpenHelper uioh;
	private SQLiteDatabase db;
	private Cursor cursor;
	private ListView detail_list;
	private MyAdapter adapter;
	private ArrayList<HashMap<String, Object>> items;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail_list);
		
		detail_list = (ListView)this.findViewById(R.id.detail_list);
		
		uioh = new BigBankDBOpenHelper(this);
		db = uioh.getWritableDatabase();
		items = new ArrayList<HashMap<String, Object>>();
		// 查询所有数据，listview显示
		String sql = "SELECT * FROM pay where pay.pay_id=1 union all select * from income where income.income_id=1 union all select * from refund where refund.refund_id=1";
		cursor = db.rawQuery(sql, null);
		while (cursor.moveToNext()) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("show_pay_id", cursor.getString(0));
			map.put("show_type", cursor.getString(1));
			map.put("show_money", cursor.getString(2));
			map.put("show_type_spinner", cursor.getString(3));
			items.add(map);
		}
		adapter = new MyAdapter(this, items, R.layout.detail_item, new String[] {
				"show_type_spinner", "show_type" ,"show_money"}, new int[] {
				R.id.details_secondary_1, R.id.details_primary_1, R.id.details_money_sum_1 });
		// 参数:Context,ArrayList(item的集合),item的layout,
		// 包含ArrayList中Hashmap的key的数组,key所对应的值相对应的控件id
		detail_list.setAdapter(adapter);
	}

}
