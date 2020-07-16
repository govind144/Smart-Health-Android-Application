package com.example.consulting;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DoctorChatAdapter extends RecyclerView.Adapter<DoctorChatAdapter.ViewHolder> {
    private Context mContext;
    private List<DoctorAdapter> mUsers;

    public DoctorChatAdapter(Context mContext,List<DoctorAdapter> mUsers){
        this.mUsers=mUsers;
        this.mContext=mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.user_item,parent,false);
        return new DoctorChatAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final DoctorAdapter user=mUsers.get(position);
        holder.username.setText(user.getDoctorName());
        holder.profile_image.setImageResource(R.mipmap.ic_launcher);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext,MessageActivity.class);
                intent.putExtra("doctorID",user.getDoctorID());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView username;
        public ImageView profile_image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            username = itemView.findViewById(R.id.username);
            profile_image=itemView.findViewById(R.id.profile_Image);
        }
    }
}
