import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws IOException {
        String sehir = "Ankara"; // Hava durumu bilgileri alınacak şehir

        // wttr.in servisine istek göndermek için kullanılacak URL
        String url = "https://wttr.in/" + sehir + "?format=%C%t%H";

        // HTTP bağlantısı oluşturma
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("GET");

        // Sunucudan gelen yanıtı okuma
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
            response.append("\n");
        }
        in.close();

        // Hava durumu bilgilerini yazdırma
        System.out.println("Hava durumu bilgileri (" + sehir + "):\n" + response.toString());
    }
}
