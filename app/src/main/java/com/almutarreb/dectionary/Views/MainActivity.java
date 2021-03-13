package com.almutarreb.dectionary.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.almutarreb.dectionary.Adapters.RecyclerViewAdaper;
import com.almutarreb.dectionary.Entities.Words;
import com.almutarreb.dectionary.R;
import com.almutarreb.dectionary.ViewModel.AddNewWordModel;
import com.almutarreb.dectionary.ViewModel.WordsViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerViewAdaper adapter;
    private RecyclerView recyclerView;
    private FloatingActionButton btn_add;
WordsViewModel mWordsViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        adapter= new RecyclerViewAdaper(this);
        recyclerView.setAdapter(adapter);
        mWordsViewModel= ViewModelProviders.of(this).get(WordsViewModel.class);
        mWordsViewModel.getdata().observe(this, new Observer<List<Words>>() {
            @Override
            public void onChanged(List<Words> words) {
                //refresh ui
                //refresh recycler view

               adapter.setWordsList(words);
            }
        });
        btn_add=findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,AddWord_Activity.class);
                startActivityForResult(intent,1);
            }
        });
    }
}