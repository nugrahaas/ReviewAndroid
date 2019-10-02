package com.example.reviewandroid.Category;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.reviewandroid.R;
import com.example.reviewandroid.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class Dapur extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<DapurNamePic> dapurList;
    private DapurAdapter dapurAdapter;

    String[] arrayTujuan={
            "Alat Makan", "Alat Masak", "Gas", "Penyimpanan"
    };
    String[] dapur_names= {
            "Alat Makan", "Alat Masak", "Gas", "Penyimpanan"
    };
    int[] dapur_pics = {
            R.drawable.motoy,
            R.drawable.mobil,
            R.drawable.bus,
            R.drawable.truk,

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dapur);

        mRecyclerView = findViewById(R.id.recycler_view_dapur);
        if (mRecyclerView != null){
            mRecyclerView.setHasFixedSize(true);

        }

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        dapurList= new ArrayList<>();

        for (int i = 0; i < dapur_names.length; i++){
            DapurNamePic dapur = new DapurNamePic(dapur_names[i], dapur_pics[i]);
            dapurList.add(dapur);

        }

        dapurAdapter = new DapurAdapter(dapurList);

        mRecyclerView.setAdapter(dapurAdapter);
        dapurAdapter.notifyDataSetChanged();

        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText( Dapur.this , "Card at " + position + 1+ " is clicked", Toast.LENGTH_SHORT).show();
//                for (int i = 0; i<3;i++){
                    if (position == 0){
                        Intent intent = new Intent(Dapur.this, Dapur.class);
                        startActivity(intent);
                    }else if (position == 1){
                        Intent intent = new Intent(Dapur.this,Tech.class);
                        startActivity(intent);
                    }else if (position == 2){
                        Intent intent = new Intent(Dapur.this,Dapur.class);
                        startActivity(intent);
                    }
//                }
            }
        }));
    }
}
