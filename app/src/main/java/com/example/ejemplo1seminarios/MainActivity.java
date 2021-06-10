package com.example.ejemplo1seminarios;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import android.view.View;
import android.content.Intent;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.List;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    public RecyclerView recyclerViewContacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contactos);
        // mock contacts
       recyclerViewContacts = findViewById(R.id.ReyclerContacts);
       /*
       Contact yo = new Contact(R.drawable.perfil,"Juan Pablo","097888475","Algun lugar");
        Contact contacto1 = new Contact(R.drawable.usuario1,"Diego","097888475","Algun lugar");
        Contact contacto2 = new Contact(R.drawable.usuario2,"Diego","097888475","Algun lugar");
        Contact contacto3 = new Contact(R.drawable.usuario3,"Diego","097888475","Algun lugar");
        List<Contact> contactos= new ArrayList<Contact>();

        contactos.add(contacto1);
        contactos.add(contacto2);
        contactos.add(contacto3);
        contactos.add(yo);
        */
        List<Contact> contactos= Contact.listAll(Contact.class);
        recyclerViewContacts.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewContacts.setLayoutManager(layoutManager);

        ContactosAdapter adapter = new ContactosAdapter(contactos);


        adapter.setOnItemClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int image =(int)((ImageView)view.findViewById(R.id.imagenViewRC)).getTag();
                String name =  ((TextView)view.findViewById(R.id.textViewRCName)).getText().toString();
                String phone= ((TextView)view.findViewById(R.id.textViewRCPhone)).getText().toString();
                String address= ((TextView)view.findViewById(R.id.textViewRCAddress)).getText().toString();

                Intent intent = new Intent(getApplicationContext(),ContactnfoActivity.class);
                intent.putExtra("EXTRA_IMG",image);
                intent.putExtra("EXTRA_NAME",name);
                intent.putExtra("EXTRA_PHONE",phone);
                intent.putExtra("EXTRA_ADDRESS",address);
                ChangeActiviy(intent);
            }
        });
        recyclerViewContacts.setAdapter(adapter);


        //add new contact button
        Button newContactButton = findViewById(R.id.ButtonNewContact);
        newContactButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),NewContact.class);
                ChangeActiviy(intent);
            }
        });

    }
    public void ChangeActiviy(Intent intent){
        try {

            startActivity(intent);
        }catch (Error e){
            throw new Error(e);
        }
    }

}