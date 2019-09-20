package com.example.reviewandroid;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Tech extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<TechNamePic> techList;
    private TechAdapter techAdapter;

    String[] arrayTujuan={
            "Smartphone", "Laptop", "Kamera", "Aksesoris"
    };
    String[] tech_names= {
            "Smartphone", "Laptop", "Kamera", "Aksesoris"
    };
    int[] tech_pics = {
            R.drawable.motoy,
            R.drawable.mobil,
            R.drawable.bus,
            R.drawable.truk,

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tech);

        mRecyclerView = findViewById(R.id.recycler_view_tech);
        if (mRecyclerView != null){
            mRecyclerView.setHasFixedSize(true);

        }

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        techList= new ArrayList<>();

        for (int i = 0; i < tech_names.length; i++){
            TechNamePic tech = new TechNamePic(tech_names[i], tech_pics[i]);
            techList.add(tech);

        }

        techAdapter = new TechAdapter(techList);

        mRecyclerView.setAdapter(techAdapter);
        techAdapter.notifyDataSetChanged();

        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText( Tech.this , "Card at " + position + 1+ " is clicked", Toast.LENGTH_SHORT).show();
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
