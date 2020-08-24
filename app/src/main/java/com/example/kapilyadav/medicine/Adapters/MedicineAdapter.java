package com.example.kapilyadav.medicine.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kapilyadav.medicine.Data.MedicineList;
import com.example.kapilyadav.medicine.Data.Member;
import com.example.kapilyadav.medicine.R;

import java.util.ArrayList;

/**
 * Created by Kapil Yadav on 05-07-2017.
 */

public class MedicineAdapter extends RecyclerView.Adapter<MedicineAdapter.MedicineHolder>{

    private Context context;
    private ArrayList<MedicineList> medicines;
    private ItemClickListener icl;

    public MedicineAdapter(Context context, ArrayList<MedicineList> medicines) {
        this.context = context;
        this.medicines = medicines;
    }
    public void update(ArrayList<MedicineList> newArray)
    {
        this.medicines=newArray;

    }
    public void setOnItemClickListener(ItemClickListener icl)
    {
        this.icl=icl;
    }

    @Override
    public MedicineHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=li.inflate(R.layout.medicine,parent,false);
        return  new MedicineHolder(view);

    }


    @Override
    public void onBindViewHolder(MedicineHolder holder, int position) {
        MedicineList thisMedicine=medicines.get(position);

       holder.tvPrecaution.setText(thisMedicine.getSpecialMention());
        holder.tvMedicine.setText(thisMedicine.getMedicine());
        if(thisMedicine.getBreakfast())
            holder.tvMorning.setText("Morning");
        if(thisMedicine.getLunch())
            holder.tvNoon.setText("Noon");
        if(thisMedicine.getDinner())
            holder.tvNight.setText("Night");

    }

    @Override
    public int getItemCount() {
        return medicines.size();
    }

    class MedicineHolder extends RecyclerView.ViewHolder {
        TextView tvMedicine,tvPrecaution,tvMorning,tvNoon,tvNight;
        View thisView;
        public MedicineHolder(View itemView) {
            super(itemView);
            tvMedicine =(TextView)itemView.findViewById(R.id.tvMedicineName);
            tvPrecaution =(TextView)itemView.findViewById(R.id.tvSpecialMention);
           tvMorning =(TextView)itemView.findViewById(R.id.tvMorning);
            tvNoon=(TextView)itemView.findViewById(R.id.tvNoon);
            tvNight=(TextView)itemView.findViewById(R.id.tvNight);
            //thisView=(View)itemView.findViewById(R.id.vMember);
        }
    }
}

