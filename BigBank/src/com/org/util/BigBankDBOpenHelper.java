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
		// ֧����pay
		db.execSQL("CREATE TABLE pay (pay_id INTEGER PRIMARY KEY AUTOINCREMENT,"		//֧��id,����
				+ "add_type VARCHER(30),"   //֧������
				+ "add_money VARCHER(20),"		//���
				+ "add_type_spinner VARCHER(30),"		//һ�����
				+ "add_account_spinner VARCHER(30),"		//֧���˻�
				+ "add_date_txt VARCHER(30),"		//�˵�ʱ��
				+ "add_member_spinner VARCHER(30),"		//��Ա
				+ "add_project_spinner VARCHER(30),"		//��Ŀ���
				+ "add_place_spinner VARCHER(30),"		//֧���ص�
				+ "add_tip_but VARCHER(200))");		//��ע
		
		// �����income
		db.execSQL("CREATE TABLE income (income_id INTEGER PRIMARY KEY AUTOINCREMENT,"		//����id,����
				+ "add_type VARCHER(30),"		//��������
				+ "add_money VARCHER(20),"		//���
				+ "add_type_spinner VARCHER(30),"		//һ�����
				+ "add_account_spinner VARCHER(30),"		//�����˻�
				+ "add_date_txt VARCHER(30),"		//�˵�ʱ��
				+ "add_member_spinner VARCHER(30),"		//��Ա
				+ "add_project_spinner VARCHER(30),"		//��Ŀ���
				+ "add_place_spinner VARCHER(30),"		//����ص�
				+ "add_tip_but VARCHER(200))");		//��ע

		// ת�˱�transfer
		db.execSQL("CREATE TABLE transfer (transfer_id INTEGER PRIMARY KEY AUTOINCREMENT,"		//ת��id,����
				+ "add_type VARCHER(30),"		//ת�����
				+ "add_transfer_account_left VARCHER(30),"		//ת���˻�
				+ "add_transfer_account_right VARCHER(30),"		//ת���˻�
				+ "add_money VARCHER(20),"		//���
				+ "add_date_txt VARCHER(30),"		//�˵�ʱ��
				+ "add_member_spinner VARCHER(30),"		//��Ա
				+ "add_project_spinner VARCHER(30),"		//ת����Ŀ
				+ "add_place_spinner VARCHER(30),"		//�̼�
				+ "add_tip_but VARCHER(200))");		//��ע

		// �˿��refund
		db.execSQL("CREATE TABLE refund (refund_id INTEGER PRIMARY KEY AUTOINCREMENT,"		//�˿�id,����
				+ "add_type VARCHER(30),"		//�˿�����
				+ "add_money VARCHER(20),"		//���	
				+ "add_type_spinner VARCHER(30),"		//һ�����
				+ "add_account_spinner VARCHER(30),"		//�˿��˻�
				+ "add_date_txt VARCHER(30),"		//�˵�����
				+ "add_member_spinner VARCHER(30),"		//��Ա
				+ "add_project_spinner VARCHER(30),"		//��Ŀ
				+ "add_place_spinner VARCHER(30),"		//�ص�
				+ "add_tip_but VARCHER(200))");		//��ע
		
		//�����type_table
		db.execSQL("CREAT TABLE type_table (type_id INTEGER PRIMARY KEY AUTOINCREMENT,"		//����id,����
				+ "type_Name VARCHER(50),"		//��������
				+ "type_Father VARCHER(20)");		//����ID
		
		//����Ĭ��һ������
		db.execSQL("INSERT INTO type_table VALUES('�·���Ʒ',null)");
		db.execSQL("INSERT INTO type_table VALUES('ʳƷ��ˮ',null)");
		db.execSQL("INSERT INTO type_table VALUES('�Ӽ���ҵ',null)");
		db.execSQL("INSERT INTO type_table VALUES('�г���ͨ',null)");
		db.execSQL("INSERT INTO type_table VALUES('����ͨѶ',null)");
		db.execSQL("INSERT INTO type_table VALUES('��������',null)");
		db.execSQL("INSERT INTO type_table VALUES('ѧϰ����',null)");
		db.execSQL("INSERT INTO type_table VALUES('��������',null)");
		db.execSQL("INSERT INTO type_table VALUES('ҽ�Ʊ���',null)");
		db.execSQL("INSERT INTO type_table VALUES('��������',null)");
		
		//Ĭ�϶�������
		db.execSQL("INSERT INTO type_table VALUES('�·�����',1)");
		db.execSQL("INSERT INTO type_table VALUES('Ьñ����',1)");
		db.execSQL("INSERT INTO type_table VALUES('��ױ��Ʒ',1)");
		db.execSQL("INSERT INTO type_table VALUES('�������',2)");
		db.execSQL("INSERT INTO type_table VALUES('�̾Ʋ�',2)");
		db.execSQL("INSERT INTO type_table VALUES('ˮ����ʳ',2)");
		db.execSQL("INSERT INTO type_table VALUES('�ճ���Ʒ',3)");
		db.execSQL("INSERT INTO type_table VALUES('ˮ��ú��',3)");
		db.execSQL("INSERT INTO type_table VALUES('����',3)");
		db.execSQL("INSERT INTO type_table VALUES('��ҵ����',3)");
		db.execSQL("INSERT INTO type_table VALUES('ά�ޱ���',3)");
		db.execSQL("INSERT INTO type_table VALUES('�·���Ʒ',null)");
		//�˻���account_table
		db.execSQL("CREAT TABLE account_table (account_id INTEGER PRIMARY KEY AUTOINCREMENT,"		//�˻�id,����
				+ "account_Name VARCHER(50),"		//�˻�����
				+ "account_Father VARCHER(20)");		//����ID
		
		//��Ա��member_table
		db.execSQL("CREAT TABLE member_table (member_id INTEGER PRIMARY KEY AUTOINCREMENT,"		//��Աid,����
				+ "member_Name VARCHER(50)");		//��Ա����		
		
		//��Ŀ��project_table
		db.execSQL("CREAT TABLE project_table (project_id INTEGER PRIMARY KEY AUTOINCREMENT,"		//��Ŀid,����
				+ "project_Name VARCHER(50),"		//��Ŀ����
				+ "project_Father VARCHER(20)");		//����ID
		
		//�ص��place_table
		db.execSQL("CREAT TABLE place_table (place_id INTEGER PRIMARY KEY AUTOINCREMENT,"		//�ص�id,����
				+ "place_Name VARCHER(50),"		//�ص�����
				+ "place_Father VARCHER(20)");		//����ID
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

}
