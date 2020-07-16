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

public class SearchMedicalStore extends AppCompatActivity {

    DatabaseReference dbReferenceUser;
    ArrayList<MedicalAdapter> list;
    private RecyclerView recyclerView;
    MedicalStoreList adapter;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_medicalstore);
        recyclerView = (RecyclerView) findViewById(R.id.mRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<MedicalAdapter>();
        searchView=findViewById(R.id.searchView);

        dbReferenceUser = FirebaseDatabase.getInstance().getReference().child("medical");
        dbReferenceUser.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    MedicalAdapter p = dataSnapshot1.getValue(MedicalAdapter.class);
                    list.add(p);
                }
                adapter = new MedicalStoreList(SearchMedicalStore.this, list);
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
        ArrayList<MedicalAdapter> docAdapters = new ArrayList<MedicalAdapter>();
        for(MedicalAdapter object:list){
            if(object.getDescription().toLowerCase().contains(str.toLowerCase())){
                docAdapters.add(object);
            }
            MedicalStoreList adapters = new MedicalStoreList(SearchMedicalStore.this, docAdapters);
            recyclerView.setAdapter(adapters);
        }
    }
}
