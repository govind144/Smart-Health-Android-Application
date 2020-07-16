package com.example.consulting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import de.hdodenhof.circleimageview.CircleImageView;

public class MessageActivity extends AppCompatActivity {

    CircleImageView profile_image;
    TextView username;
    DoctorAdapter[] daArray=new DoctorAdapter[1];
    FirebaseUser fuser;
    DatabaseReference dbReferenceUser;

    Intent intent;
    String userid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        profile_image =findViewById(R.id.profile_Image);
        username=(TextView) findViewById(R.id.username);

       // intent = getIntent();
       //  userid=intent.getStringExtra("doctorID");
        //String Uid;
        //FirebaseUser uid = FirebaseAuth.getInstance().getCurrentUser();
        //Uid = uid.getUid();
        dbReferenceUser = FirebaseDatabase.getInstance().getReference().child("doctors");
        //fuser= FirebaseAuth.getInstance().getCurrentUser();
       // dbReferenceUser = FirebaseDatabase.getInstance().getReference("doctors").child(userid);
       // System.out.println(dbReferenceUser);
        // DoctorAdapter ad=new DoctorAdapter();

        dbReferenceUser.child("doctors").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                DoctorAdapter p = dataSnapshot.getValue(DoctorAdapter.class);
                //String username1 = (String)dataSnapshot.child("doctors").child("doctorName").getValue();
                // username.setText(p.getDoctorName());
                if (dataSnapshot.child(p.getDoctorName()).exists()) {
                    Toast.makeText(MessageActivity.this, "The Username is Already Exist!", Toast.LENGTH_SHORT).show();
                }
            }
               // profile_image.setImageResource(R.mipmap.ic_launcher);

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }
}
