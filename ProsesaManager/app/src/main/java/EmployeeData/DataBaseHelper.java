package EmployeeData;

import android.content.ContentValues;
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
    public static int DATABASE_VERSION = 1;

    public static final String ID = "ID";
    public static final String NAME = "name";
    public static final String SECOND_NAME = "secondName";
    public static final String LAST_NAME = "lastName";
    public static final String SECOND_LAST_NAME = "secondLastName";
    public static final String USER = "user";
    public static final String PASSWORD = "password";
    public static final String AGE = "age";
    public static final String DOB = "dob";
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
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertEmployee(Employee employee){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, employee.getName());
        contentValues.put(SECOND_NAME, employee.getSecondName());
        contentValues.put(LAST_NAME, employee.getLastName());
        contentValues.put(SECOND_LAST_NAME, employee.getSecondLastName());
        contentValues.put(USER, employee.getUser());
        contentValues.put(PASSWORD, employee.getPassword());
        contentValues.put(AGE, employee.getAge());
        contentValues.put(DOB, employee.getDob());
        contentValues.put(COMPANY, employee.getCompany());
        contentValues.put(POSITION, employee.getPosition());

        long insertResult = db.insert(TABLE_NAME, null, contentValues);

        if(insertResult == -1){
            return false;
        }else{
            return true;
        }

    }
}
