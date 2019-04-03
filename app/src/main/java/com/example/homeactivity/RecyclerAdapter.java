package com.example.homeactivity;


import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private List<RecyclerData> list;
    private Context mContext;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView imageView;
        public MyViewHolder(View view) {
            super(view);
            textView=view.findViewById(R.id.tigertextview);
            imageView=view.findViewById(R.id.tigerimageview);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContext, ""+textView.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }


    public RecyclerAdapter(Context mContext,List<RecyclerData> list) {
        this.list=list;
        this.mContext=mContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.horizontal_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        RecyclerData recyclerData = list.get(position);
        holder.imageView.setImageResource(recyclerData.getDrawable());
        holder.textView.setText(recyclerData.getName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}