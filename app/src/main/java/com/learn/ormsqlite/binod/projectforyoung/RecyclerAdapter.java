package com.learn.ormsqlite.binod.projectforyoung;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;

import java.util.List;

/**
 * Created by binod on 8/24/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHoler>{
    private List<JsonResponse> jsonResponses;
    Context context;

    public RecyclerAdapter(Context context , List<JsonResponse> jsonResponses)
    {
        this.jsonResponses=jsonResponses;
        this.context=context;
    }
    @Override
    public MyViewHoler onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);
        return new MyViewHoler(view);
    }

    @Override
    public void onBindViewHolder(MyViewHoler holder,final int position) {
        holder.nam.setText(jsonResponses.get(position).getTitle());
        holder.emil.setText(jsonResponses.get(position).getBody());
        holder.root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               context.startActivity(new Intent(context,Detail.class).putExtra("id", jsonResponses.get(position).getId()));
                //Toast.makeText(context, "Item id is:"+jsonResponses.get(position).getId().toString(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return jsonResponses.size();
    }

    public class MyViewHoler extends RecyclerView.ViewHolder{
        private TextView nam,emil;
        private LinearLayout root;

        public MyViewHoler(View itemView) {
            super(itemView);
            nam=(TextView)itemView.findViewById(R.id.name);
            emil=(TextView)itemView.findViewById(R.id.email);
            root=(LinearLayout)itemView.findViewById(R.id.root);
        }
    }
}
