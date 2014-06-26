package com.org.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BigBankDBOpenHelper extends SQLiteOpenHelper {

	private static final String DB_NAME = "BigBank";
	private static final int DB_VERSION = 1;

	public BigBankDBOpenHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		// 支出表pay
		db.execSQL("CREATE TABLE pay (pay_id INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "add_type VARCHER(30),"
				+ "add_money VARCHER(20),"
				+ "add_type_spinner VARCHER(30),"
				+ "add_account_spinner VARCHER(30),"
				+ "add_date_txt VARCHER(30),"
				+ "add_member_spinner VARCHER(30),"
				+ "add_project_spinner VARCHER(30),"
				+ "add_place_spinner VARCHER(30),"
				+ "add_tip_but VARCHER(200))");

		// 收入表income
		db.execSQL("CREATE TABLE income (income_id INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "add_type VARCHER(30),"
				+ "add_money VARCHER(20),"
				+ "add_type_spinner VARCHER(30),"
				+ "add_account_spinner VARCHER(30),"
				+ "add_date_txt VARCHER(30),"
				+ "add_member_spinner VARCHER(30),"
				+ "add_project_spinner VARCHER(30),"
				+ "add_place_spinner VARCHER(30),"
				+ "add_tip_but VARCHER(200))");

		// 转账表transfer
		db.execSQL("CREATE TABLE transfer (transfer_id INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "add_type VARCHER(30),"
				+ "add_transfer_account_left VARCHER(30),"
				+ "add_transfer_account_right VARCHER(30),"
				+ "add_money VARCHER(20),"
				+ "add_date_txt VARCHER(30),"
				+ "add_member_spinner VARCHER(30),"
				+ "add_project_spinner VARCHER(30),"
				+ "add_place_spinner VARCHER(30),"
				+ "add_tip_but VARCHER(200))");

		// 退款表refund
		db.execSQL("CREATE TABLE refund (refund_id INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "add_type VARCHER(30),"
				+ "add_money VARCHER(20),"
				+ "add_type_spinner VARCHER(30),"
				+ "add_account_spinner VARCHER(30),"
				+ "add_date_txt VARCHER(30),"
				+ "add_member_spinner VARCHER(30),"
				+ "add_project_spinner VARCHER(30),"
				+ "add_place_spinner VARCHER(30),"
				+ "add_tip_but VARCHER(200))");
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

}
