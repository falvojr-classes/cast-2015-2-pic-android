package com.example.administrador.myapplication.model.services;

import com.example.administrador.myapplication.model.entities.Address;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public final class CepService {


    private static final String URL = "http://correiosapi.apphb.com/cep/";

    private CepService() {
        super();
    }

    public static Address getAddressBy(String cep) {
        Address address = null;
        try {
            URL url = new URL(URL + cep);
            final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            int responseCode = conn.getResponseCode();

            if(responseCode != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Error code: " + responseCode);
            }

            InputStream inputStream = conn.getInputStream();

            ObjectMapper objectMapper = new ObjectMapper();
            address = objectMapper.readValue(inputStream, Address.class);

            conn.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return address;
    }

}
