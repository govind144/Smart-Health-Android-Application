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

public class AddMedicalStore extends AppCompatActivity {

    public static final int CAMERA_REQUEST_CODE=102;
    public static final int CAMERA_PERM_CODE=101;
    String currentPhotoPath;
    //ImageView imgView;
    EditText c_name, c_date, c_pass, c_email, c_phone, c_description;
    Bitmap bm;
    Button btnCamera;
    Spinner spinnergender;
    String id, name, date, pass, email, phone, description, gender,permission;
    byte[] imgarr;
    String[] c_gender = {"Female", "Male"};
    StorageReference storageReference;
    FirebaseAuth fAuth;
    DatabaseReference dbReferenceUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medicalstore);
        //imgView = (ImageView) findViewById(R.id.imgView);
        c_name = (EditText) findViewById(R.id.c_name);
        c_date = (EditText) findViewById(R.id.c_date);
        c_pass = (EditText) findViewById(R.id.c_pass);
        c_email = (EditText) findViewById(R.id.c_email);
        c_phone = (EditText) findViewById(R.id.c_phone);
        c_description = (EditText) findViewById(R.id.c_desc);
        spinnergender = (Spinner) findViewById(R.id.spinner);
       // btnCamera=(Button) findViewById(R.id.btnCamera);
       // btnCamera.setVisibility(View.INVISIBLE);

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
        gender = spinnergender.getSelectedItem().toString();
        permission="P";
        //Toast.makeText(this, "test", Toast.LENGTH_SHORT).show();

        fAuth=FirebaseAuth.getInstance();

        if(fAuth.getCurrentUser()!=null)
        {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

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
                    dbReferenceUser = FirebaseDatabase.getInstance().getReference("medical");
                    String id = dbReferenceUser.push().getKey();
                    MedicalAdapter medicalAdapter = new MedicalAdapter(id,gender,name,date,pass,email,phone,description,permission);
                   // UserAdapter userAdapter=new UserAdapter(id,name,gender,date,phone);
                    dbReferenceUser.child(id).setValue(medicalAdapter);

                    Toast.makeText(AddMedicalStore.this,"User Created.",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                }else{
                    Toast.makeText(AddMedicalStore.this,"Error ! "+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
