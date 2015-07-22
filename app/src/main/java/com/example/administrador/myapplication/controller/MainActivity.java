package com.example.administrador.myapplication.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrador.myapplication.model.entities.Client;
import com.example.administrador.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Client> clients = Client.getAll();

        ListView listViewClients = (ListView) findViewById(R.id.listViewClients);

        ClientListAdapter clientAdapter = new ClientListAdapter(MainActivity.this, clients);

        listViewClients.setAdapter(clientAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menuAdd) {
            Intent goToMainActivity = new Intent(MainActivity.this, ClientPersistActivity.class);
            startActivity(goToMainActivity);
        }

        return super.onOptionsItemSelected(item);
    }

}
