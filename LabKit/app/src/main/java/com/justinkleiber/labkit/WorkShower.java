package com.justinkleiber.labkit;


import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

public class WorkShower extends Activity{

	LinearLayout scroller;
	int leng;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.workshow);
		
		//scroller=(LinearLayout) findViewById(R.id.llWork);
		LayoutParams lp = new LayoutParams( LayoutParams.MATCH_PARENT,    LayoutParams.WRAP_CONTENT);
		Bundle extras = getIntent().getExtras();
		String[] workStrings = extras.getStringArray("workstr");
		
		leng = workStrings.length;
		TextView[] lostexts = new TextView[leng];

		for(int i=0;i<leng;i++)
		{
			lostexts[i] = new TextView(this);
			lostexts[i].setText(workStrings[i]);
			lostexts[i].setLayoutParams(lp);
			lostexts[i].setId(i);
			lostexts[i].setTextSize(18);
			scroller.addView(lostexts[i]);
		}
	}

}
