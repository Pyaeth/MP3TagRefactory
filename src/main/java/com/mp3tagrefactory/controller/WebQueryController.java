package com.mp3tagrefactory.controller;

//import javax.json.JsonObject;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 *
 * @author amicu
 */
public class WebQueryController {

    public WebQueryController() {
        String google = "https://www.googleapis.com/customsearch/v1?key=AIzaSyCpNuxF4cpX_9QKs8ilPURTeLeHWwMI178&cx=007914092360642073305:kqccsvwusfd&q=";
        String search = "Wham - Last Christmas";
        String charset = "UTF-8";
        System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");

        try {
            URL url = new URL(google + URLEncoder.encode(search, charset));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
            connection.connect();
            BufferedReader bReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputline, resultString = "";
            while ((inputline = bReader.readLine()) != null) {
                resultString += inputline;
            }
            connection.disconnect();
            Gson gson = new Gson();
            JsonObject json = gson.fromJson(resultString, JsonObject.class);
            //JsonObject json = gson.fromJson(resultString, JsonObject.class);
            String album, genre;
            int year, trackno;

            album = json.get("items").getAsJsonArray().get(0).getAsJsonObject().get("htmlSnippet").getAsString();

            System.out.println(album);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
