package com.justinkleiber.labkit;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	Button belement, bphys, bform,bconv,bexp;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		belement=(Button) findViewById(R.id.bElement);
		bphys=(Button) findViewById(R.id.bPhysics);
		//bform=(Button) findViewById(R.id.bForm);
		//bconv=(Button) findViewById(R.id.bConvert);
       // bexp=(Button) findViewById(R.id.bTest);
		
		belement.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent iTable = new Intent("android.intent.action.TAB");
				startActivity(iTable);
			}
		});
		
		bphys.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent phy = new Intent("android.intent.action.PHYSICS");
				startActivity(phy);
			}
		});
		/*bform.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent iTable = new Intent("android.intent.action.FORM");
				startActivity(iTable);
			}
		});
		bconv.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent iTable = new Intent("android.intent.action.CONV");
				startActivity(iTable);
			}
		});
        bexp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent iTable = new Intent("android.intent.action.EXP");
                startActivity(iTable);
            }
        });

*/
}
}