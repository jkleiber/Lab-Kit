package com.justinkleiber.labkit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataHandler extends SQLiteOpenHelper{

	//STATIC VARS
    //Database Version
    private static final int DATABASE_VERSION = 20;
 
    //Database Name
    private static final String DATABASE_NAME = "periodicDB";
 
    //Periodic Table
    private static final String TABLE_P = "ptable";
    //Columns
    private static final String KEY_NUM = "at_num";
    private static final String KEY_NAME = "name";
    private static final String KEY_SYM = "symbol";
    private static final String KEY_MASS = "mass";
    private static final String KEY_VELEC = "velec";
    private static final String KEY_GROUP = "groups";
    private static final String KEY_ION = "ionization";
    private static final String KEY_ELECTRO = "electroneg";
    private static final String KEY_RAD = "radius";
    private static final String KEY_TYP = "type";
    private static final String KEY_NOTE = "notation";
    private static final String KEY_PHASE = "phase";

	
	public DataHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String CREATE_P_TABLE = "CREATE TABLE "+ TABLE_P + "(" 
		+ KEY_NUM + " INTEGER, " 
		+ KEY_NAME + " TEXT, " 
		+ KEY_SYM + " TEXT, "
		+ KEY_MASS + " TEXT, " 
		+ KEY_VELEC + " TEXT, " 
		+ KEY_GROUP + " TEXT, " 
		+ KEY_ION + " TEXT, "
		+ KEY_ELECTRO + " TEXT, " 
		+ KEY_RAD + " TEXT, " 
		+ KEY_TYP + " TEXT, " 
		+ KEY_PHASE + " TEXT, " 
		+ KEY_NOTE + " TEXT" 
		+ ") ";
		db.execSQL(CREATE_P_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_P);
		onCreate(db);
	}

    public void destroyAllData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_P);
        onCreate(db);
    }
	public void resetData()
	{
		SQLiteDatabase db = this.getWritableDatabase();
		/*
		Cursor c = db.rawQuery("SELECT COUNT(*) FROM TABLE_P", null);
		c.moveToFirst();
		int rows = c.getInt(0);
		*/
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_P);
        String CREATE_P_TABLE = "CREATE TABLE "+ TABLE_P + "("
                + KEY_NUM + " INTEGER, "
                + KEY_NAME + " TEXT, "
                + KEY_SYM + " TEXT, "
                + KEY_MASS + " TEXT, "
                + KEY_VELEC + " TEXT, "
                + KEY_GROUP + " TEXT, "
                + KEY_ION + " TEXT, "
                + KEY_ELECTRO + " TEXT, "
                + KEY_RAD + " TEXT, "
                + KEY_TYP + " TEXT, "
                + KEY_PHASE + " TEXT, "
                + KEY_NOTE + " TEXT"
                + ") ";
        db.execSQL(CREATE_P_TABLE);
		
	}
	public void addElement(Element e)
	{
		SQLiteDatabase db = this.getWritableDatabase();
		 
	    ContentValues values = new ContentValues();
	    values.put(KEY_NUM, e.getNum()); 
	    values.put(KEY_NAME, e.getName()); 
	    values.put(KEY_SYM, e.getIcon()); 
	    values.put(KEY_MASS, e.getMass()); 
	    values.put(KEY_VELEC, e.getVal()); 
	    values.put(KEY_GROUP, e.getG()); 
	    values.put(KEY_ION, e.getIon()); 
	    values.put(KEY_ELECTRO, e.getNeg()); 
	    values.put(KEY_RAD, e.getRad()); 
	    values.put(KEY_TYP, e.getType()); 
	    values.put(KEY_PHASE, e.getPhase()); 
	    values.put(KEY_NOTE, e.getNote()); 
	 
	    // Inserting Row
	    db.insert(TABLE_P, null, values);
	    db.close(); // Closing database connection
	}
	public Element getElementByNum(int num)
	{
		
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.query(TABLE_P, new String[] { KEY_NUM,
	            KEY_NAME, KEY_SYM, KEY_MASS, KEY_VELEC, KEY_GROUP, KEY_ION, KEY_ELECTRO, KEY_RAD, KEY_TYP, KEY_NOTE, KEY_PHASE }, KEY_NUM + "=?",
	            new String[] { String.valueOf(num) }, null, null, null, null);
		if(cursor.moveToFirst())
		{
		Element e = new Element(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), 
				cursor.getString(5), cursor.getString(6), cursor.getString(7), 
				cursor.getString(8), cursor.getString(9), cursor.getString(10), cursor.getString(11));
		
		return e;
		}
		else
		{
			return null;
		}
	}
	
	public Element getElementByName(String name)
	{
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.query(TABLE_P, new String[] { KEY_NUM,
	            KEY_NAME, KEY_SYM, KEY_MASS, KEY_VELEC, KEY_GROUP, KEY_ION, KEY_ELECTRO, KEY_RAD, KEY_TYP, KEY_NOTE, KEY_PHASE  }, KEY_NAME + "=?" + "COLLATE NOCASE",
	            new String[] { String.valueOf(name) }, null, null, null, null);
		if(cursor.moveToFirst())
		{
			
		Element e = new Element(Integer.parseInt(cursor.getString(0)),
	            cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7)
	            , cursor.getString(8), cursor.getString(9), cursor.getString(10), cursor.getString(11));
		return e;
		}
		else
		{
			return null;
		}
		
	}
	
	public Element getElementBySymbol(String sym)
	{
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.query(TABLE_P, new String[] { KEY_NUM,
	            KEY_NAME, KEY_SYM, KEY_MASS, KEY_VELEC, KEY_GROUP, KEY_ION, KEY_ELECTRO, KEY_RAD, KEY_TYP, KEY_NOTE, KEY_PHASE  }, KEY_SYM + "=?" + "COLLATE NOCASE",
	            new String[] { String.valueOf(sym) }, null, null, null, null);
		if(cursor.moveToFirst())
		{
			
		Element e = new Element(Integer.parseInt(cursor.getString(0)),
	            cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), 
	            cursor.getString(5), cursor.getString(6), cursor.getString(7), 
	            cursor.getString(8), cursor.getString(9), cursor.getString(10), cursor.getString(11));
		return e;
		}
		else
		{
			return null;
		}
	}

	 
}
