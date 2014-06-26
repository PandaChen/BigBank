package com.org.lxh;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;


import com.org.util.BigBankDBOpenHelper;
import com.org.util.MyAdapter;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

public class detail_list_Activity extends Activity implements OnClickListener{
	private BigBankDBOpenHelper uioh;
	private SQLiteDatabase db;
	private Cursor cursor;
	private ImageButton but_back;	//����
	private TextView details_header_date_txt;	//���
	@SuppressWarnings("unused")
	private ImageButton details_header_time_icon;	//ʱ��
	private ImageButton but_add;	//����
	private ListView detail_list;
	private MyAdapter adapter;
	private ArrayList<HashMap<String, Object>> items;
	private Calendar calendar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail_list);
		
		calendar = Calendar.getInstance();
		
		//����
		but_back = (ImageButton)this.findViewById(R.id.but_back);
		but_back.setOnClickListener(this);
		
		//���
		details_header_date_txt = (TextView)this.findViewById(R.id.details_header_date_txt);
		System.out.println(calendar.get(Calendar.YEAR));
		details_header_date_txt.setText(""+calendar.get(Calendar.YEAR));
		//ʱ��
		details_header_time_icon = (ImageButton)this.findViewById(R.id.details_header_time_icon);
		
		//����
		but_add = (ImageButton)this.findViewById(R.id.but_add);
		but_add.setOnClickListener(this);
		
		//�˵�
		detail_list = (ListView)this.findViewById(R.id.detail_list);
		
		uioh = new BigBankDBOpenHelper(this);
		db = uioh.getWritableDatabase();
		items = new ArrayList<HashMap<String, Object>>();
		// ��ѯ�������ݣ�listview��ʾ
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
		// ����:Context,ArrayList(item�ļ���),item��layout,
		// ����ArrayList��Hashmap��key������,key����Ӧ��ֵ���Ӧ�Ŀؼ�id
		detail_list.setAdapter(adapter);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.but_back:
			Intent but_back = new Intent(this, MainActivity.class);
			this.startActivity(but_back);
			break;
		case R.id.but_add:
			Intent but_add = new Intent(this, add_pay_Activity.class);
			this.startActivity(but_add);
			break;
		}
	}
}
