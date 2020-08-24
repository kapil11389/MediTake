package com.example.kapilyadav.medicine.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.kapilyadav.medicine.Adapters.MedicineAdapter;
import com.example.kapilyadav.medicine.Data.MedicineList;
import com.example.kapilyadav.medicine.R;

import java.util.ArrayList;

public class MedicineActivity extends AppCompatActivity {
    RecyclerView rvMedicine;
    ArrayList<MedicineList> medicines;
    MedicineAdapter medicineAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        medicines=new ArrayList<>();
       // medicines.add(new MedicineList());
       // medicines.add(new MedicineList());
       // medicines.add(new MedicineList());
        rvMedicine=(RecyclerView)findViewById(R.id.rvMedicine);
        medicineAdapter=new MedicineAdapter(this,medicines);
        rvMedicine.setLayoutManager(new LinearLayoutManager(this));
        rvMedicine.setAdapter(medicineAdapter);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MedicineActivity.this, AddMedicine.class);
                startActivityForResult(i, 7);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK&&data!=null)
        {
            medicines.add(new MedicineList(data.getStringExtra("Medicine"),data.getStringExtra("Additional"),
                    data.getBooleanExtra("Morning",false),data.getBooleanExtra("Noon",false),data.getBooleanExtra("Night",false)));
            medicineAdapter.update(medicines);
        }
    }
}
