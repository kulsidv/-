package ru.kpfu.itis.kulsidv.service;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.kulsidv.dao.WeatherDao;

import java.net.MalformedURLException;


@Service
public class WeatherService {
    WeatherDao weatherDao = new WeatherDao();

    public String sayWeather(String city) throws MalformedURLException {
        String resposeString = weatherDao.read(city);
//        JSONObject jsonResponse = new JSONObject(resposeString);
//        double temperature = jsonResponse.getJSONObject("main").getDouble("temp");

        return String.format("Temperature in %s: %f", city, 0);
    }
}