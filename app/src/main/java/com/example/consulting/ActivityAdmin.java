package com.example.consulting;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class ActivityAdmin extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    FirebaseAuth fAuth;
    DatabaseReference dbReferenceUser;
    Button btnC,btnviewuser,btnambulance,btnviewdoctor,btnviewmedicalstore,btnviewambulance;
    ImageView imgView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
       // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);
        fAuth=FirebaseAuth.getInstance();
        btnviewuser=(Button) findViewById(R.id.btnviewuser);
        btnambulance=(Button) findViewById(R.id.btnaddambulance);
        btnviewdoctor=(Button) findViewById(R.id.btnviewdoctor);
        btnviewmedicalstore=(Button) findViewById(R.id.btnviewmedicalstore);
        btnviewambulance=(Button) findViewById(R.id.btnviewambulance);


        btnambulance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ActivityAdmin.this,AddAmbulance.class);
                startActivity(i);
            }
        });
        btnviewuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(ActivityAdmin.this,ViewUser.class);
                startActivity(i2);
            }
        });
        btnviewdoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ActivityAdmin.this,ViewDoctor.class);
                startActivity(i);
            }
        });
        btnviewmedicalstore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ActivityAdmin.this,ViewMedicalStore.class);
                startActivity(i);
            }
        });
        btnviewambulance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ActivityAdmin.this,ViewAmbulance.class);
                startActivity(i);
            }
        });
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.doctor, menu);
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

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        return true;
    }
}
