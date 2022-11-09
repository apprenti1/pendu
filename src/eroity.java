import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class eroity {
    public static void main(String[] args) {
        try {
            URL myLink = new URL("https://www.motsqui.com/mots-aleatoires.php");
            HttpsURLConnection connect = (HttpsURLConnection) myLink.openConnection();
            connect.setRequestMethod("GET");
            connect.connect();
            System.out.println(connect.getResponseCode());
            Scanner scanner = new Scanner(myLink.openStream());
            StringBuilder informationString = new StringBuilder();
            while (scanner.hasNext()) {
                informationString.append(scanner.nextLine());
            }
            //Close the scanner
            scanner.close();

            System.out.println(informationString);
        } catch (Exception e) {
            System.out.println("ggggggg");
        }

    }
}
