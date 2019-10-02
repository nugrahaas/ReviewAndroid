package com.example.reviewandroid.Category;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.reviewandroid.R;

import java.util.List;

public class OtomotifAdapter extends RecyclerView.Adapter<OtomotifAdapter.ViewHolder> {
    private List<OtomotifNamePic> otomotifList;

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView tv_oto_name;
        public ImageView iv_oto_photo;

        public ViewHolder(@NonNull View v) {
            super(v);
            tv_oto_name = v.findViewById(R.id.tv_oto_name);
            iv_oto_photo = v. findViewById(R.id.iv_oto_photo);


        }
    }

    public OtomotifAdapter(List<OtomotifNamePic> otomotifList){
        this.otomotifList = otomotifList;

    }

    public OtomotifAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.contain_recycler_otomotif,parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;


    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull List<Object> payloads) {
        OtomotifNamePic oto = otomotifList.get(position);
        holder.tv_oto_name.setText(oto.getOtomotif_name());
        holder.iv_oto_photo.setImageResource(oto.getPic());
        }

    public int getItemCount(){
        return otomotifList.size();
    }


}
