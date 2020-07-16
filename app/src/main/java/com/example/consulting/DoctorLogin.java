package com.example.consulting;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class DoctorLogin extends AppCompatActivity {

    EditText txtname,txtpass;
    String name,password,nm;
    //TextView txt;
    FirebaseAuth fAuth;
    ProgressBar progressBar;
    DatabaseReference dbReferenceUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        txtname=(EditText)findViewById(R.id.txtname);
        txtpass=(EditText)findViewById(R.id.txtpass);
        //txt=(TextView)findViewById(R.id.txt);
        progressBar= findViewById(R.id.progressBar2);

    }

    public void  onClick(View v)
    {
        name=txtname.getText().toString();
        password=txtpass.getText().toString();
        String arr[]={name,password};
        fAuth= FirebaseAuth.getInstance();

       // if(fAuth.getCurrentUser()!=null)
       // {
           // startActivity(new Intent(getApplicationContext(), MainActivity.class));
        //    finish();
       // }

        if(TextUtils.isEmpty(name)){
            txtname.setError("Email is Required");
            return;
        }

        if(TextUtils.isEmpty(password)){
            txtpass.setError("Password is Required");
            return;
        }
        if(password.length() < 6){
            txtpass.setError("password Must be >= 6 Characters");
        }
        progressBar.setVisibility(View.VISIBLE);

        //authenticate the user
        fAuth.signInWithEmailAndPassword(name,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                   // Toast.makeText(DoctorLogin.this,"Logged in Successfully.",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),DoctorRights.class));
                }
                else {
                    Toast.makeText(DoctorLogin.this,"Error ! "+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
