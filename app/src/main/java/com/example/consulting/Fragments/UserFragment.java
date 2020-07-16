package com.example.consulting.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.consulting.DoctorAdapter;
import com.example.consulting.DoctorChatAdapter;
import com.example.consulting.R;
import com.example.consulting.UserAdapter;
import com.example.consulting.UserCAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class UserFragment extends Fragment {

    private RecyclerView recyclerView;
    private DoctorChatAdapter doctorCAdapter;
    private List<DoctorAdapter> mUsers;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_user, container, false);
        recyclerView=view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        mUsers=new ArrayList<>();

        readUsers();

        return view;
    }

    private void readUsers() {
        final FirebaseUser firebaseUser= FirebaseAuth.getInstance().getCurrentUser();
        DatabaseReference reference= FirebaseDatabase.getInstance().getReference("doctors");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mUsers.clear();
                for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                    DoctorAdapter user=dataSnapshot1.getValue(DoctorAdapter.class);

                    assert user!=null;
                    assert firebaseUser!=null;
                    if(!user.getDoctorID().equals(firebaseUser.getUid())){
                        mUsers.add(user);
                    }
                }
                doctorCAdapter=new DoctorChatAdapter(getContext(),mUsers);
                recyclerView.setAdapter(doctorCAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
