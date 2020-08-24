package com.example.kapilyadav.medicine.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.kapilyadav.medicine.R;

public class AddMedicine extends AppCompatActivity {
    EditText etMedicine,etSpecialMention;
    CheckBox cbMorning,cbNoon,cbNight;
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medicine);
        etMedicine=(EditText)findViewById(R.id.etMedicine);
        etSpecialMention=(EditText)findViewById(R.id.etSpecialMention);
        cbMorning= (CheckBox) findViewById(R.id.cbMorning);
        cbNoon= (CheckBox) findViewById(R.id.cbNoon);
        cbNight=(CheckBox) findViewById(R.id.cbNight);
        btnAdd=(Button)findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Button","dgfdfg");
                Intent i=new Intent(AddMedicine.this,MedicineActivity.class);
                i.putExtra("Medicine",etMedicine.getText().toString());
                i.putExtra("Additional",etSpecialMention.getText().toString());
                i.putExtra("Morning",cbMorning.isChecked());
                i.putExtra("Noon",cbNoon.isChecked());
                i.putExtra("Night",cbNight.isChecked());
                setResult(RESULT_OK,i);
                finish();
            }
        });

    }
}
