package com.example.reviewandroid.Category;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.reviewandroid.LayoutActivity.Menu;
import com.example.reviewandroid.LayoutActivity.Post;
import com.example.reviewandroid.R;
import com.example.reviewandroid.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class Otomotif extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<OtomotifNamePic> otomotifList;
    private OtomotifAdapter otomotifAdapter;
    private SearchView searchView;

    String[] arrayTujuan = {
            "Motor", "Mobil", "Bus", "Truk"
    };
    String[] oto_names = {
            "Motor", "Mobil", "Bus", "Truk"
    };
    int[] oto_pics = {
            R.drawable.motoy,
            R.drawable.mobil,
            R.drawable.bus,
            R.drawable.truk,

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otomotif);

        searchView = findViewById(R.id.sv_main);
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
//        searchView = getSearchEvent();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                otomotifAdapter.getFilter().filter(newText);
                return false;
            }
        });

        mRecyclerView = findViewById(R.id.recycler_view_oto);
        if (mRecyclerView != null) {
            mRecyclerView.setHasFixedSize(true);

        }

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        otomotifList = new ArrayList<>();

        for (int i = 0; i < oto_names.length; i++) {
            OtomotifNamePic oto = new OtomotifNamePic(oto_names[i], oto_pics[i]);
            otomotifList.add(oto);

        }

        otomotifAdapter = new OtomotifAdapter(otomotifList);

        mRecyclerView.setAdapter(otomotifAdapter);
        otomotifAdapter.notifyDataSetChanged();

        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(Otomotif.this, "Card at " + position + 1 + " is clicked", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Otomotif.this, Menu.class);
                startActivity(intent);


            }
        }));

    }
}
