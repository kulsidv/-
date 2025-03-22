package ru.kpfu.itis.kulsidv.dao;

import java.net.MalformedURLException;

public interface Dao {
    void create();
    String read(String city) throws MalformedURLException;
    void update();
    void delete();
}
