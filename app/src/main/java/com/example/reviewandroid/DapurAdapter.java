package com.example.reviewandroid;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DapurAdapter extends RecyclerView.Adapter<DapurAdapter.ViewHolder> {
    private List<DapurNamePic> dapurTechList;

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView tv_dapur_name;
        public ImageView iv_dapur_photo;

        public ViewHolder(@NonNull View v) {
            super(v);
            tv_dapur_name = v.findViewById(R.id.tv_dapur_name);
            iv_dapur_photo = v. findViewById(R.id.iv_dapur_photo);


        }
    }

    public DapurAdapter(List<DapurNamePic> dapurTechList){
        this.dapurTechList = dapurTechList;

    }

    public DapurAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.contain_recycler_dapur,parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;


    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull List<Object> payloads) {
        DapurNamePic dapur = dapurTechList.get(position);
        holder.tv_dapur_name.setText(dapur.getDapur_name());
        holder.iv_dapur_photo.setImageResource(dapur.getPic());
        }

    public int getItemCount(){
        return dapurTechList.size();
    }


}
