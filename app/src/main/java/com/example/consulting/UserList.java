package com.example.consulting;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class UserList extends RecyclerView.Adapter<UserList.MyViewHolder>{

    Context context;
    ArrayList<UserAdapter> userAdapters;

    public UserList(Context c, ArrayList<UserAdapter> p){
        context=c;
        userAdapters=p;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.list_layout_users,parent,false));
        
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(userAdapters.get(position).getUserName());
        holder.gender.setText(userAdapters.get(position).getUserGender());
        holder.phone.setText(userAdapters.get(position).getPhoneNo());
        holder.date.setText(userAdapters.get(position).getUserDOB());
    }

    @Override
    public int getItemCount() {
        return userAdapters.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name,gender,phone,date;
         public MyViewHolder(View itemView){
             super(itemView);
             name=(TextView) itemView.findViewById(R.id.name);
             gender=(TextView) itemView.findViewById(R.id.gender);
             phone=(TextView) itemView.findViewById(R.id.phone);
             date=(TextView) itemView.findViewById(R.id.date);
         }
     }
}

