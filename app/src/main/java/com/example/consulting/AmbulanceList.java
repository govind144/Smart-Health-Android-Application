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

public class AmbulanceList extends RecyclerView.Adapter<AmbulanceList.MyViewHolder> {

    private static final int REQUEST_CALL=1;
    Context context;
    ArrayList<AmbulanceAdapter> ambulanceAdapters;
    public AmbulanceList(Context c,ArrayList<AmbulanceAdapter> p){
        context=c;
        ambulanceAdapters=p;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AmbulanceList.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_ambulance_cardview,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.name.setText(ambulanceAdapters.get(position).getMName());
        holder.gender.setText(ambulanceAdapters.get(position).getMGender());
        holder.phone.setText(ambulanceAdapters.get(position).getPhoneNo());
        holder.location.setText(ambulanceAdapters.get(position).getDescription());
        holder.btnChat.setVisibility(View.VISIBLE);
        holder.btnCall.setVisibility(View.VISIBLE);

        holder.btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number=ambulanceAdapters.get(position).getPhoneNo();
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
                Toast.makeText(context,"To Chat With Ambulance Driver You Need Admin Authorization"+position,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return ambulanceAdapters.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name,gender,phone,location;
        Button btnCall,btnChat;
        public MyViewHolder(View itemView){
            super(itemView);
            name=(TextView) itemView.findViewById(R.id.name);
            gender=(TextView) itemView.findViewById(R.id.gender);
            phone=(TextView) itemView.findViewById(R.id.phone);
            location=(TextView) itemView.findViewById(R.id.location);
            btnCall=(Button) itemView.findViewById(R.id.call);
            btnChat=(Button) itemView.findViewById(R.id.chat);
        }
    }
}
