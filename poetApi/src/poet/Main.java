package poet;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        final var client = HttpClient.newHttpClient();
        final var uriBeginning = "https://poetrydb.org/author";
        final var uriTitle = ",title";
        final var uriAuthor = "/Poe";
        final var uriEnd = ";Raven";

        final var builder = new StringBuilder();
        builder.append(uriBeginning).append(uriTitle).append(uriAuthor).append(uriEnd);
        final var uri = URI.create(builder.toString());
        final var request = HttpRequest
                .newBuilder()
                .uri(uri)
                .GET()
                .build();
        final var response = client.send(
                request, HttpResponse.BodyHandlers.ofString()
        );

        System.out.printf("request is %s", request);
        System.out.printf("response is %s", response.body());
    }
}
