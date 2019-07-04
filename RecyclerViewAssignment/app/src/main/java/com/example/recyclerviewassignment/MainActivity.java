package com.example.recyclerviewassignment;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    Spinner dept_spinner;
    String[] dept={"Computer Science Engineering","Information Technology","Electronics Engineering","Electrical Engineering"};
    ArrayAdapter<String>arrayAdapter;
    RadioGroup radiogroup;
    RadioButton male,female;
    private Context mcontext;
    private EditText name,roll,phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mcontext=this;
        dept_spinner=findViewById(R.id.main_dept_spinner);
        arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,dept);
        dept_spinner.setAdapter(arrayAdapter);
        radiogroup=findViewById(R.id.main_gender_rg);
        female=findViewById(R.id.main_female_rb);
        female.setChecked(true);
        name=findViewById(R.id.main_name_et);
        roll=findViewById(R.id.main_roll_et);
        phone=findViewById(R.id.main_phone_et);
        male=findViewById(R.id.main_male_rb);
    }
    public void onSavePressed(View view){
        Realm realm=Realm.getDefaultInstance();
        realm.beginTransaction();
        try{
            Person person=realm.createObject(Person.class,System.currentTimeMillis()/1000);
            person.setName(name.getText().toString());
            person.setRoll(roll.getText().toString());
            person.setDept(dept_spinner.getSelectedItem().toString());
            person.setPhone(phone.getText().toString());
            if(female.isChecked()==true)
                person.setGender("Female");
            if(male.isChecked()==true)
                person.setGender("Male");
            realm.commitTransaction();
            Toast.makeText(mcontext,"Success",Toast.LENGTH_LONG).show();
        }
        catch(Exception ex)
        {
            realm.cancelTransaction();
            Toast.makeText(mcontext,"Failure",Toast.LENGTH_LONG).show();
        }
        realm.close();
    }
    public void onDisplayPressed(View view){
        Intent intent=new Intent(this,DisplayActivity.class);
        startActivity(intent);
    }

}
