package ru.kpfu.itis.kulsidv.controller;

import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.kulsidv.service.WeatherService;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class WeatherController {
    private Map<String, String> packages = new HashMap<>();

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather")
    public String hello(@RequestParam("city") String city) throws MalformedURLException {
        return weatherService.sayWeather(city);
    }

    @PostMapping("/send_package")
    public String sendPackage(@RequestParam("name") String name, @RequestParam("message") String message) {
        if (packages.put(name, message) != null) {
            return "Посылка отправлена! Вы можете отозвать ее. Для этого перейдите по ссылке /return";
        }
        return "Можно отправлять толкьо добрые посылки. Вы уверены, что вашу посылку можно отправить?";
    }

    @DeleteMapping("/return")
    public String returnPackage(@RequestParam("name") String name) {
        return "Была отозвана посылка " + packages.remove(name);
    }

    @PutMapping("/change")
    public String changePackage(@RequestParam("name") String name, @RequestParam("message") String message) {
        if (packages.put(name, message) != null) {
            return "Надеюсь, Вы не хотите обмануть систему и остаить плохое сообщение?";
        }
        return "Это сообщение нельзя остаить!";
    }
}