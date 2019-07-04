package com.example.recyclerviewassignment;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Person extends RealmObject {

    @PrimaryKey
    private long id;
    private String name,roll,phone,gender,dept;

    public long getId(){return this.id;}
    public void setId(long id){this.id=id;}

    public String getName(){return this.name;}
    public void setName(String name){this.name=name;}

    public String getRoll(){return this.roll;}
    public void setRoll(String roll){this.roll=roll;}

    public String getPhone(){return this.phone;}
    public void setPhone(String phone){this.phone=phone;}

    public String getGender(){return this.gender;}
    public void setGender(String gender){this.gender=gender;}

    public String getDept(){return this.dept;}
    public void setDept(String dept){this.dept=dept;}

}
