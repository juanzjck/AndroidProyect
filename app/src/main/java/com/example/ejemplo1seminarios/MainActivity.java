package com.example.ejemplo1seminarios;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contactos);


    }
    public void openActivity2(){
        try {
            Intent intent = new Intent(getApplicationContext(), Pantalla.class);
            startActivity(intent);
        }catch (Error e){
            throw new Error(e);
        }
    }
}