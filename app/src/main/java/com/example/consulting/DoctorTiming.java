package com.example.consulting;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.StorageReference;

public class DoctorTiming extends AppCompatActivity {

    EditText fromtime, totime;
    String d_fromtime, d_totime;
    StorageReference storageReference;
    FirebaseAuth fAuth;
    DatabaseReference dbReferenceUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_timing);
        //imgView = (ImageView) findViewById(R.id.imgView);
        fromtime = (EditText) findViewById(R.id.fromtime);
        totime = (EditText) findViewById(R.id.totime);
    }

    public void insert(View v) {
        // id = c_id.getText().toString();
        //int cid=Integer.parseInt(id);
        // Toast.makeText(this, "test", Toast.LENGTH_SHORT).show();
        d_fromtime = fromtime.getText().toString();
        // Toast.makeText(this, "test", Toast.LENGTH_SHORT).show();
        d_totime = totime.getText().toString();
        fAuth=FirebaseAuth.getInstance();
        dbReferenceUser = FirebaseDatabase.getInstance().getReference("doctortiming");
        String id = dbReferenceUser.push().getKey();

        DoctorTimingAdapter doctiming =new DoctorTimingAdapter(d_fromtime,d_totime);
        dbReferenceUser.child(id).setValue(doctiming);

        Toast.makeText(DoctorTiming.this,"Time Added Successfully.",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(),DoctorRights.class));
    }
}
