package com.org.lxh;

import com.org.util.BigBankDBOpenHelper;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

public class add_income_Activity extends Activity {
	Button but_back; // 返回
	Spinner add_type; // 新增类型(支出、收入、转账、退款)
	Button but_save; // 保存
	Button but_camera; // 相机
	EditText add_money; // 金额
	Spinner add_type_spinner; // 具体类型
	Spinner add_account_spinner; // 账户类型
	TextView add_date_txt; // 日期
	//1234
	Spinner add_member_spinner; // 成员
	Spinner add_project_spinner; // 项目
	Spinner add_place_spinner; // 商家、地点
	Button add_tip_but; // 备注
	Button butSave; // 保存
	Button butAgain; // 再记一笔

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add);

		// 返回《监听
		but_back = (Button) this.findViewById(R.id.but_back);
		but_back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(arg0.getContext(), MainActivity.class);
				arg0.getContext().startActivity(i);
			}
		});

		// 新增类型与具体类型监听
		add_type = (Spinner) findViewById(R.id.add_type);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.add_type, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		add_type.setAdapter(adapter);
		add_type.setSelection(1, false);
		add_type.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				// 新增支出
				if (arg2 == 0) {
					Intent i = new Intent(arg0.getContext(),
							add_pay_Activity.class);
					arg0.getContext().startActivity(i);
					// 新增转账
				} else if (arg2 == 2) {
					Intent i = new Intent(arg0.getContext(),
							add_transfer_Activity.class);
					arg0.getContext().startActivity(i);
					// 新增退款
				} else if (arg2 == 3) {
					Intent i = new Intent(arg0.getContext(),
							add_refund_Activity.class);
					arg0.getContext().startActivity(i);
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});

		// 设置收入具体类型
		add_type_spinner = (Spinner) findViewById(R.id.add_type_spinner);
		ArrayAdapter<CharSequence> adapter2 = ArrayAdapter
				.createFromResource(this, R.array.income_type,
						android.R.layout.simple_spinner_item);
		adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		add_type_spinner.setAdapter(adapter2);

		// 点击备注，跳转tips_Activity完成信息填写
		add_tip_but = (Button) this.findViewById(R.id.add_tip_but);
		add_tip_but.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(arg0.getContext(), tips_Activity.class);
				String tips = add_tip_but.getText().toString();
				i.putExtra("tips", tips);
				startActivityForResult(i, 0);
			}

		});

		// 点击 “√保存”
		but_save = (Button) this.findViewById(R.id.but_save);
		but_save.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				saveData();
				// 保存成功后返回主界面
				Intent i = new Intent(arg0.getContext(), MainActivity.class);
				arg0.getContext().startActivity(i);
			}
		});

		// 点击“保存”
		butSave = (Button) this.findViewById(R.id.butSave);
		butSave.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				saveData();
				// 保存成功后返回主界面
				Intent i = new Intent(arg0.getContext(), MainActivity.class);
				arg0.getContext().startActivity(i);
			}
		});

		// 点击再记一笔
		butAgain = (Button) this.findViewById(R.id.butAgain);
		butAgain.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				// 保存数据
				saveData();
				// 保存成功后,清空本页面
				Intent i = new Intent(arg0.getContext(), add_pay_Activity.class);
				arg0.getContext().startActivity(i);
			}
		});
	}

	// 返回tips_Activity的数据
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		switch (resultCode) {
		case RESULT_OK:
			Bundle b = data.getExtras();
			String txt = b.getString("txt");
			add_tip_but.setText(txt);
			break;
		default:
			break;
		}
	}

	// 保存数据
	public void saveData() {
		add_type = (Spinner) this.findViewById(R.id.add_type);
		// but_camera = (Button)this.findViewById(R.id.but_camera);
		add_money = (EditText) this.findViewById(R.id.add_money);
		add_type_spinner = (Spinner) this.findViewById(R.id.add_type_spinner);
		add_account_spinner = (Spinner) this
				.findViewById(R.id.add_account_spinner);
		add_date_txt = (TextView) this.findViewById(R.id.add_date_txt);
		add_member_spinner = (Spinner) this
				.findViewById(R.id.add_member_spinner);
		add_project_spinner = (Spinner) this
				.findViewById(R.id.add_project_spinner);
		add_place_spinner = (Spinner) this.findViewById(R.id.add_place_spinner);
		add_tip_but = (Button) this.findViewById(R.id.add_tip_but);

		String add_type1 = add_type.getSelectedItem().toString();
		String add_money1 = add_money.getText().toString();
		String add_type_spinner1 = add_type_spinner.getSelectedItem()
				.toString();
		String add_account_spinner1 = add_account_spinner.getSelectedItem()
				.toString();
		String add_date_txt1 = add_date_txt.getText().toString();
		String add_member_spinner1 = add_member_spinner.getSelectedItem()
				.toString();
		String add_project_spinner1 = add_project_spinner.getSelectedItem()
				.toString();
		String add_place_spinner1 = add_place_spinner.getSelectedItem()
				.toString();
		String add_tip_but1 = add_tip_but.getText().toString();

		BigBankDBOpenHelper bboh = new BigBankDBOpenHelper(this);
		SQLiteDatabase db = bboh.getWritableDatabase();
		db.execSQL(
				"INSERT INTO income(income_id,add_type,add_money,add_type_spinner,add_account_spinner,add_date_txt,add_member_spinner,add_project_spinner,add_place_spinner,add_tip_but) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
				new Object[] { null, add_type1, add_money1, add_type_spinner1,
						add_account_spinner1, add_date_txt1,
						add_member_spinner1, add_project_spinner1,
						add_place_spinner1, add_tip_but1 });
		db.close();
	}
}
