package com.example.kapilyadav.medicine.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.kapilyadav.medicine.Adapters.ItemClickListener;
import com.example.kapilyadav.medicine.Adapters.MemberAdapter;
import com.example.kapilyadav.medicine.Data.Member;
import com.example.kapilyadav.medicine.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvMember;
    FloatingActionButton fab;
    ArrayList<Member> Members;
    MemberAdapter ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Members = new ArrayList<>();
        Members.add(new Member("Daily Use Medicine", "", ""));
        rvMember = (RecyclerView) findViewById(R.id.rvMember);
        rvMember.setLayoutManager(new LinearLayoutManager(this));
        ma = new MemberAdapter(this, Members);
        rvMember.setAdapter(ma);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        ma.setOnItemClickListener(new ItemClickListener() {
            @Override
            public void OnClick() {
                Intent i = new Intent(MainActivity.this, DiseaseActivity.class);
                startActivity(i);
            }
        });
        Log.d("Cfff", "fvfbgbg");
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Click", "clickooo");
                Intent i = new Intent(MainActivity.this, AddMember.class);
                startActivityForResult(i, 7);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null) {
            if (data.getBooleanExtra("GenderM", false))
                Members.add(new Member(data.getStringExtra("Member"), "Male", data.getStringExtra("Age")));
            if (data.getBooleanExtra("GenderF", false))
                Members.add(new Member(data.getStringExtra("Member"), "Female", data.getStringExtra("Age")));
            ma.update(Members);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent i=new Intent(MainActivity.this,AboutDeveloper.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }
}