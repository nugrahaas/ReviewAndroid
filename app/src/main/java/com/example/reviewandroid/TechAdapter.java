package com.example.reviewandroid;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TechAdapter extends RecyclerView.Adapter<TechAdapter.ViewHolder> {
    private List<TechNamePic> techList;

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView tv_tech_name;
        public ImageView iv_tech_photo;

        public ViewHolder(@NonNull View v) {
            super(v);
            tv_tech_name = v.findViewById(R.id.tv_tech_name);
            iv_tech_photo = v. findViewById(R.id.iv_tech_photo);


        }
    }

    public TechAdapter(List<TechNamePic> techList){
        this.techList = techList;

    }

    public TechAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.contain_recycler_tech,parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;


    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull List<Object> payloads) {
        TechNamePic tech = techList.get(position);
        holder.tv_tech_name.setText(tech.getTech_name());
        holder.iv_tech_photo.setImageResource(tech.getPic());
        }

    public int getItemCount(){
        return techList.size();
    }


}
