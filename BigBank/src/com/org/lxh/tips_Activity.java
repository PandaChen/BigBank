package com.org.lxh;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class tips_Activity extends Activity implements OnClickListener {
	Button but_back_tips;
	Button but_save;
	EditText tips_edit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tips);

		// 显示原有的tips
		tips_edit = (EditText) findViewById(R.id.tips_edit);
		String tips = getIntent().getStringExtra("tips");
		tips_edit.setText(tips.toString());

		// 点击〈
		but_back_tips = (Button) this.findViewById(R.id.but_back_tips);
		but_back_tips.setOnClickListener(this);

		// 点击保存
		but_save = (Button) this.findViewById(R.id.but_save);
		but_save.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.but_back_tips:
			new AlertDialog.Builder(this)
					.setTitle("温馨提示")
					.setMessage("您已输入了备注内容，确定要放弃吗？")
					.setPositiveButton("确定",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int which) {
									Intent i = new Intent();
									i.setClass(tips_Activity.this,
											add_pay_Activity.class);
									tips_Activity.this.startActivity(i);
								}
							}).setNegativeButton("取消", null).show();
			break;
		case R.id.but_save:
			Intent i = new Intent(this, add_pay_Activity.class);
			Bundle b = new Bundle();
			b.putString("txt", tips_edit.getText().toString());
			i.putExtras(b);
			tips_Activity.this.setResult(RESULT_OK, i);
			finish();
			break;
		}
	}
}
