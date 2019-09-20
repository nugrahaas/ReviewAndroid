package com.example.reviewandroid;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Genre> genreList;
    private GenreAdapter genreAdapter;


    String[] arrayTujuan = {
            "Otomotif", "Tech", "Dapur"
    };
    String[] genre_names = {
            "Otomotif", "Tech", "Dapur"};
    int[] pics = {
            R.drawable.motoy,
            R.drawable.smatpoy,
            R.drawable.dapuy
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recycler_view_genre);
        if (mRecyclerView != null) {
            mRecyclerView.setHasFixedSize(true);

        }

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        genreList = new ArrayList<>();

        for (int i = 0; i < genre_names.length; i++) {
            Genre genre = new Genre(genre_names[i], pics[i]);
            genreList.add(genre);

        }

        genreAdapter = new GenreAdapter(genreList);

        mRecyclerView.setAdapter(genreAdapter);
        genreAdapter.notifyDataSetChanged();

        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                position += 1;
                Toast.makeText(MainActivity.this, "Card at " + position + 1 + " is clicked", Toast.LENGTH_SHORT).show();

                if (position == 1) {
                    Intent intent = new Intent(MainActivity.this, Otomotif.class);
                    startActivity(intent);
                } else if (position == 2) {
                    Intent intent = new Intent(MainActivity.this, Tech.class);
                    startActivity(intent);
                } else if (position == 3) {
                    Intent intent = new Intent(MainActivity.this, Dapur.class);
                    startActivity(intent);
                }
            }

        }));


    }


}
