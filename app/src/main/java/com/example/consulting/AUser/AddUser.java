package com.example.consulting.AUser;

import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.consulting.MainActivity;
import com.example.consulting.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.io.ByteArrayOutputStream;

public class AddUser extends AppCompatActivity {

    //ImageView imgView;
    EditText c_name,c_date, c_pass, c_email, c_phone,c_description;
    Bitmap bm;
    String id, name,date, pass, email, phone,description;
    byte[] imgarr;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        //imgView = (ImageView) findViewById(R.id.imgView);
        c_name = (EditText) findViewById(R.id.c_name);
        c_date=(EditText) findViewById(R.id.c_date);
        c_pass = (EditText) findViewById(R.id.c_pass);
        c_email = (EditText) findViewById(R.id.c_email);
        c_phone = (EditText) findViewById(R.id.c_phone);
        c_description=(EditText) findViewById(R.id.c_desc);


    }

    public void click(View v) {

        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);//to invoke inbuilt activity to click picture
        startActivityForResult(i, 1);//1 is the request code
    }

    public void insert(View v) {
        // id = c_id.getText().toString();
        //int cid=Integer.parseInt(id);
        // Toast.makeText(this, "test", Toast.LENGTH_SHORT).show();
        name = c_name.getText().toString();
        // Toast.makeText(this, "test", Toast.LENGTH_SHORT).show();
        date = c_date.getText().toString();
        // Toast.makeText(this, "test", Toast.LENGTH_SHORT).show();
        pass = c_pass.getText().toString();
        //Toast.makeText(this, "test", Toast.LENGTH_SHORT).show();
        email = c_email.getText().toString();
        //Toast.makeText(this, "test", Toast.LENGTH_SHORT).show();
        phone = c_phone.getText().toString();
        //Toast.makeText(this, "test", Toast.LENGTH_SHORT).show();
        description = c_description.getText().toString();
        //Toast.makeText(this, "test", Toast.LENGTH_SHORT).show();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.PNG, 100, bos);
        imgarr = bos.toByteArray();

        fAuth=FirebaseAuth.getInstance();

       // if(fAuth.getCurrentUser()!=null)
       // {
           // startActivity(new Intent(getApplicationContext(), MainActivity.class));
          //  finish();
        //}

        if(TextUtils.isEmpty(email)){
            c_email.setError("Email is Required");
            return;
        }

        if(TextUtils.isEmpty(pass)){
            c_pass.setError("Password is Required");
            return;
        }
        if(pass.length() < 6){
            c_pass.setError("password Must be >= 6 Characters");
        }

        //Add User
        fAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(AddUser.this,"User Created.",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                }else{
                    Toast.makeText(AddUser.this,"Error ! "+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
