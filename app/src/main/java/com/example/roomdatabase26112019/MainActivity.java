package com.example.roomdatabase26112019;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.util.Log;

import com.example.roomdatabase26112019.model.database.Sinhvien;
import com.example.roomdatabase26112019.viewmodel.Mainviewmodel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Mainviewmodel mainviewmodel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainviewmodel = new Mainviewmodel();
        obserData();
        setListener();

    }

    private void setListener() {
        mainviewmodel.getAllSinhvien(this);
    }

    private void obserData() {
        mainviewmodel.getAllSinhvienSuccess().observe(this, new Observer<List<Sinhvien>>() {
            @Override
            public void onChanged(List<Sinhvien> sinhviens) {
                Log.d("BBB",sinhviens.size() + "");
            }
        });
    }
}
