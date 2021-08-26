package com.example.anvinh.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.anvinh.R;
import com.example.anvinh.model.ObjMemory;

import java.util.List;

public class MemoryAdapter extends RecyclerView.Adapter<MemoryAdapter.MemoryViewHolder>{

    public List<ObjMemory> mListMemory;
    public Context context;

    public MemoryAdapter(List<ObjMemory> mListMemory, Context context) {
        this.mListMemory = mListMemory;
        this.context = context;
    }

    @NonNull
    @Override
    public MemoryAdapter.MemoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_memory_list, parent, false);
        return new MemoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MemoryViewHolder holder, int position) {
        ObjMemory objMemory = mListMemory.get(position);
        holder.date.setText(objMemory.date);
        holder.content.setText(objMemory.content);
        holder.image.setImageResource(objMemory.image);
    }

    @Override
    public int getItemCount() {
        return mListMemory.size();
    }

    public class MemoryViewHolder extends RecyclerView.ViewHolder {

        public ImageView image;
        public TextView date, content;

        public MemoryViewHolder(@NonNull View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
            date = (TextView) itemView.findViewById(R.id.date);
            content = (TextView) itemView.findViewById(R.id.content);
        }
    }
}
