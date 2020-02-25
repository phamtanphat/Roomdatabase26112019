package com.example.roomdatabase26112019;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

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
        mainviewmodel = new ViewModelProvider(this).get(Mainviewmodel.class);
        getLifecycle().addObserver(mainviewmodel);

        obserData();
        setListener();

    }
    private void setListener() {
        mainviewmodel.getAllSinhvien(this);
        mainviewmodel.insertSinhvien(this, new Sinhvien[]{new Sinhvien("Nguyễn Văn A", 1990, "Quận 1")});
    }

    private void obserData() {
        mainviewmodel.getAllSinhvienSuccess().observe(this, new Observer<List<Sinhvien>>() {
            @Override
            public void onChanged(List<Sinhvien> sinhviens) {
                Log.d("BBB",sinhviens.toString());
            }
        });
        mainviewmodel.getIdAfterInsertSuccess().observe(this, new Observer<List<Long>>() {
            @Override
            public void onChanged(List<Long> longs) {
                Log.d("BBB",longs.toString());
            }
        });
    }
}
