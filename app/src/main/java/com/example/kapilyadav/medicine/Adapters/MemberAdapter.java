package com.example.kapilyadav.medicine.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kapilyadav.medicine.Data.Member;
import com.example.kapilyadav.medicine.R;

import java.util.ArrayList;

/**
 * Created by Kapil Yadav on 05-07-2017.
 */

public class MemberAdapter extends RecyclerView.Adapter<MemberAdapter.MemberHolder>{

        Context context;
        ArrayList<Member> Members;
    ItemClickListener icl;

        public MemberAdapter(Context context, ArrayList<Member> Members) {
            this.context = context;
            this.Members = Members;
        }
        public void update(ArrayList<Member> newArray)
        {
            this.Members=newArray;

        }
        public void setOnItemClickListener(ItemClickListener icl)
        {
            this.icl=icl;
        }

        @Override
        public MemberHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater li= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view=li.inflate(R.layout.member,parent,false);
            return  new MemberHolder(view);

        }


    @Override
        public void onBindViewHolder(MemberHolder holder, int position) {
            Member thisMember=Members.get(position);
            holder.tvMember.setText(thisMember.getName());
            holder.tvGender.setText(thisMember.getGender());
            holder.tvAge.setText(thisMember.getAge());
            holder.thisView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                        icl.OnClick();
                }
            });

        }

        @Override
        public int getItemCount() {
            return Members.size();
        }

        class MemberHolder extends RecyclerView.ViewHolder {
            TextView tvMember,tvGender,tvAge;
            View thisView;
            public MemberHolder(View itemView) {
                super(itemView);
                tvMember =(TextView)itemView.findViewById(R.id.tvMember);
                tvGender =(TextView)itemView.findViewById(R.id.tvGender);
                tvAge =(TextView)itemView.findViewById(R.id.tvAge);
                thisView=(View)itemView.findViewById(R.id.vMember);
            }
        }
    }

