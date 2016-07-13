package com.justinkleiber.labkit;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Splash extends Activity{

    TextView load;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.splash);

        DBLoad dbl = new DBLoad(this);
        dbl.execute(this);

}

    private class DBLoad extends AsyncTask<Context, Integer, Integer>
    {
        private Context mContext;

        public DBLoad(Context context) {
            mContext = context;
        }


        protected Integer doInBackground(Context... c) {

            DataHandler dh = new DataHandler(mContext);
            dh.resetData();
            ArrayList<String> elements = new ArrayList<String>();
            elements=load("theElements.txt");
            //Log.d("ELEMENT SIZE:", String.valueOf(elements.size()));

            int ind=0;
            int lim = elements.size()/11;
            if(elements!= null)
            {
                for(int i=1; i<=lim; i++)
                {
                    dh.addElement(new Element(i,elements.get(ind), elements.get(ind+1),
                            elements.get(ind+2), elements.get(ind+3),
                            elements.get(ind+4), elements.get(ind+5),elements.get(ind+6),
                            elements.get(ind+7),elements.get(ind+8),elements.get(ind+9),
                            elements.get(ind+10)));
                    ind+=11;


                }
            }

            return lim;
        }



        protected void onPostExecute(Integer result) {
            Intent mi=new Intent("android.intent.action.MAI");
            startActivity(mi);
            finish();
        }
    }


public ArrayList<String> load(String filename)
{
	try
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(getAssets().open(filename)));
        String line = null;
        ArrayList<String> input = new ArrayList<String>();
        while ((line = reader.readLine()) != null)
        {
            input.add(line);
        }
        reader.close();

        //toast("File successfully loaded.");
        return input;
    }
    catch (Exception ex)
    {
        //toast("Error loading file: " + ex.getLocalizedMessage());
        return null;
    }

}
public void save(String file, String value)
{
	try
	{
		FileOutputStream fos = openFileOutput(file, Context.MODE_PRIVATE);
		fos.write(value.getBytes());
		fos.close();
	}
	catch (Exception ex)
	{
		ex.printStackTrace();
	}
}

public boolean loadTest(String filename)
{
	try
    {
        FileInputStream fis = openFileInput(filename);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
        String line = null, input="";
        while ((line = reader.readLine()) != null)
            input += line;
        reader.close();
        fis.close();
        //toast("File successfully loaded.");
        return true;
    }
    catch (Exception ex)
    {
        //toast("Error loading file: " + ex.getLocalizedMessage());
        return false;
    }
}

}