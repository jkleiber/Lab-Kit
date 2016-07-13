package com.justinkleiber.labkit;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.InputType;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class SearchPeriodicTable extends Activity implements OnItemSelectedListener{

	int po;
	EditText search;
	Button s;
    boolean t;

    private boolean checkEmpty(EditText etText)
    {
        boolean x=true;
        if(etText.getText().toString().trim().length() > 0){
            x=true;
            return x;
        }
        else{
            x=false;
            return x;
        }
    }
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.periodic);
		
		search=(EditText) findViewById(R.id.searcher);
		
		Spinner g=(Spinner) findViewById(R.id.spinner1);
		g.setOnItemSelectedListener(this);
		ArrayAdapter<CharSequence> adapt = ArrayAdapter.createFromResource(this, R.array.tSelect, android.R.layout.simple_spinner_dropdown_item);
		adapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		g.setAdapter(adapt);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
		
		s=(Button) findViewById(R.id.bSearch);
		
		s.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
                t=checkEmpty(search);
                if(t) {
                    String str = search.getText().toString();
                    Bundle b = new Bundle();
                    b.putString("term", str);
                    b.putInt("type", po);
                    Intent elementIntent = new Intent("android.intent.action.EV");
                    elementIntent.putExtras(b);
                    startActivity(elementIntent);
                }
			}
		});
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View v, int pos,
			long id) {
		// TODO Auto-generated method stub
		if(pos==0)
		{
			search.setHint("Enter Atomic Number");
			search.setInputType(InputType.TYPE_CLASS_NUMBER);
			search.setText("");
			po=0;
		}
		if(pos==1)
		{
			search.setHint("Enter Symbol");
			search.setInputType(InputType.TYPE_CLASS_TEXT);
			search.setText("");
			po=1;
		}
		if(pos==2)
		{
			search.setHint("Enter Element Name");
			search.setText("");
			search.setInputType(InputType.TYPE_CLASS_TEXT);
			po=2;
		}
		
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        Intent bak = new Intent("android.intent.action.MAI");
        startActivity(bak);

        return false;
    }

}
