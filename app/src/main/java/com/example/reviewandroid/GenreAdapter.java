package com.example.reviewandroid;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GenreAdapter extends RecyclerView.Adapter<GenreAdapter.ViewHolder> implements Filterable {
    private List<Genre> genreList;
    private List<Genre> genreListFull;

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView tv_genre_name;
        public ImageView iv_genre_photo;

        public ViewHolder(@NonNull View v) {
            super(v);
            tv_genre_name = v.findViewById(R.id.tv_genre_name);
            iv_genre_photo = v. findViewById(R.id.iv_genre_photo);


        }
    }

    public GenreAdapter(List<Genre> genreList){
        this.genreList = genreList;
        genreListFull = new ArrayList<>(genreList);
    }

    public GenreAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.contain_recycler_home,parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;


    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull List<Object> payloads) {
        Genre genre = genreList.get(position);
        holder.tv_genre_name.setText(genre.getGenre_name());
        holder.iv_genre_photo.setImageResource(genre.getPic());
        }

    public int getItemCount(){
        return genreList.size();
    }

    @Override
    public Filter getFilter() {
        return genreFilter;
    }

    private Filter genreFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Genre> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0){
                filteredList.addAll(genreListFull);
            }else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Genre item:genreListFull) {
                    if (item.getGenre_name().toLowerCase().contains(filterPattern)){
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
            genreList.clear();
            genreList.addAll((List) results.values);

            notifyDataSetChanged();
        }
    };

}
