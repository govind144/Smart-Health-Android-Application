package com.example.consulting;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MedicalStoreList extends RecyclerView.Adapter<MedicalStoreList.MyViewHolder> {

    private static final int REQUEST_CALL=1;
    Context context;
    ArrayList<MedicalAdapter> medicalAdapters;

    public MedicalStoreList(Context c,ArrayList<MedicalAdapter> p){
        context=c;
        medicalAdapters=p;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MedicalStoreList.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_medical_cardview,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.name.setText(medicalAdapters.get(position).getMName());
        holder.gender.setText(medicalAdapters.get(position).getMGender());
        holder.phone.setText(medicalAdapters.get(position).getPhoneNo());
        holder.location.setText(medicalAdapters.get(position).getDescription());
        holder.btnChat.setVisibility(View.VISIBLE);
        holder.btnCall.setVisibility(View.VISIBLE);
        holder.availablemedicine.setVisibility(View.VISIBLE);

        holder.btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number=medicalAdapters.get(position).getPhoneNo();
                if(number.trim().length() >  0 ){
                    if(ContextCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions((Activity) holder.itemView.getContext(),new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
                    }else {
                        String dial = "tel:"+number;
                        Intent intent=new Intent(Intent.ACTION_CALL, Uri.parse(dial));
                        context.startActivity(intent);
                    }
                }else{
                    Toast.makeText(context,"call"+position,Toast.LENGTH_LONG).show();
                }
            }
        });
        holder.btnChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"To Chat With Medical StoreKeeper You Need Admin Authorization"+position,Toast.LENGTH_SHORT).show();
            }
        });
        holder.availablemedicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, SearchMedicine.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return medicalAdapters.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name,gender,phone,location;
        Button btnCall,btnChat,availablemedicine;

        public MyViewHolder(View itemView){
            super(itemView);
            name=(TextView) itemView.findViewById(R.id.name);
            gender=(TextView) itemView.findViewById(R.id.gender);
            phone=(TextView) itemView.findViewById(R.id.phone);
            location=(TextView) itemView.findViewById(R.id.location);
            btnCall=(Button) itemView.findViewById(R.id.call);
            btnChat=(Button) itemView.findViewById(R.id.chat);
            availablemedicine=(Button) itemView.findViewById(R.id.availablemedicine);
        }
    }
}
