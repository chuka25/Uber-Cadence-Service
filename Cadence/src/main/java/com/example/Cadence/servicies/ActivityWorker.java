package com.example.Cadence.servicies;

import com.example.Cadence.entity.CadenceEntity;
import com.example.Cadence.repository.CadenceRepo;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityWorker {

    private final CadenceRepo cadenceRepo;
    private String getWeatherInfo(String city){
        StringBuilder content = new StringBuilder();
        try{
            StringBuilder stringURL = new StringBuilder("http://api.openweathermap.org/data/2.5/weather?q=");
            stringURL.append(city);
            stringURL.append("&appid=a176488669d8a06b3bd5ee7ce8413eb1&units=metric");
            URL url = new URL(stringURL.toString());
            URLConnection urlConnection = url.openConnection();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;

            while ((line = bufferedReader.readLine()) != null ){
                content.append(line);
            }
            bufferedReader.close();
        }catch (Exception e){
            ResponseEntity.badRequest().body("There is no such city");
        }

        return content.toString();
    }

    public void saveWeatherInfo(String city){
        String content = getWeatherInfo(city);
        JSONObject obj = new JSONObject(content);
        CadenceEntity cadenceEntity = new CadenceEntity()
                .setCreatedAt(LocalDateTime.now())
                .setAirTemperature(obj.getJSONObject("main").getDouble("temp"))
                .setCity(city);
        cadenceRepo.save(cadenceEntity);
    }
}
