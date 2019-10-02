package com.example.reviewandroid.Category;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reviewandroid.R;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {
    private List<MenuNamePic> menuList;

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView tv_menu_name;
        public ImageView iv_menu_photo;

        public ViewHolder(@NonNull View v) {
            super(v);
            tv_menu_name = v.findViewById(R.id.tv_menu_name);
            iv_menu_photo = v. findViewById(R.id.iv_menu_photo);


        }
    }

    public MenuAdapter(List<MenuNamePic> menuList){
        this.menuList = menuList;

    }

    public MenuAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.contain_recycler_menu,parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;


    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull List<Object> payloads) {
        MenuNamePic oto = menuList.get(position);
        holder.tv_menu_name.setText(oto.getMenu_name());
        holder.iv_menu_photo.setImageResource(oto.getMenu_pic());
        }

    public int getItemCount(){
        return menuList.size();
    }


}
