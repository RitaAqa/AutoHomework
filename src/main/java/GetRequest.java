import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class GetRequest{
    private HttpURLConnection con ;

    public void sendGetRequest (String link)  {

        try {
            URL url = new URL(link);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setInstanceFollowRedirects(false);
        }
        catch (IOException e) {
            System.out.println("Error on opening connection");
            e.printStackTrace();
        }

        //get all headers => log
        /* Map <String, List<String>> map = con.getHeaderFields();
         for (Map.Entry entry : map.entrySet()) {
            System.out.println("Key : " + entry.getKey() +
                    " ,Value : " + entry.getValue());
        }*/

        // get response code
        int getResponseCode = 0;
        try {
            getResponseCode = con.getResponseCode();
        }
        catch (IOException e) {
            System.out.println("Error on getting response code");
            e.printStackTrace();
        }
        System.out.println("Response code: " + getResponseCode);

        // if redirect = > run getRequest
        if (getResponseCode == 301) {

            //get header by 'key'
            String urlForRedirect = con.getHeaderField("Location");
            System.out.println("Redirect to: " + urlForRedirect);
            sendGetRequest(urlForRedirect);
        }

        // else print response
        else {
            try{
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println(inputLine);
                }
                in.close();
            }
            catch (IOException e) {
                System.out.println("Error on reading input stream");
                e.printStackTrace();
            }
        }
    }
}
