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

public class DateFragment extends Fragment {

    public TextView ngayYeu;
    public AppCompatActivity activity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_date, container, false);
        ngayYeu = view.findViewById(R.id.ngay_dang_yeu);
        activity = (AppCompatActivity) getActivity();
        ngayYeu.setText(((MainActivity) activity).tongNgay + 1 + "");

        return view;
    }

    @Nullable
    @Override
    public View getView() {
        return super.getView();
    }
}
