package com.example.consulting;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.firebase.database.DatabaseReference;

public class DoctorRights extends AppCompatActivity {

    DatabaseReference dbReferenceUser;
    Button btnreqchat;
    Button button,btnavailabletime;
    TextView textView;
    String IMEINumber;
    private static final int REQUEST_CODE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_rights);
        // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // setSupportActionBar(toolbar);
        btnreqchat=(Button) findViewById(R.id.btnreqchat);
        textView = findViewById(R.id.textView);
        btnavailabletime=findViewById(R.id.btnavailabletime);
        btnavailabletime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(DoctorRights.this,DoctorTiming.class);
                startActivity(i);
            }
        });
        btnreqchat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent i=new Intent(DoctorRights.this,PatientChatActivity.class);
               startActivity(i);

            }
        });
    }
}
