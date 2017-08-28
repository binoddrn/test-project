package com.learn.ormsqlite.binod.projectforyoung;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by binod on 8/28/2017.
 */

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.MyViewHolder>{
    private List<Detailresponse> jsonResponses;
    Context context;

    public DetailAdapter(List<Detailresponse> jsonResponses, Context context) {
        this.jsonResponses = jsonResponses;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_detail,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.Body.setText(jsonResponses.get(position).getBody());
        holder.Name.setText(jsonResponses.get(position).getName());
        holder.Email.setText(jsonResponses.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return jsonResponses.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView Body,Name,Email;
        private LinearLayout root;
        public MyViewHolder(View itemView) {
            super(itemView);
            Body=(TextView)itemView.findViewById(R.id.body);
            Email=(TextView)itemView.findViewById(R.id.email);
            Name=(TextView)itemView.findViewById(R.id.name);
            root=(LinearLayout)itemView.findViewById(R.id.root);
        }
    }
}
