package com.example.kapilyadav.medicine.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kapilyadav.medicine.Data.Disease;
import com.example.kapilyadav.medicine.R;

import java.util.ArrayList;

/**
 * Created by Kapil Yadav on 05-07-2017.
 */

public class DiseaseAdapter extends RecyclerView.Adapter<DiseaseAdapter.DiseaseHolder> {
   ArrayList<Disease> diseases;
    Context context;
    ItemClickListener icl;

    public DiseaseAdapter(ArrayList<Disease> diseases, Context context) {
        this.diseases = diseases;
        this.context = context;
    }
    public void updateData(ArrayList<Disease> newArray)
    {   Log.d("trt",newArray.get(newArray.size()-1).getIllness());
        this.diseases=newArray;
        Log.d("trt",diseases.get(newArray.size()-1).getIllness());
        notifyDataSetChanged();
    }
    public  void OnItemClickListener(ItemClickListener icl)
    {
        this.icl=icl;
    }


    @Override
    public DiseaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d("wet","OnCreate");
        LayoutInflater li= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=li.inflate(R.layout.disease,parent,false);
        return  new DiseaseHolder(view);
    }

    @Override
    public void onBindViewHolder(DiseaseHolder holder, int position) {
        Log.d("wet","OnBind");
    Disease thisDisease=diseases.get(position);
        holder.tvDisease.setText(thisDisease.getIllness());
        holder.tvPrecaution.setText(thisDisease.getPrecautions());
        holder.thisView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icl.OnClick();
            }
        });

    }

    @Override
    public int getItemCount() {
        Log.d("Size",String.valueOf(diseases.size()));
        return diseases.size();
    }

    class DiseaseHolder extends RecyclerView.ViewHolder {
        TextView tvDisease,tvPrecaution;
        View thisView;
        public DiseaseHolder(View itemView) {
            super(itemView);
            Log.d("wet","OnConstructor");
            tvDisease=(TextView)itemView.findViewById(R.id.tvdisease);
            tvPrecaution=(TextView)itemView.findViewById(R.id.tvPrecaution);
            thisView=itemView.findViewById(R.id.layout_disease);

        }
    }
}
