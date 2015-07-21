package com.example.administrador.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Client> clients = getClients();

        ListView listViewClients = (ListView) findViewById(R.id.listViewClients);

        ClientListAdapter clientAdapter = new ClientListAdapter(MainActivity.this, clients);

        listViewClients.setAdapter(clientAdapter);
    }

    private List<Client> getClients() {
        List<Client> clients = new ArrayList<>();

        Client renan = new Client();
        renan.setName("Renan");
        renan.setAge(23);
        clients.add(renan);

        Client valdeco = new Client();
        valdeco.setName("Luiz");
        valdeco.setAge(26);
        clients.add(valdeco);

        return clients;
    }

}
