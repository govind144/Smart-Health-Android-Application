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

public class SearchMedicine extends AppCompatActivity {

    DatabaseReference dbReferenceUser;
    ArrayList<MedicineAdapter> medicine;
    private RecyclerView recyclerViewMedicine;
    MedicineList adapter;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_medicine);
        recyclerViewMedicine = (RecyclerView) findViewById(R.id.medicineRecyclerView);
        // recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerViewMedicine.setLayoutManager(manager);
        recyclerViewMedicine.setHasFixedSize(true);
        medicine = new ArrayList<MedicineAdapter>();
        searchView=findViewById(R.id.searchView);

        dbReferenceUser = FirebaseDatabase.getInstance().getReference().child("medicinedetail");
        dbReferenceUser.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    MedicineAdapter d = dataSnapshot1.getValue(MedicineAdapter.class);
                    medicine.add(d);
                }
                adapter = new MedicineList(SearchMedicine.this, medicine);
                recyclerViewMedicine.setAdapter(adapter);
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
        ArrayList<MedicineAdapter> medicineAdapters = new ArrayList<MedicineAdapter>();
        for(MedicineAdapter object:medicine){
            if(object.getMedicineName().toLowerCase().contains(str.toLowerCase())){
                medicineAdapters.add(object);
            }
            MedicineList adapters = new MedicineList(SearchMedicine.this, medicineAdapters);
            recyclerViewMedicine.setAdapter(adapters);
        }

    }
}
