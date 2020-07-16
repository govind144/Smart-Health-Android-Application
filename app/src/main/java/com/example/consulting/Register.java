package com.example.consulting;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    EditText mUserName,mEmail,mPassword,mGender,mPhoneNumber;
    Button mRegisterBtn;
    TextView mLoginbtn;
    FirebaseAuth fAuth;
    Spinner gender_type;
    ProgressBar progressBar;
    String[] Gender = { "Male", "Female"};


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.avtivity_register);
        mUserName = (EditText) findViewById(R.id.textuserName);
        gender_type=(Spinner) findViewById(R.id.spinner);
        mEmail = (EditText) findViewById(R.id.textEmailAddress);
        mPassword=(EditText) findViewById(R.id.textPassword);
        mPhoneNumber = (EditText) findViewById(R.id.textphoneNumber);
        mRegisterBtn=(Button) findViewById(R.id.mRegisterBtn);
        mLoginbtn=findViewById(R.id.createtext);
        Spinner spin = (Spinner) findViewById(R.id.spinner);

        //spin.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

        fAuth=FirebaseAuth.getInstance();
        progressBar=findViewById(R.id.progressBar);

        if(fAuth.getCurrentUser()!=null)
        {
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }

        //Creating the ArrayAdapter instance having the country list
        //ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,gender_type);
       // aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
       // spin.setAdapter(aa);
        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=mEmail.getText().toString();
                String password =mPassword.getText().toString();

                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Email is Required");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    mPassword.setError("Password is Required");
                    return;
                }
                if(password.length() < 6){
                    mPassword.setError("password Must be >= 6 Characters");
                }
                progressBar.setVisibility(View.VISIBLE);

                //Add User
                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Register.this,"User Created.",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        }else{
                            Toast.makeText(Register.this,"Error ! "+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }


}
