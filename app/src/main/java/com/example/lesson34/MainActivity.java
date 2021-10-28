package com.example.lesson34;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;

import adapter.PlayListAdapter;
import fragments.FirstFragment;
import fragments.SecondFragment;
import models.PlayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<PlayList> playLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().add(R.id.container, new FirstFragment()).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.container_2, new SecondFragment()).commit();

    }

    public void startActivity(){
        Intent intent = new Intent(this,SecondActivity.class);
        startActivity(intent);
    }
}