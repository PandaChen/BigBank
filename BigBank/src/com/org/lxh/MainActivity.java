package com.org.lxh;

import java.util.Calendar;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity{

	Button nav_details_year;	//账单
	private Button add_new;
	private TextView main_month;
	private TextView main_year;
	private TextView main_today;
	private TextView main_today_date;
	private TextView main_week;
	private TextView main_month_date;
	private Calendar calendar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		calendar = Calendar.getInstance();
        main_month = (TextView)this.findViewById(R.id.main_top_month);
        main_year = (TextView)this.findViewById(R.id.main_top_year);
        main_today = (TextView)this.findViewById(R.id.main_today_date);
        main_today_date = (TextView)this.findViewById(R.id.main_today_img);
        main_week = (TextView)this.findViewById(R.id.main_week_date);
        main_month_date = (TextView)this.findViewById(R.id.main_month_date);
        add_new = (Button)this.findViewById(R.id.add_new);

        main_month.setText(""+(calendar.get(Calendar.MONTH)+1));
        main_year.setText("/"+calendar.get(Calendar.YEAR));
        main_today.setText((calendar.get(Calendar.YEAR))+"年"+(calendar.get(Calendar.MONTH)+1)+"月"+(calendar.get(Calendar.DAY_OF_MONTH))+"日");
        main_today_date.setText(""+calendar.get(Calendar.DAY_OF_MONTH));
        new BigBankDate();
		main_week.setText(BigBankDate.getSundayOfThisWeek()+"-"+BigBankDate.getSaturdayOfThisWeek());
        main_month_date.setText(BigBankDate.getFistDayOfMonth()+"-"+BigBankDate.getLastDayOfMonth());
		
		//再记一笔监听
		add_new = (Button) this.findViewById(R.id.add_new);
		add_new.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(arg0.getContext(),add_pay_Activity.class);
				arg0.getContext().startActivity(i);
			}
		});
		//账单监听
		nav_details_year = (Button) this.findViewById(R.id.nav_details_year);
		nav_details_year.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(arg0.getContext(),detail_list_Activity.class);
				arg0.getContext().startActivity(i);
			}
		});
		
	}
	
}
