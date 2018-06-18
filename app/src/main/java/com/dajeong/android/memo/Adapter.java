package com.dajeong.android.memo;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.Holder>{

    List<Memo> list;
    SimpleDateFormat sdf;

    public void setData(List<Memo> list){
        this.list = list;
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        notifyDataSetChanged();
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {

        Memo memo = list.get(position);

        holder.textId.setText(memo.id+"");
        holder.textTitle.setText(memo.title);
        holder.textDate.setText(sdf.format(memo.date)+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder{

        TextView textId, textTitle, textDate;
        Button btnDelete;
        ConstraintLayout item;

        public Holder(View itemView){
            super(itemView);
            textId = itemView.findViewById(R.id.textId);
            textTitle = itemView.findViewById(R.id.textTitle);
            textDate = itemView.findViewById(R.id.textDate);
            btnDelete = itemView.findViewById(R.id.btnDelete);
            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    //String deleteQuery = "delete from memo where"+textId =
                }
            });
            item = itemView.findViewById(R.id.item);
        }
    }
}
