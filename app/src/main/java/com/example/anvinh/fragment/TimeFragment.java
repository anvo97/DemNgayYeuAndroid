package com.example.anvinh.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.anvinh.R;
import com.example.anvinh.activity.MainActivity;

public class TimeFragment extends Fragment {

    public TextView nam, thang, tuan, ngay;
    public AppCompatActivity activity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_time, container, false);
        nam = (TextView) view.findViewById(R.id.nam);
        thang = (TextView) view.findViewById(R.id.thang);
        tuan = (TextView) view.findViewById(R.id.tuan);
        ngay = (TextView) view.findViewById(R.id.ngay);
        activity = (AppCompatActivity) getActivity();
        nam.setText(((MainActivity) activity).nam + "");
        thang.setText(((MainActivity) activity).thang + "");
        tuan.setText(((MainActivity) activity).tuan + "");
        ngay.setText(((MainActivity) activity).ngayShow + "");

        return view;
    }

    @Nullable
    @Override
    public View getView() {
        return super.getView();
    }
}
