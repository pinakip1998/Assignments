package com.example.basicCalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button b1;
    int op= 1;
    EditText v1,v2,r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void buttonClickOption(View v){
        b1=findViewById(R.id.button1);
        String temp = b1.getText().toString();
        if(temp.equals("Mode\nAddition"))
        {
            b1.setText(R.string.str1);
            op=-1;
        }
        else
        {
            b1.setText(R.string.str2);
            op=1;
        }
    }

    public void buttonCalculate(View v)
    {
        v1=(EditText)findViewById(R.id.input1);
        v2=(EditText)findViewById(R.id.input2);
        r=(EditText)findViewById(R.id.result);
        int i,j,result;
        i=Integer.parseInt(v1.getText().toString());
        j=Integer.parseInt(v2.getText().toString());
        result=i+(op*j);
        r.setText(String.format("%d",result));
    }
}
