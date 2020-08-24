package com.example.kapilyadav.medicine.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.kapilyadav.medicine.R;

public class AddMember extends AppCompatActivity {
    EditText etMember,etAge;
    CheckBox cbGenderM,cbGenderF;
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_member);
            etMember=(EditText)findViewById(R.id.etName);
            cbGenderM=(CheckBox)findViewById(R.id.cbMale);
            cbGenderF=(CheckBox)findViewById(R.id.cbFemale);
            etAge=(EditText)findViewById(R.id.etAge);
            btnAdd=(Button)findViewById(R.id.btnAdd);
            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i=new Intent(AddMember.this,MainActivity.class);
                    i.putExtra("Member",etMember.getText().toString());
                    i.putExtra("GenderF",cbGenderF.isChecked());
                    i.putExtra("GenderM",cbGenderM.isChecked());
                    i.putExtra("Age",etAge.getText().toString());
                    setResult(RESULT_OK,i);
                    finish();
                }
            });
        }

    }


