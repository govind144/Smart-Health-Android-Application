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

public class DoctorList extends RecyclerView.Adapter<DoctorList.MyViewHolder> {
    Context context;
    ArrayList<DoctorAdapter> doctorAdapters;
    private static final int REQUEST_CALL=1;

    public DoctorList(Context c ,ArrayList<DoctorAdapter>p){
        context=c;
        doctorAdapters=p;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DoctorList.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_doctor_cardview,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.dname.setText(doctorAdapters.get(position).getDoctorName());
        holder.dgender.setText(doctorAdapters.get(position).getDoctorGender());
        holder.dtype.setText(doctorAdapters.get(position).getDoctorType());
        holder.symtm.setText(doctorAdapters.get(position).getDoctorsymtm());
        holder.dphone.setText(doctorAdapters.get(position).getPhoneNo());
        holder.btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number=doctorAdapters.get(position).getPhoneNo();
               if(number.trim().length() >  0 ){
                   if(ContextCompat.checkSelfPermission(context,Manifest.permission.CALL_PHONE)!=PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions((Activity) holder.itemView.getContext(),new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
                   }else {
                        String dial = "tel:"+number;
                       Intent intent=new Intent(Intent.ACTION_CALL,Uri.parse(dial));
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
               Toast.makeText(context,"To Chat With Doctor You Need Admin Authorization"+position,Toast.LENGTH_SHORT).show();
           }
        });

       // holder.btnChat.setVisibility(View.VISIBLE);
      //  holder.btnCall.setVisibility(View.VISIBLE);
    }

    @Override
    public int getItemCount() {
        return doctorAdapters.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView dname,dgender,dtype,symtm,dphone;
        Button btnCall,btnChat;
        public MyViewHolder(final View itemView){
            super(itemView);
            dname=(TextView) itemView.findViewById(R.id.name);
            dgender=(TextView) itemView.findViewById(R.id.gender);
            dtype=(TextView) itemView.findViewById(R.id.type);
            symtm=(TextView) itemView.findViewById(R.id.diseases);
            dphone=(TextView) itemView.findViewById(R.id.phone);
            btnCall=(Button) itemView.findViewById(R.id.call);
            btnChat=(Button) itemView.findViewById(R.id.chat);
        }


    }

    public void call(View view)
    {
        Intent intent = new Intent(context, MainForChatActiviy.class);
        context.startActivity(intent);
       // Toast.makeText(v.getContext(), " enter number",Toast.LENGTH_LONG).show();
    }


}
