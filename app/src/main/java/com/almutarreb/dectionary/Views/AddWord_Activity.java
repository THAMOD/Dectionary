package com.almutarreb.dectionary.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.almutarreb.dectionary.Entities.Words;
import com.almutarreb.dectionary.R;
import com.almutarreb.dectionary.ViewModel.AddNewWordModel;

public class AddWord_Activity extends AppCompatActivity {
private TextView txt_word_name ,txt_word_meaning,txt_word_type;
private Button btn_add;
private AddNewWordModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel= ViewModelProviders.of(this).get(AddNewWordModel.class);
        setContentView(R.layout.activity_add_word_);
        txt_word_name=findViewById(R.id.add_txt_word_name);
        txt_word_meaning=findViewById(R.id.add_txt_meaning);
        txt_word_type=findViewById(R.id.add_txt_word_type);
        btn_add=findViewById(R.id.btn_add_word);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
mViewModel.insert(new Words(txt_word_name.getText().toString().trim(),
        txt_word_meaning.getText().toString().trim(),txt_word_type.getText().toString().trim()));
finish();
            }
        });
    }
}