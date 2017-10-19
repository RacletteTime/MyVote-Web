package main.java.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import main.java.actions.Action;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
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

    public String postBean(URL url, Object o) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String params = objectMapper.writeValueAsString(o);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);

            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(params);
            wr.flush();
            wr.close();

            if (con.getResponseCode() == 200) {
                return Action.SUCCESS;
            }
            else {
                return Action.FAILURE;
            }
        } catch (Exception e) {
            return Action.FAILURE;
        }
    }
}
