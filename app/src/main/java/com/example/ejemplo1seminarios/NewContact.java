package com.example.ejemplo1seminarios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.content.Intent;
public class NewContact extends AppCompatActivity {

    ImageView imageViewNCImage;
    int image = R.drawable.usuario1;
    EditText textName,textPhone,textAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);
        imageViewNCImage = findViewById(R.id.imageveNCImage);
        textName = findViewById(R.id.EditTextNCName);
        textPhone = findViewById(R.id.EditTextNCPhone);
        textAddress = findViewById(R.id.EditTextNCAddress);
    }

    public void SaveNewContact(View v){
        String name=textName.getText().toString();
        String phone=textPhone.getText().toString();
        String address=textAddress.getText().toString();

        Contact newContact= new Contact(image,name,phone,address);
        newContact.save();

        Intent intent= new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
        finish();
    }
    public void cancel(View v){
        Intent intent= new Intent(getApplicationContext(),MainActivity.class);
        try {

            startActivity(intent);
        }catch (Error e){
            throw new Error(e);
        }
    }
    public void onClickSelectImage(View v){
        switch (v.getId()){
            case R.id.imagrViewNC1:
                image=R.drawable.usuario5;
            break;
            case R.id.imagrViewNC2:
                image=R.drawable.usuario2;
            break;
            case R.id.imagrViewNC3:
                image=R.drawable.usuario1;
            break;
        }
        imageViewNCImage.setImageResource(image);
    }


}