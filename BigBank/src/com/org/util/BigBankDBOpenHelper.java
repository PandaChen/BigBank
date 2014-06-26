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
		db.execSQL("CREATE TABLE pay (pay_id INTEGER PRIMARY KEY AUTOINCREMENT,"		//支出id,自增
				+ "add_type VARCHER(30),"   //支出种类
				+ "add_money VARCHER(20),"		//金额
				+ "add_type_spinner VARCHER(30),"		//一级类别
				+ "add_account_spinner VARCHER(30),"		//支出账户
				+ "add_date_txt VARCHER(30),"		//账单时间
				+ "add_member_spinner VARCHER(30),"		//成员
				+ "add_project_spinner VARCHER(30),"		//项目类别
				+ "add_place_spinner VARCHER(30),"		//支出地点
				+ "add_tip_but VARCHER(200))");		//备注
		
		// 收入表income
		db.execSQL("CREATE TABLE income (income_id INTEGER PRIMARY KEY AUTOINCREMENT,"		//收入id,自增
				+ "add_type VARCHER(30),"		//收入种类
				+ "add_money VARCHER(20),"		//金额
				+ "add_type_spinner VARCHER(30),"		//一级类别
				+ "add_account_spinner VARCHER(30),"		//收入账户
				+ "add_date_txt VARCHER(30),"		//账单时间
				+ "add_member_spinner VARCHER(30),"		//成员
				+ "add_project_spinner VARCHER(30),"		//项目类别
				+ "add_place_spinner VARCHER(30),"		//收入地点
				+ "add_tip_but VARCHER(200))");		//备注

		// 转账表transfer
		db.execSQL("CREATE TABLE transfer (transfer_id INTEGER PRIMARY KEY AUTOINCREMENT,"		//转账id,自增
				+ "add_type VARCHER(30),"		//转账类别
				+ "add_transfer_account_left VARCHER(30),"		//转出账户
				+ "add_transfer_account_right VARCHER(30),"		//转入账户
				+ "add_money VARCHER(20),"		//金额
				+ "add_date_txt VARCHER(30),"		//账单时间
				+ "add_member_spinner VARCHER(30),"		//成员
				+ "add_project_spinner VARCHER(30),"		//转账项目
				+ "add_place_spinner VARCHER(30),"		//商家
				+ "add_tip_but VARCHER(200))");		//备注

		// 退款表refund
		db.execSQL("CREATE TABLE refund (refund_id INTEGER PRIMARY KEY AUTOINCREMENT,"		//退款id,自增
				+ "add_type VARCHER(30),"		//退款种类
				+ "add_money VARCHER(20),"		//金额	
				+ "add_type_spinner VARCHER(30),"		//一级类别
				+ "add_account_spinner VARCHER(30),"		//退款账户
				+ "add_date_txt VARCHER(30),"		//账单日期
				+ "add_member_spinner VARCHER(30),"		//成员
				+ "add_project_spinner VARCHER(30),"		//项目
				+ "add_place_spinner VARCHER(30),"		//地点
				+ "add_tip_but VARCHER(200))");		//备注
		
		//种类表type_table
		db.execSQL("CREAT TABLE type_table (type_id INTEGER PRIMARY KEY AUTOINCREMENT,"		//种类id,自增
				+ "type_Name VARCHER(50),"		//种类名称
				+ "type_Father VARCHER(20)");		//父类ID
		
		//插入默认一级种类
		db.execSQL("INSERT INTO type_table VALUES('衣服饰品',null)");
		db.execSQL("INSERT INTO type_table VALUES('食品酒水',null)");
		db.execSQL("INSERT INTO type_table VALUES('居家物业',null)");
		db.execSQL("INSERT INTO type_table VALUES('行车交通',null)");
		db.execSQL("INSERT INTO type_table VALUES('交流通讯',null)");
		db.execSQL("INSERT INTO type_table VALUES('休闲娱乐',null)");
		db.execSQL("INSERT INTO type_table VALUES('学习进修',null)");
		db.execSQL("INSERT INTO type_table VALUES('人情往来',null)");
		db.execSQL("INSERT INTO type_table VALUES('医疗保健',null)");
		db.execSQL("INSERT INTO type_table VALUES('其他杂项',null)");
		
		//默认二级种类
		db.execSQL("INSERT INTO type_table VALUES('衣服裤子',1)");
		db.execSQL("INSERT INTO type_table VALUES('鞋帽宝宝',1)");
		db.execSQL("INSERT INTO type_table VALUES('化妆饰品',1)");
		db.execSQL("INSERT INTO type_table VALUES('早午晚餐',2)");
		db.execSQL("INSERT INTO type_table VALUES('烟酒茶',2)");
		db.execSQL("INSERT INTO type_table VALUES('水果零食',2)");
		db.execSQL("INSERT INTO type_table VALUES('日常用品',3)");
		db.execSQL("INSERT INTO type_table VALUES('水电煤气',3)");
		db.execSQL("INSERT INTO type_table VALUES('房租',3)");
		db.execSQL("INSERT INTO type_table VALUES('物业管理',3)");
		db.execSQL("INSERT INTO type_table VALUES('维修保养',3)");
		db.execSQL("INSERT INTO type_table VALUES('衣服饰品',null)");
		//账户表account_table
		db.execSQL("CREAT TABLE account_table (account_id INTEGER PRIMARY KEY AUTOINCREMENT,"		//账户id,自增
				+ "account_Name VARCHER(50),"		//账户名称
				+ "account_Father VARCHER(20)");		//父类ID
		
		//成员表member_table
		db.execSQL("CREAT TABLE member_table (member_id INTEGER PRIMARY KEY AUTOINCREMENT,"		//成员id,自增
				+ "member_Name VARCHER(50)");		//成员名称		
		
		//项目表project_table
		db.execSQL("CREAT TABLE project_table (project_id INTEGER PRIMARY KEY AUTOINCREMENT,"		//项目id,自增
				+ "project_Name VARCHER(50),"		//项目名称
				+ "project_Father VARCHER(20)");		//父类ID
		
		//地点表place_table
		db.execSQL("CREAT TABLE place_table (place_id INTEGER PRIMARY KEY AUTOINCREMENT,"		//地点id,自增
				+ "place_Name VARCHER(50),"		//地点名称
				+ "place_Father VARCHER(20)");		//父类ID
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

}
