package com.example.prosesamanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import EmployeeData.DataBaseHelper;
import EmployeeData.Employee;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class MainMenu extends Activity {
    DataBaseHelper myDb;
    Employee dummy = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView mWelcome = (TextView) findViewById(R.id.txt_welcome);

        Intent intent = this.getIntent();

        if (intent != null){
            Employee employee = (Employee)intent.getSerializableExtra(Employee.EMPLOYEE_KEY);
            String welcome = "Welcome "+employee.getName()+" "+employee.getLastName()+". User "+employee.getUser()+".";
            //mWelcome.setText(employee.toString());
            mWelcome.setText(welcome);
        }
        else {
            mWelcome.setText("The employe is null");
        }

    }

    public void exitMainMenu(View v){
        this.finish();
    }

    public void addEmployee(View v){
        //if(myDb.insertEmployee(employee));


    }

}
