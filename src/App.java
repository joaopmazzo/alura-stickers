import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class App {

    public static void main(String[] args) throws IOException, InterruptedException {

        String url = "https://alura-filmes.herokuapp.com/conteudos";
        URI address = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(address).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String body = response.body();

        JsonParser jsonParser = new JsonParser();
        List<Map<String, String>> filmsList = jsonParser.parse(body);

        filmsList.stream().forEach(film -> System.out.println("------------------------\n" +
                film.get("title") + "\n" +
                film.get("image") + "\n" +
                film.get("imDbRating") + "\n" +
                "------------------------\n"));
    }
}
