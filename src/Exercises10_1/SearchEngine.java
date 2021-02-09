package Exercises10_1;

import com.google.gson.Gson;

import java.io.*;
import java.net.*;


public class SearchEngine {
    static private String URL = "https://ru.wikipedia.org/w/api.php";
    static private String SEARCH_PARAM = "action=query&list=search&utf8=&format=json&srsearch=";
    static private String CHARSET = "UTF-8";


    static public void search(String query) {
        try {
            String queryCode = URLEncoder.encode("\"" + query + "\"", CHARSET);
            HttpURLConnection connection = (HttpURLConnection) new URL(URL + "?" + SEARCH_PARAM + queryCode).openConnection();
            InputStream response = connection.getInputStream();

            String json = new BufferedReader(new InputStreamReader(response, CHARSET), 8).readLine();
            SearchResult data = new Gson().fromJson(json, SearchResult.class);

            System.out.println(query);
            String text;
            int count = 1;
            for(Search item : data.getQuery().getSearch()) {
                System.out.println(count++ + ". " + item.getTitle());
                text = item.getSnippet().replaceAll("<span class=\"searchmatch\">", "");
                text = text.replaceAll("</span>", "");
                System.out.println("\t" + text);
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        search("Java");
    }
}