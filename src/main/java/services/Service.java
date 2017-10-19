package main.java.services;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by Romain on 19/10/2017.
 */
public abstract class Service {
    public static final String BASE_URL = "http://148.100.4.133:3000/api/";

    public URL getUrl(String urlString) {
        URL url = null;
        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return url;
    }

    public Object parseJsonToBean(URL url, Class clas) {
        ObjectMapper objectMapper = new ObjectMapper();
        Object o = null;

        try {
            o = objectMapper.readValue(url, clas);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return o;
        }
    }

    public List<Object> parseJsonToBeanList(URL url, Class clas) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Object> o = null;

        try {
            o = objectMapper.readValue(url, objectMapper.getTypeFactory().constructCollectionType(List.class, clas));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return o;
        }
    }
}
