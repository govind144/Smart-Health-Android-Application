package com.example.consulting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class UserRights extends AppCompatActivity {

    DatabaseReference dbReferenceUser;
    Button btndoctor,btnmedicalstore,btnambulance,btnchat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rights);
        // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // setSupportActionBar(toolbar);
        btndoctor=(Button) findViewById(R.id.btndoctor);
        btnmedicalstore=(Button) findViewById(R.id.btnmedicalstore);
        btnambulance=(Button) findViewById(R.id.btnambulance);
        //btnchat =(Button) findViewById(R.id.btnchat);
       // btnchat.setOnClickListener(new View.OnClickListener() {
        //    @Override
         //   public void onClick(View v) {
         //       Intent i=new Intent(UserRights.this,MainForChatActiviy.class);
           //     startActivity(i);
          //  }
       // });
        btndoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(UserRights.this,Searchdoctor.class);
                startActivity(i);
            }
        });
        btnmedicalstore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(UserRights.this,SearchMedicalStore.class);
                startActivity(i);
            }
        });
        btnambulance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(UserRights.this,SearchAmbulance.class);
                startActivity(i);
            }
        });
    }
}
