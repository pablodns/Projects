package EmployeeData;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Pablo Garcia on 03/04/2017.
 */

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Employee.db";
    public static final String TABLE_NAME = "employee";
    public static int DATABASE_VERSION = 0;

    public static final String ID = "ID";
    public static final String NAME = "name";
    public static final String SECOND_NAME = "secondName";
    public static final String LAST_NAME = "lastName";
    public static final String SECOND_LAST_NAME = "secondLastName";
    public static final String USER = "user";
    public static final String PASSWORD = "password";
    public static final int AGE = 0;
    public static final String DOB = "2017-04-03 12:01:55.56";
    public static final String COMPANY = "company";
    public static final String POSITION = "position";


    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME+
                " ("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                +NAME+" TEXT, "
                +SECOND_NAME+" TEXT, "
                +LAST_NAME+" TEXT, "
                +SECOND_LAST_NAME+" TEXT, "
                +USER+" TEXT, "
                +PASSWORD+" TEXT, "
                +AGE+" INTEGER, "
                +DOB+" TEXT, "
                +COMPANY+" TEXT, "
                +POSITION+" TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
