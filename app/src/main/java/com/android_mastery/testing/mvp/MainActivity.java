/*
 * Copyright (c) 2018.
 * Gilang Ramadhan (gilang@imastudio.co.id)
 */

package com.android_mastery.testing.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android_mastery.testing.R;

public class MainActivity extends AppCompatActivity implements MainView{

    EditText editText;
    Button button;
    TextView textView;

    MainPresenter mainPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.edtInput);
        button = findViewById(R.id.btnSubmit);
        textView = findViewById(R.id.result);

        mainPresenter = new MainPresenter(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainPresenter.inputPersegi(editText.getText().toString());
            }
        });
    }

    @Override
    public void inputKosong(String message) {
        editText.setError(message);
    }

    @Override
    public void inputSukses(Double sisi) {
        mainPresenter.hitungPersegi(sisi);
    }

    @Override
    public void hitungSukses(Double luas) {
        Toast.makeText(this, String.valueOf(luas), Toast.LENGTH_LONG).show();
        textView.setText(String.valueOf(luas));
    }
}
