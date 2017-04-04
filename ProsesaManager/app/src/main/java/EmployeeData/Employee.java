package EmployeeData;

import java.io.Serializable;
import java.text.SimpleDateFormat;

/**
 * Created by Pablo Garcia on 31/03/2017.
 */

public class Employee implements Serializable {

    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

    public static final String EMPLOYEE_KEY = "EMPLOYEE_KEY";
    private String name;
    private String secondName;
    private String lastName;
    private String secondLastName;
    private String user;
    private String password;
    private int age;
    private String dob;
    private String company;
    private String position;

    public Employee(){

    }

    public Employee(String name, String secondName, String lastName,
                    String secondLastName, String user, String password, int age, String dob, String company, String position){
        this.name = name;
        this.secondName = secondName;
        this.lastName = lastName;
        this.secondLastName = secondLastName;
        this.user = user;
        this.password = password;
        this.age = age;
        this.dob = dob;
        this.company = company;
        this.position = position;
    }

    public void setName(String name){this.name = name;}
    public void setSecondName(String secondName){this.secondName=secondName;}
    public void setLastName(String lastName){this.lastName = lastName;}
    public void setSecondLastName(String secondLastName){this.secondLastName=secondLastName;}
    public void setUser(String user){this.user = user;}
    public void setPassword(String password){this.password = password;}
    public void setAge(int age){this.age = age;}
    public void setDob(String dob){this.dob = dob;}
    public void setCompany(String company){this.company = company;}
    public void setPosition(String position){this.position = position;}

    public String getName(){
        return name;
    }
    public String getSecondName(){
        return secondName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getSecondLastName(){
        return secondLastName;
    }
    public String getUser(){return user;}
    public String getPassword(){return password;}
    public int getAge(){
        return age;
    }
    public String getDob(){
        return dob;
    }
    public String getCompany(){
        return company;
    }
    public String getPosition(){
        return position;
    }



    public String toString(){


        return "EMPLOYEE FOUND: "+"\n" +" Name: " + getName() +"\n" + " SecondName: " + getSecondName() +"\n" +
                " LastName: " + getLastName() +"\n" + " SecondLastName: " + getSecondLastName() +"\n" +
                " User: " + getUser() +"\n" + " Password: **************" + "\n"  +
                " Age: " + getAge()+"\n"  + " DateOfBirth: " +getDob() +"\n" +
                " Company: " + getCompany()+"\n"  + " Position: " + getPosition();


    }
}
