package com.example.consulting;

import android.os.Bundle;
import androidx.appcompat.widget.SearchView;
//import android.app.SearchManager;
//import android.widget.SearchView.OnQueryTextListener;

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

public class Searchdoctor extends AppCompatActivity {

    DatabaseReference dbReferenceUser;
    ArrayList<DoctorAdapter> doctor;
    private RecyclerView recyclerViewDoctor;
    DoctorList adapter;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_doctor);
        recyclerViewDoctor = (RecyclerView) findViewById(R.id.doctorRecyclerView);
        // recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerViewDoctor.setLayoutManager(manager);
        recyclerViewDoctor.setHasFixedSize(true);
        doctor = new ArrayList<DoctorAdapter>();
        searchView=findViewById(R.id.searchView);

        dbReferenceUser = FirebaseDatabase.getInstance().getReference().child("doctors");
        dbReferenceUser.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    DoctorAdapter d = dataSnapshot1.getValue(DoctorAdapter.class);
                    doctor.add(d);
                }
                adapter = new DoctorList(Searchdoctor.this, doctor);
                recyclerViewDoctor.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                search(s);
                return true;
            }
        });


    }

    private void search(String str) {
        ArrayList<DoctorAdapter> docAdapters = new ArrayList<DoctorAdapter>();
        for(DoctorAdapter object:doctor){
            if(object.getDoctorsymtm().toLowerCase().contains(str.toLowerCase())){
                docAdapters.add(object);
            }
            DoctorList adapters = new DoctorList(Searchdoctor.this, docAdapters);
            recyclerViewDoctor.setAdapter(adapters);
        }

    }
}
