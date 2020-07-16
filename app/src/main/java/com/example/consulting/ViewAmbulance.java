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

public class ViewAmbulance extends AppCompatActivity {

    DatabaseReference dbReferenceUser;
    ArrayList<AmbulanceAdapter> list;
    private RecyclerView recyclerView;
    AmbulanceList adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_ambulance);
        recyclerView = (RecyclerView) findViewById(R.id.ambulanceRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<AmbulanceAdapter>();

        dbReferenceUser = FirebaseDatabase.getInstance().getReference().child("ambulance");
        dbReferenceUser.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    AmbulanceAdapter a = dataSnapshot1.getValue(AmbulanceAdapter.class);
                    list.add(a);
                }
                adapter = new AmbulanceList(ViewAmbulance.this, list);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }
}
