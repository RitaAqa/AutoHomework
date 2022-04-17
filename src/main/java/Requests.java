import java.io.IOException;
public class Requests {

    public static final String link = "https://bit.ly/3k2uiT8";

    public static void main(String args[]) throws IOException {
        GetRequest getRequest = new GetRequest();
        getRequest.sendGetRequest(link);
    }
}
