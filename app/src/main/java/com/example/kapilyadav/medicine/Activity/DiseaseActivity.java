package com.example.kapilyadav.medicine.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.kapilyadav.medicine.Adapters.DiseaseAdapter;
import com.example.kapilyadav.medicine.Adapters.ItemClickListener;
import com.example.kapilyadav.medicine.Data.Disease;
import com.example.kapilyadav.medicine.R;

import java.util.ArrayList;

public class DiseaseActivity extends AppCompatActivity {
    RecyclerView rvDisease;
    FloatingActionButton fab;
    ArrayList<Disease> Diseases;
    DiseaseAdapter da;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Diseases = new ArrayList<>();
        rvDisease = (RecyclerView) findViewById(R.id.rvDisease);
        da = new DiseaseAdapter(Diseases, this);
        //Diseases.add(new Disease("cold", "Stay away from cold"));
        rvDisease.setLayoutManager(new LinearLayoutManager(this));
        rvDisease.setAdapter(da);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Button","Inside");
                Intent i = new Intent(DiseaseActivity.this, AddDisease.class);
                startActivityForResult(i,6);


            }
        });
        da.OnItemClickListener(new ItemClickListener() {
            @Override
            public void OnClick() {
                Intent i=new Intent(DiseaseActivity.this,MedicineActivity.class);
                startActivity(i);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null) {
            Log.d("trt",""+data.getStringExtra("Disease")+data.getStringExtra("Precaution"));
            Diseases.add(new Disease(data.getStringExtra("Disease"),data.getStringExtra("Precaution")));
            da.updateData(Diseases);
        }
    }
}
