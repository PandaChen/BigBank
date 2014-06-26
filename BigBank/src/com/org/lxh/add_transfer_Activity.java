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

public class add_transfer_Activity extends Activity implements OnClickListener {
	private Button but_back; // ����
	private Spinner add_type; // ��������(֧�������롢ת�ˡ��˿�)
	private Button but_save; // ����
	private Spinner add_transfer_account_left; // ת���˻���
	private Spinner add_transfer_account_right; // ת���˻���
	@SuppressWarnings("unused")
	private Button but_camera; // ���
	private EditText add_money; // ���
	private TextView add_date_txt; // ����
	private Spinner add_member_spinner; // ��Ա
	private Spinner add_project_spinner; // ��Ŀ
	private Spinner add_place_spinner; // �̼ҡ��ص�
	private Button add_tip_but; // ��ע
	private Button butSave; // ����
	private Button butAgain; // �ټ�һ��

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_transfer);

		// ���ء�
		but_back = (Button) this.findViewById(R.id.but_back);
		but_back.setOnClickListener(this);

		// ����������������ͼ���
		add_type = (Spinner) findViewById(R.id.add_type);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.add_type, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		add_type.setAdapter(adapter);
		add_type.setSelection(2, true);

		add_type.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				// ����֧��
				if (arg2 == 0) {
					Intent i = new Intent(arg0.getContext(),
							add_pay_Activity.class);
					arg0.getContext().startActivity(i);
					// ��������
				} else if (arg2 == 1) {
					Intent i = new Intent(arg0.getContext(),
							add_income_Activity.class);
					arg0.getContext().startActivity(i);
					// �����˿�
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

		// ��� ���̱��桱
		but_save = (Button) this.findViewById(R.id.but_save);
		but_save.setOnClickListener(this);

		// �����ע
		add_tip_but = (Button) this.findViewById(R.id.add_tip_but);
		add_tip_but.setOnClickListener(this);

		// ��������桱
		butSave = (Button) this.findViewById(R.id.butSave);
		butSave.setOnClickListener(this);

		// ����ټ�һ��
		butAgain = (Button) this.findViewById(R.id.butAgain);
		butAgain.setOnClickListener(this);
	}

	// ����tips_Activity������
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

	// ��������
	public void saveData() {
		add_type = (Spinner) this.findViewById(R.id.add_type);
		// but_camera = (Button)this.findViewById(R.id.but_camera);
		add_money = (EditText) this.findViewById(R.id.add_money);
		add_transfer_account_left = (Spinner) this
				.findViewById(R.id.add_transfer_account_left);
		add_transfer_account_right = (Spinner) this
				.findViewById(R.id.add_transfer_account_right);
		add_date_txt = (TextView) this.findViewById(R.id.add_date_txt);
		add_member_spinner = (Spinner) this
				.findViewById(R.id.add_member_spinner);
		add_project_spinner = (Spinner) this
				.findViewById(R.id.add_project_spinner);
		add_place_spinner = (Spinner) this.findViewById(R.id.add_place_spinner);
		add_tip_but = (Button) this.findViewById(R.id.add_tip_but);

		String add_type1 = add_type.getSelectedItem().toString();
		String add_money1 = add_money.getText().toString();
		String add_transfer_account_left1 = add_transfer_account_left
				.getSelectedItem().toString();
		String add_transfer_account_right1 = add_transfer_account_right
				.getSelectedItem().toString();
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
				"INSERT INTO transfer(transfer_id,add_type,add_transfer_account_left,add_transfer_account_right,add_money,add_date_txt,add_member_spinner,add_project_spinner,add_place_spinner,add_tip_but) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
				new Object[] { null, add_type1, add_transfer_account_left1,
						add_transfer_account_right1, add_money1, add_date_txt1,
						add_member_spinner1, add_project_spinner1,
						add_place_spinner1, add_tip_but1 });
		db.close();
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		// ���ء�
		case R.id.but_back:
			Intent but_back = new Intent(this, MainActivity.class);
			this.startActivity(but_back);
			break;
		// �̱���
		case R.id.but_save:
			saveData();
			// ����ɹ��󷵻�������
			Intent but_save = new Intent(this, MainActivity.class);
			this.startActivity(but_save);
			break;
		// �����ע
		case R.id.add_tip_but:
			Intent tip_but = new Intent(this, tips_Activity.class);
			String tips = add_tip_but.getText().toString();
			tip_but.putExtra("tips", tips);
			startActivityForResult(tip_but, 0);
			break;
		// ����
		case R.id.butSave:
			saveData();
			// ����ɹ��󷵻�������
			Intent butSave = new Intent(this, MainActivity.class);
			this.startActivity(butSave);
			break;
		// �ټ�һ��
		case R.id.butAgain:
			saveData();
			// ����ɹ���,ˢ�±�ҳ��
			Intent butAgain = new Intent(this, add_pay_Activity.class);
			this.startActivity(butAgain);
			break;
		}
	}
}
