package com.example.prosesamanager;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Calendar;
import java.util.GregorianCalendar;

import EmployeeData.Employee;

public class login extends Activity {
    Employee dummy = null;
    private EditText mUser;
    private EditText mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //Creating Dummy Employee
        createEmployee();

        //Creating LOGIN Button
        Button login = (Button) findViewById(R.id.btn_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUser = (EditText) findViewById(R.id.txt_user);
                mPassword = (EditText) findViewById(R.id.txt_password);

                String user = mUser.getText().toString();
                String password = mPassword.getText().toString();

                //Compares User and Password from View against DUMMY Employee
                if(validateLogin(user, password)){
                    Intent intent = new Intent(getApplicationContext(), MainMenu.class);
                    intent.putExtra(Employee.EMPLOYEE_KEY, dummy);
                    startActivity(intent);
                }
                //Else, will ask for a valid user and
                // password and will reset user and password fields.
                else{
                    mUser.setText("");
                    mPassword.setText("");
                    mUser.hasFocus();
                    Toast toast = Toast.makeText(getApplicationContext(),
                                    "Enter a valid user and/or password",
                                    Toast.LENGTH_LONG);
                    toast.show();
                }

            }
        });

    }

    public Employee createEmployee(){
        Calendar dob = new GregorianCalendar(1991, 10, 15);
        dummy = new Employee("Pablo", "De Jesus", "Garcia", "Arzola","pablodns", "1215", 25, dob, "Accenture", "QA Test");
        return dummy;
    }

    //Validate whether the employee is created
    public Boolean validateLogin(String user, String password){
        if(dummy.getUser().equals(user) && dummy.getPassword().equals(password)){
            return true;
        }
        else{return false;}
    }

    public void exitApp(View v){
        this.finish();
    }

    @Override
    public void onRestart(){
        super.onRestart();
        mUser.setText(null);
        mPassword.setText(null);
        if(mUser.requestFocus()){
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }

    }





}
