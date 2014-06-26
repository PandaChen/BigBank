package com.org.lxh;

import java.util.Calendar;

import com.org.common.BigBankDate;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{

	private Button nav_details_year;	//账单
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
		
		//再记一笔
		add_new = (Button) this.findViewById(R.id.add_new);
		add_new.setOnClickListener(this);

		//账单
		nav_details_year = (Button) this.findViewById(R.id.nav_details_year);
		nav_details_year.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		//再记一笔
		case R.id.add_new:
			Intent add_new = new Intent(this,add_pay_Activity.class);
			this.startActivity(add_new);
			break;
		//账单
		case R.id.nav_details_year:
			Intent nav_details_year = new Intent(this,detail_list_Activity.class);
			this.startActivity(nav_details_year);
		}		
	}
	
}
