package com.example.reviewandroid.Category;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.reviewandroid.R;
import com.example.reviewandroid.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class Tech extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<TechNamePic> techList;
    private TechAdapter techAdapter;
    private SearchView searchView;

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
                techAdapter.getFilter().filter(newText);
                return false;
            }
        });

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
