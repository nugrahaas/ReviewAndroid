package com.example.reviewandroid.Category;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.reviewandroid.Genre;
import com.example.reviewandroid.R;

import java.util.ArrayList;
import java.util.List;

public class DapurAdapter extends RecyclerView.Adapter<DapurAdapter.ViewHolder> implements Filterable {
    private List<DapurNamePic> dapurTechList;
    private List<DapurNamePic> dapurTechListFull;

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
        dapurTechListFull = new ArrayList<>(dapurTechList);
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

    @Override
    public Filter getFilter() {
        return dapurFilter;
    }

    private Filter dapurFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<DapurNamePic> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0){
                filteredList.addAll(dapurTechListFull);
            }else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (DapurNamePic item:dapurTechListFull) {
                    if (item.getDapur_name().toLowerCase().contains(filterPattern)){
                        filteredList.add(item);
                    }
                }

            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;

        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            dapurTechList.clear();
            dapurTechList.addAll((List) results.values);

            notifyDataSetChanged();
        }
    };

}
