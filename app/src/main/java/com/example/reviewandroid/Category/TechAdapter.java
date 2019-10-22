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

import com.example.reviewandroid.R;

import java.util.ArrayList;
import java.util.List;

public class TechAdapter extends RecyclerView.Adapter<TechAdapter.ViewHolder> implements Filterable {
    private List<TechNamePic> techList;
    private List<TechNamePic> techListFull;

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
        techListFull = new ArrayList<>(techList);
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

    @Override
    public Filter getFilter() {
        return techFilter;
    }

    private Filter techFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<TechNamePic> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0){
                filteredList.addAll(techListFull);
            }else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (TechNamePic item:techListFull) {
                    if (item.getTech_name().toLowerCase().contains(filterPattern)){
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
            techList.clear();
            techList.addAll((List) results.values);

            notifyDataSetChanged();
        }
    };

}
