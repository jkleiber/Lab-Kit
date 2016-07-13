package com.justinkleiber.labkit;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ElementViewer extends Activity{

	Element e;
	TextView name, num, sym, weight, group, ion, velec, electro, radi, nota, typ, phase;
	LinearLayout eBox;
	//GradientDrawable box;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.elementdisplay);
		
		DataHandler dh = new DataHandler(this);
		
		name = (TextView) findViewById(R.id.tvName);
		num = (TextView) findViewById(R.id.tvNum);
		sym = (TextView) findViewById(R.id.tvSymbol);
		weight = (TextView) findViewById(R.id.tvMass);
		group = (TextView) findViewById(R.id.tvGroup);
		ion = (TextView) findViewById(R.id.tvIon);
		velec = (TextView) findViewById(R.id.tvVelec);
		electro = (TextView) findViewById(R.id.tvElec);
		radi = (TextView) findViewById(R.id.tvRad);
		nota = (TextView) findViewById(R.id.tvNote);
		typ = (TextView) findViewById(R.id.tvTyp);
		phase = (TextView) findViewById(R.id.tvPhase);
		
		eBox = (LinearLayout) findViewById(R.id.elementBox);
		//box = (GradientDrawable)eBox.getBackground();
		
		ActionBar actionBar = getActionBar();
	    actionBar.setDisplayHomeAsUpEnabled(true);
		
		Typeface calib = Typeface.createFromAsset(getAssets(), "CORBEL.TTF");
		group.setTypeface(calib);
		ion.setTypeface(calib);
		velec.setTypeface(calib);
		electro.setTypeface(calib);
		radi.setTypeface(calib);
		nota.setTypeface(calib);
		typ.setTypeface(calib);
		phase.setTypeface(calib);
		
		Bundle extras = getIntent().getExtras();
		String term = extras.getString("term");
		int type = extras.getInt("type");
		
		switch (type)
		{
		case 0:
			e = dh.getElementByNum(Integer.parseInt(term));
			break;
		case 2:
			e = dh.getElementByName(term);
			break;
		case 1:
			e = dh.getElementBySymbol(term);
			break;
		default:
			e = dh.getElementByName(term);
			break;
		}
		
		if(e == null)
		{
			name.setText("N/A");
			num.setText("#");
			sym.setText("?");
			weight.setText("0");
			group.setGravity(Gravity.CENTER);
			group.setText("No Elements could be found");
			ion.setText("");
			velec.setText("");
			electro.setText("");
			radi.setText("");
			nota.setText("");
			phase.setText("");
			typ.setText("");
			
		}
		else
		{
			String note = superscript(e.getNote().toString());
			
			name.setText(""+e.getName());
			num.setText(""+e.getNum());
			sym.setText(""+e.getIcon());
			weight.setText(""+e.getMass());
			
			group.setText("Group: " + e.getG());
			ion.setText("Ionization Energy: " + e.getIon());
			velec.setText("Valence Electrons: " + e.getVal());
			electro.setText("Electronegativity: " + e.getNeg());
			radi.setText("Atomic Radius: " + e.getRad());
			nota.setText("Electron Notation: " + note);
			phase.setText("Phase at STP: " + e.getPhase());
			typ.setText(e.getType());
			
			Log.d("ELEMENT TYPE:", e.getType()+".");
			
			String str = e.getType();
			String strp = e.getPhase();

			/*
			if(strp.equals("Gas"))
			{
				box.setStroke(3, Color.parseColor("#FF0000"));
			}
			else if(strp.equals("Liquid"))
			{
				box.setStroke(3, Color.parseColor("#0000FF"));
			}
			else
			{
				box.setStroke(3, Color.parseColor("#000000"));
			}
			*/
			
			if(str.equals("Nonmetal"))
			{
				eBox.setBackgroundColor(getResources().getColor(R.color.nonmetal));
			}
			else if(str.equals("Metalloid"))
			{
				eBox.setBackgroundColor(getResources().getColor(R.color.metalloid));
			}
			else if(str.equals("Transitional Metal"))
			{
				eBox.setBackgroundColor(getResources().getColor(R.color.tmetal));
			}
			else if(str.equals("Alkali Metal"))
			{
				eBox.setBackgroundColor(getResources().getColor(R.color.alkalimetal));
			}
			else if(str.equals("Post-Transitional Metal") || str.equals("Post Transitional Metal"))
			{
				eBox.setBackgroundColor(getResources().getColor(R.color.postmetal));
			}
			else if(str.equals("Alkali Earth Metal"))
			{
				eBox.setBackgroundColor(getResources().getColor(R.color.alkaliearthmetal));
			}
			else if(str.equals("Halogen"))
			{
				eBox.setBackgroundColor(getResources().getColor(R.color.halogen));
				name.setTextColor(Color.parseColor("#FFFFFF"));
				num.setTextColor(Color.parseColor("#FFFFFF"));
				sym.setTextColor(Color.parseColor("#FFFFFF"));
				weight.setTextColor(Color.parseColor("#FFFFFF"));
			}
			else if(str.equals("Noble Gas"))
			{
				eBox.setBackgroundColor(getResources().getColor(R.color.noblegas));
			}
			else if(str.equals("Rare Earth Metal (Lanthanoids)"))
			{
				eBox.setBackgroundColor(getResources().getColor(R.color.lanthanoid));
				name.setTextColor(Color.parseColor("#FFFFFF"));
				num.setTextColor(Color.parseColor("#FFFFFF"));
				sym.setTextColor(Color.parseColor("#FFFFFF"));
				weight.setTextColor(Color.parseColor("#FFFFFF"));
			}
			else if(str.equals("Rare Earth Metal (Actinides)"))
			{
				eBox.setBackgroundColor(getResources().getColor(R.color.actinide));
				name.setTextColor(Color.parseColor("#FFFFFF"));
				num.setTextColor(Color.parseColor("#FFFFFF"));
				sym.setTextColor(Color.parseColor("#FFFFFF"));
				weight.setTextColor(Color.parseColor("#FFFFFF"));
			}
			/*
			else
			{
				eBox.setBackgroundColor(getResources().getColor(R.color.tmetal));
			}*/
		}
	}
	
	public static String superscript(String str) {
	    str = str.replaceAll("<sup>10</sup>", "\u00B9\u2070");
	    str = str.replaceAll("<sup>11</sup>", "\u00B9\u00B9");
	    str = str.replaceAll("<sup>12</sup>", "\u00B9\u00B2");
	    str = str.replaceAll("<sup>13</sup>", "\u00B9\u00B3");
	    str = str.replaceAll("<sup>14</sup>", "\u00B9\u2074");
	    str = str.replaceAll("<sup>1</sup>", "\u00B9");
	    str = str.replaceAll("<sup>2</sup>", "\u00B2");
	    str = str.replaceAll("<sup>3</sup>", "\u00B3");
	    str = str.replaceAll("<sup>4</sup>", "\u2074");
	    str = str.replaceAll("<sup>5</sup>", "\u2075");
	    str = str.replaceAll("<sup>6</sup>", "\u2076");
	    str = str.replaceAll("<sup>7</sup>", "\u2077");
	    str = str.replaceAll("<sup>8</sup>", "\u2078");
	    str = str.replaceAll("<sup>9</sup>", "\u2079");         
	    return str;
	}
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        Intent bak = new Intent("android.intent.action.TAB");
        startActivity(bak);

        return false;
    }

}
