package shopping;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrencyChanger {

      public String getChangeCurrency(ShopCurrency currency, ShopCurrency baseCurrency) throws IOException, InterruptedException {
          final var client = HttpClient.newHttpClient();
          final var uriBeginning = "https://api.freecurrencyapi.com/v1/latest?apikey=fca_live_D5J9SaeQ7VQEABccicKZINetmPZBOtg7jh7UpALe&currencies=";
          final var uriMiddle = "&base_currency=";
          final var uri = URI.create(uriBeginning + currency + uriMiddle + baseCurrency);
          final var request = HttpRequest
                  .newBuilder()
                  .uri(uri)
                  .GET()
                  .build();
          final var response = client.send(
                  request, HttpResponse.BodyHandlers.ofString()
          );
          return response.body();
      }
}