package com.example.consulting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MedicineList extends RecyclerView.Adapter<MedicineList.MyViewHolder> {
    Context context;
    ArrayList<MedicineAdapter> medicineAdapter;

    public MedicineList(Context c, ArrayList<MedicineAdapter>p){
        context=c;
        medicineAdapter=p;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MedicineList.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.medicine_list,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.medicinename.setText(medicineAdapter.get(position).getMedicineName());
        holder.medicineproperties.setText(medicineAdapter.get(position).getMedicineProperties());
    }

    @Override
    public int getItemCount() {
        return medicineAdapter.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView medicinename,medicineproperties;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            medicinename=(TextView) itemView.findViewById(R.id.medicinename);
            medicineproperties=(TextView) itemView.findViewById(R.id.medicineproperties);
        }
    }

}
