package com.example.shahalam.projectbusschedule;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab,fabLeftDept, fabLeftFaculty, fabLeftDegree, fabLeftHstu;
    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);


        MyViewPageAdapter pagerAdapter = new MyViewPageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fabLeftDept = findViewById(R.id.fabLeftDepartment);
        fabLeftFaculty = findViewById(R.id.fabLeftFaculty);
        fabLeftDegree = findViewById(R.id.fabLeftDegree);
        fabLeftHstu = findViewById(R.id.fabLeftHstu);



        fabLeftDept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Click action
                Intent intent = new Intent(MainActivity.this, Department.class);
                startActivity(intent);
            }
        });

        fabLeftFaculty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Click action
                Intent intent = new Intent(MainActivity.this, Faculty.class);
                startActivity(intent);
            }
        });

        fabLeftDegree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Click action
                Intent intent = new Intent(MainActivity.this, Degree.class);
                startActivity(intent);
            }
        });

        fabLeftHstu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Click action
                Toast.makeText(getApplicationContext(), "Opening from HSTU website. Please keep wifi/cellular data on ",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, HSTUWebHome.class);
                startActivity(intent);
            }
        });
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
            return true;
        }
        if (id == R.id.action_share) {
            return true;
        }
        if (id == R.id.action_info) {
            Intent intent = new Intent(this, info.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
