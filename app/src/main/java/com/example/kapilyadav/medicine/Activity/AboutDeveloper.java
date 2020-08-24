package com.example.kapilyadav.medicine.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.kapilyadav.medicine.R;

public class AboutDeveloper extends AppCompatActivity {
    TextView name, father, mother, institute, degree, phone, email, address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_developer);
        name = (TextView) findViewById(R.id.Name);
        father = (TextView) findViewById(R.id.Father);
        mother = (TextView) findViewById(R.id.Mother);
        institute = (TextView) findViewById(R.id.College);
        degree = (TextView) findViewById(R.id.Degree);
        phone = (TextView) findViewById(R.id.Phone);
        email = (TextView) findViewById(R.id.Email);
        address = (TextView) findViewById(R.id.Address);
    }
}
