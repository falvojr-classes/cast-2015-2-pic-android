package com.example.administrador.myapplication.model.persistence;


import com.example.administrador.myapplication.model.entities.Client;

import java.util.List;

public interface ClientRepository {

    public abstract void save(Client client);
    public abstract List<Client> getAll();
    public abstract void delete(Client client);

}
