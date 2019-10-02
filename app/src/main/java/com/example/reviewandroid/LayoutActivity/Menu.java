package com.example.reviewandroid.LayoutActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reviewandroid.Category.MenuAdapter;
import com.example.reviewandroid.Category.MenuNamePic;
import com.example.reviewandroid.Category.OtomotifAdapter;
import com.example.reviewandroid.Category.OtomotifNamePic;
import com.example.reviewandroid.R;
import com.example.reviewandroid.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class Menu extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<MenuNamePic> otomotifList;
    private MenuAdapter otomotifAdapter;

    String[] arrayTujuan={
            "Motor", "Mobil", "Bus", "Truk"
    };
    String[] oto_names= {
            "Honda CB 125", "Kawasaki W 175", "Honda KLX", "Yamaha Duarr"
    };
    int[] oto_pics = {
            R.drawable.motoy,
            R.drawable.motoy,
            R.drawable.motoy,
            R.drawable.motoy

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        mRecyclerView = findViewById(R.id.recycler_view_menu);
        if (mRecyclerView != null){
            mRecyclerView.setHasFixedSize(true);

        }

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        otomotifList= new ArrayList<>();

        for (int i = 0; i < oto_names.length; i++){
            MenuNamePic oto = new MenuNamePic(oto_names[i], oto_pics[i]);
            otomotifList.add(oto);

        }

        otomotifAdapter = new MenuAdapter(otomotifList);

        mRecyclerView.setAdapter(otomotifAdapter);
        otomotifAdapter.notifyDataSetChanged();

        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText( Menu.this , "Card at " + position + 1+ " is clicked", Toast.LENGTH_SHORT).show();

                if (position == 0) {
                    Intent intent = new Intent(Menu.this, Post.class);
                    startActivity(intent);
                }

            }
        }));

    }
}
