package com.example.reviewandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Otomotif extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<OtomotifNamePic> otomotifList;
    private OtomotifAdapter otomotifAdapter;

    String[] arrayTujuan={
            "Motor", "Mobil", "Bus", "Truk"
    };
    String[] oto_names= {
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

        mRecyclerView = findViewById(R.id.recycler_view_oto);
        if (mRecyclerView != null){
            mRecyclerView.setHasFixedSize(true);

        }

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        otomotifList= new ArrayList<>();

        for (int i = 0; i < oto_names.length; i++){
            OtomotifNamePic oto = new OtomotifNamePic(oto_names[i], oto_pics[i]);
            otomotifList.add(oto);

        }

        otomotifAdapter = new OtomotifAdapter(otomotifList);

        mRecyclerView.setAdapter(otomotifAdapter);
        otomotifAdapter.notifyDataSetChanged();

        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText( Otomotif.this , "Card at " + position + 1+ " is clicked", Toast.LENGTH_SHORT).show();
//                for (int i = 0; i<3;i++){
//                    if (i == 0){
//                        Intent intent = new Intent(Otomotif.this, Otomotif.class);
//                        startActivity(intent);
//                    }else if (i == 1){
//                        Intent intent = new Intent(Otomotif.this,Tech.class);
//                        startActivity(intent);
//                    }else if (i == 2){
//                        Intent intent = new Intent(Otomotif.this,Dapur.class);
//                        startActivity(intent);
//                    }
//                }
            }
        }));

    }
}
