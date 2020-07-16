package com.example.consulting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;

public class MedicalStoreRights extends AppCompatActivity {

    DatabaseReference dbReferenceUser;
    Button btnreqchat,btnaddmedicine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicalstore_rights);
        // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // setSupportActionBar(toolbar);
        btnreqchat=(Button) findViewById(R.id.btnreqchat);
        btnaddmedicine=(Button) findViewById(R.id.btnaddmedicine);
        btnaddmedicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MedicalStoreRights.this,AddMedicine.class);
                startActivity(i);
            }
        });
        btnreqchat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MedicalStoreRights.this,PatientChatActivity.class);
                startActivity(i);
            }
        });
    }
}
