package com.example.anvinh.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.anvinh.R;
import com.example.anvinh.adapter.MemoryAdapter;
import com.example.anvinh.model.ObjMemory;

import java.util.ArrayList;

public class MemoryActivity extends AppCompatActivity {

    private RecyclerView listMemory;
    private ArrayList<ObjMemory> mArrayDiscover = new ArrayList<>();
    private MemoryAdapter mAdapterMemory;
    public ImageView icBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);
        listMemory = (RecyclerView) findViewById(R.id.list_memory);
        icBack = (ImageView) findViewById(R.id.back);
        mArrayDiscover.add(new ObjMemory("14/02/2020", "Valentine", R.drawable.anzinh));
        mArrayDiscover.add(new ObjMemory("14/02/2020", "ValentineValentineValentineValentineValentineValentineValentineValentineValentine", R.drawable.anzinh));
        mArrayDiscover.add(new ObjMemory("14/02/2020", "Valentine", R.drawable.anzinh));
        mArrayDiscover.add(new ObjMemory("14/02/2020", "Valentine", R.drawable.anzinh));

        mAdapterMemory = new MemoryAdapter(mArrayDiscover, MemoryActivity.this);
        listMemory.setAdapter(mAdapterMemory);
        listMemory.setLayoutManager(new LinearLayoutManager(MemoryActivity.this));
        icBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
