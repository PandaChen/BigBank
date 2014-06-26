package com.org.lxh;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class budget_Activity extends Activity implements OnClickListener{
	
	private ImageButton but_back;	//·µ»Ø

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.budget);
		
		//·µ»Ø
		but_back = (ImageButton)this.findViewById(R.id.but_back);
		but_back.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		//·µ»Ø
		case R.id.but_back:
			Intent but_back = new Intent(this,MainActivity.class);
			this.startActivity(but_back);
			break;
		}
		
	}

}
