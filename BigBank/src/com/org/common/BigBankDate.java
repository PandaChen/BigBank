package com.org.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import com.org.lxh.R;
import com.org.lxh.R.id;
import com.org.lxh.R.layout;

import kankan.wheel.widget.OnWheelChangedListener;
import kankan.wheel.widget.WheelView;
import kankan.wheel.widget.adapters.ArrayWheelAdapter;
import kankan.wheel.widget.adapters.NumericWheelAdapter;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BigBankDate {
	/**
	 * 账单默认日期
	 */
	public static String setBillDefaultDate() {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm", Locale.getDefault());
		return simpleDateFormat.format(date);
	}

	/**
	 * 获取周六
	 */
	public static String getSaturdayOfThisWeek() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("MM月dd日",
				Locale.getDefault());
		calendar.set(Calendar.DAY_OF_WEEK, 7);
		return df.format(calendar.getTime());
	}

	/**
	 * 以周日为一周开始
	 */
	public static String getSundayOfThisWeek() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("MM月dd日",
				Locale.getDefault());
		calendar.set(Calendar.DAY_OF_WEEK, 1);
		return df.format(calendar.getTime());
	}

	/**
	 * 获取当前月的第一天
	 */
	public static String getFistDayOfMonth() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("MM月dd日",
				Locale.getDefault());
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		return df.format(calendar.getTime());
	}

	/**
	 * 获取当前月的最后一天
	 */
	public static String getLastDayOfMonth() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("MM月dd日",
				Locale.getDefault());
		// System.out.println(calendar.getActualMaximum(Calendar.DATE));
		calendar.set(Calendar.DAY_OF_MONTH,
				calendar.getActualMaximum(Calendar.DATE));
		return df.format(calendar.getTime());
	}

	/**
	 * 日期时间选择
	 */
	public void choiceDate_Time(final Context context, final TextView dateView) {

		final Calendar calendar = Calendar.getInstance();
		View view = View.inflate(context, R.layout.date_time_layout, null);
		final WheelView yearWheel = (WheelView) view.findViewById(R.id.year);
		final WheelView monthWheel = (WheelView) view.findViewById(R.id.month);
		final WheelView dayWheel = (WheelView) view.findViewById(R.id.day);
		final WheelView hourWheel = (WheelView) view.findViewById(R.id.hour);
		final WheelView minsWheel = (WheelView) view.findViewById(R.id.mins);
		final StringBuffer sb = new StringBuffer();
		AlertDialog.Builder builder = new AlertDialog.Builder(context);

		OnWheelChangedListener listener = new OnWheelChangedListener() {

			@Override
			public void onChanged(WheelView wheel, int oldValue, int newValue) {
				// TODO Auto-generated method stub
				updateDays(yearWheel, monthWheel, dayWheel, context);
			}

		};

		builder.setView(view);

		yearWheel.setViewAdapter(new DateNumericAdapter(context, calendar
				.get(Calendar.YEAR) - 2, calendar.get(Calendar.YEAR) + 10,
				calendar.get(Calendar.YEAR)));
		yearWheel.setCurrentItem(calendar.get(Calendar.YEAR)+2);
		yearWheel.setCyclic(true);
		yearWheel.addChangingListener(listener);

		final String months[] = new String[] { "1", "2", "3", "4", "5", "6",
				"7", "8", "9", "10", "11", "12" };
		monthWheel.setViewAdapter(new DateArrayAdapter(context, months,
				calendar.get(Calendar.MONTH)));
		monthWheel.setCurrentItem(calendar.get(Calendar.MONTH));
		monthWheel.setCyclic(true);
		monthWheel.addChangingListener(listener);

		updateDays(yearWheel, monthWheel, dayWheel, context);
		//dayWheel.setCurrentItem(calendar.get(Calendar.DAY_OF_MONTH) - 1);
		dayWheel.setCyclic(true);

		NumericWheelAdapter hourAdapter = new NumericWheelAdapter(context, 0,
				23);
		hourWheel.setViewAdapter(hourAdapter);
		hourWheel.setCurrentItem(calendar.get(Calendar.HOUR_OF_DAY));
		hourWheel.setCyclic(true);

		NumericWheelAdapter minAdapter = new NumericWheelAdapter(context, 0, 59);
		minsWheel.setViewAdapter(minAdapter);
		minsWheel.setCurrentItem(calendar.get(Calendar.MINUTE));
		minsWheel.setCyclic(true);

		builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				sb.append(
						(calendar.get(Calendar.YEAR) + yearWheel
								.getCurrentItem()) - 2).append("-")
						.append(months[monthWheel.getCurrentItem()])
						.append("-").append(dayWheel.getCurrentItem() + 1);

				sb.append(" ");
				sb.append(hourWheel.getCurrentItem()).append(":")
						.append(minsWheel.getCurrentItem());

				dateView.setText(sb.toString());

				dialog.cancel();
			}
		});
		builder.show();

	}

	/**
	 * 根据选择的年月，更新日期
	 */
	protected void updateDays(WheelView yearWheel, WheelView monthWheel,
			WheelView dayWheel, Context context) {
		// TODO Auto-generated method stub
		Calendar calendar2 = Calendar.getInstance();
		calendar2.set(Calendar.YEAR,
				calendar2.get(Calendar.YEAR) + yearWheel.getCurrentItem());
		calendar2.set(Calendar.MONTH, monthWheel.getCurrentItem());

		int maxDays = calendar2.getActualMaximum(Calendar.DAY_OF_MONTH);
		dayWheel.setViewAdapter(new DateNumericAdapter(context, 1, maxDays,
				calendar2.get(Calendar.DAY_OF_MONTH) - 1));
		/*
		 * 
		int curDay = Math.min(maxDays, dayWheel.getCurrentItem() + 1);
		dayWheel.setCurrentItem(curDay - 1, true);
		
		*/
	}

	/**
	 * 日期滚筒适配器
	 */
	private class DateNumericAdapter extends NumericWheelAdapter {
		// Index of current item
		int currentItem;
		// Index of item to be highlighted
		int currentValue;

		/**
		 * Constructor
		 */
		public DateNumericAdapter(Context context, int minValue, int maxValue,
				int current) {
			super(context, minValue, maxValue);
			this.currentValue = current;
			setTextSize(22);
		}
	}

	/**
	 * 月份滚筒适配器
	 */
	private class DateArrayAdapter extends ArrayWheelAdapter<String> {
		// Index of current item
		int currentItem;
		// Index of item to be highlighted
		int currentValue;

		/**
		 * Constructor
		 */
		public DateArrayAdapter(Context context, String[] items, int current) {
			super(context, items);
			this.currentValue = current;
			setTextSize(22);
		}

		@Override
		protected void configureTextView(TextView view) {
			super.configureTextView(view);
			view.setTypeface(Typeface.SANS_SERIF);
		}

		@Override
		public View getItem(int index, View cachedView, ViewGroup parent) {
			currentItem = index;
			return super.getItem(index, cachedView, parent);
		}
	}
}
