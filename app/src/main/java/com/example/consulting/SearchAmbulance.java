package com.example.consulting;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SearchAmbulance extends AppCompatActivity {

    DatabaseReference dbReferenceUser;
    ArrayList<AmbulanceAdapter> list;
    private RecyclerView recyclerView;
    AmbulanceList adapter;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_ambulance);
        recyclerView = (RecyclerView) findViewById(R.id.ambulanceRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<AmbulanceAdapter>();
        searchView=findViewById(R.id.searchView);

        dbReferenceUser = FirebaseDatabase.getInstance().getReference().child("ambulance");
        dbReferenceUser.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    AmbulanceAdapter a = dataSnapshot1.getValue(AmbulanceAdapter.class);
                    list.add(a);
                }
                adapter = new AmbulanceList(SearchAmbulance.this, list);
                recyclerView.setAdapter(adapter);
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
        ArrayList<AmbulanceAdapter> docAdapters = new ArrayList<AmbulanceAdapter>();
        for(AmbulanceAdapter object:list){
            if(object.getDescription().toLowerCase().contains(str.toLowerCase())){
                docAdapters.add(object);
            }
            AmbulanceList adapters = new AmbulanceList(SearchAmbulance.this, docAdapters);
            recyclerView.setAdapter(adapters);
        }

    }
}
