import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Consumer;

public class MyHttpClientImpl implements MyHttpClient {

    @Override
    public void getAsync(String url,
                         Map<String, String> headers,
                         Consumer<HttpResponse<String>> processResponse,
                         Consumer<Exception> processException) {

        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url))
                .headers(headers.entrySet().stream()
                        .map(header -> new String[]{header.getKey(), header.getValue()})
                        .flatMap(Arrays::stream)
                        .toArray(String[]::new))
                .build();

        new Thread(() -> {
            try {
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));
                processResponse.accept(response);
            } catch (Exception e) {
                processException.accept(e);
            }
        }).start();
    }

    @Override
    public void postAsync(String url,
                          Map<String, String> headers,
                          String requestBody,
                          Consumer<HttpResponse<String>> processResponse,
                          Consumer<Exception> processException) {

        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .uri(URI.create(url))
                .headers(headers.entrySet().stream()
                        .map(header -> new String[]{header.getKey(), header.getValue()})
                        .flatMap(Arrays::stream)
                        .toArray(String[]::new))
                .build();

        new Thread(() -> {
            try {
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));
                processResponse.accept(response);
            } catch (Exception e) {
                processException.accept(e);
            }
        }).start();
    }

    @Override
    public void putAsync(String url,
                         Map<String, String> headers,
                         String requestBody,
                         Consumer<HttpResponse<String>> processResponse,
                         Consumer<Exception> processException) {

        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder()
                .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
                .uri(URI.create(url))
                .headers(headers.entrySet().stream()
                        .map(header -> new String[]{header.getKey(), header.getValue()})
                        .flatMap(Arrays::stream)
                        .toArray(String[]::new))
                .build();

        new Thread(() -> {
            try {
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));
                processResponse.accept(response);
            } catch (Exception e) {
                processException.accept(e);
            }
        }).start();
    }

    @Override
    public void deleteAsync(String url,
                            Map<String, String> headers,
                            String requestBody,
                            Consumer<HttpResponse<String>> processResponse,
                            Consumer<Exception> processException) {

        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder()
                .method("DELETE", HttpRequest.BodyPublishers.ofString(requestBody))
                .uri(URI.create(url))
                .headers(headers.entrySet().stream()
                        .map(header -> new String[]{header.getKey(), header.getValue()})
                        .flatMap(Arrays::stream)
                        .toArray(String[]::new))
                .build();

        new Thread(() -> {
            try {
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));
                processResponse.accept(response);
            } catch (Exception e) {
                processException.accept(e);
            }
        }).start();

    }
}
