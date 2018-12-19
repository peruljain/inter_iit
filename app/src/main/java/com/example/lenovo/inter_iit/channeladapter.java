package com.example.lenovo.inter_iit;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class channeladapter extends RecyclerView.Adapter<channeladapter.channelviewholder> {

    private Context mtcx;
    List<channel> channelList;

    public channeladapter(Context mtcx, List<channel> channelList) {
        this.mtcx = mtcx;
        this.channelList = channelList;
    }

    @NonNull
    @Override
    public channelviewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mtcx);
        View view = inflater.inflate(R.layout.card, null);
        return new channelviewholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull channelviewholder channelviewholder, int i) {
       channel channel = channelList.get(i);
       channelviewholder.textView.setText(channel.getTitle());
        Glide.with(mtcx).load(channel.getImg()).into(channelviewholder.imageView);




    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class channelviewholder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;

        public channelviewholder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            textView = itemView.findViewById(R.id.title);
        }
    }
}
