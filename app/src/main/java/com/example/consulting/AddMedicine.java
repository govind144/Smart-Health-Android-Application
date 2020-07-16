package com.example.consulting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.StorageReference;

public class AddMedicine extends AppCompatActivity {

    EditText medicine_name, medicine_properties,medicine_function,medecine_detail;
    String m_name, m_properties,m_function,m_detail;
    StorageReference storageReference;
    FirebaseAuth fAuth;
    DatabaseReference dbReferenceUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicinedetail);
        //imgView = (ImageView) findViewById(R.id.imgView);
        medicine_name = (EditText) findViewById(R.id.medicine_name);
        medicine_properties = (EditText) findViewById(R.id.medicine_properties);
        medicine_function = (EditText) findViewById(R.id.medicine_function);
        medecine_detail = (EditText) findViewById(R.id.medecine_detail);

    }

    public void insert(View v) {
        m_name = medicine_name.getText().toString();
        // Toast.makeText(this, "test", Toast.LENGTH_SHORT).show();
        m_properties = medicine_properties.getText().toString();
        m_function = medicine_function.getText().toString();
        m_detail = medecine_detail.getText().toString();

        fAuth=FirebaseAuth.getInstance();
        dbReferenceUser = FirebaseDatabase.getInstance().getReference("medicinedetail");
        String id = dbReferenceUser.push().getKey();

        MedicineAdapter medicine =new MedicineAdapter(m_name,m_properties,m_function,m_detail);
        dbReferenceUser.child(id).setValue(medicine);

        Toast.makeText(AddMedicine.this,"Medicine Added Successfully.",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(),MedicalStoreRights.class));
    }
}
