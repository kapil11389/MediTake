package com.example.kapilyadav.medicine.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.kapilyadav.medicine.R;

public class AddDisease extends AppCompatActivity {
    EditText etDisease,etPrecaution;
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_disease);
        etDisease=(EditText)findViewById(R.id.etDisease);
        etPrecaution=(EditText)findViewById(R.id.etPrecaution);
        btnAdd=(Button)findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Button","Inside");
                Intent i=new Intent(AddDisease.this,DiseaseActivity.class);
                i.putExtra("Disease",etDisease.getText().toString());
                i.putExtra("Precaution",etPrecaution.getText().toString());
                setResult(RESULT_OK,i);
                finish();

            }
        });
    }
}
