package com.example.consulting;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ViewMedicalStore extends AppCompatActivity {

    DatabaseReference dbReferenceUser;
    ArrayList<MedicalAdapter> list;
    private RecyclerView recyclerView;
    MedicalStoreList adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_medicalstore);
        recyclerView = (RecyclerView) findViewById(R.id.medicalRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<MedicalAdapter>();

        dbReferenceUser = FirebaseDatabase.getInstance().getReference().child("medical");
        dbReferenceUser.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    MedicalAdapter p = dataSnapshot1.getValue(MedicalAdapter.class);
                    list.add(p);
                }
                adapter = new MedicalStoreList(ViewMedicalStore.this, list);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }
}
