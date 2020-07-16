package com.example.consulting;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

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

public class PatientChatActivity extends AppCompatActivity {

    ImageView send_image,message_send_button;
    EditText send_text_message;
    DatabaseReference dbReferenceUser;
    ArrayList<AmbulanceAdapter> list;
    private RecyclerView recyclerView;
    AmbulanceList adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_chat);
        recyclerView = (RecyclerView) findViewById(R.id.message_list);
        send_image=(ImageView) findViewById(R.id.send_image);
        send_text_message =(EditText) findViewById(R.id.send_text_message);
        message_send_button =(ImageView) findViewById(R.id.message_send_button);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
