import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class eroity {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.motsqui.com/mots-aleatoires.php");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
            BufferedReader responceRequest = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String responceLine;
            String content = "";
            while ((responceLine = responceRequest.readLine()) != null) {
                content += responceLine;
            }
            responceRequest.close();
            System.out.println(content.substring(content.indexOf("><b>") + 4, content.indexOf("><b>") + 4 + content.substring(content.indexOf("><b>") + 4).indexOf(">") - 3));
        }
        catch (IOException e) {

        }
    }
}
