import java.net.http.HttpResponse;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ProcessResponse implements Consumer<HttpResponse<String>> {
    @Override
    public void accept(HttpResponse<String> response) {
        System.out.println("----------------------------------------------------------------------------"
                + System.lineSeparator()
                + "Request type: " + response.request().method()
                + System.lineSeparator()
                + "RESPONSE"
                + System.lineSeparator()
                + "Status code: " + response.statusCode()
                + System.lineSeparator()
                + response.headers().map().entrySet()
                .stream()
                .filter(header -> "content-type".equals(header.getKey().toLowerCase(Locale.ROOT)) ||
                        "content-length".equals(header.getKey().toLowerCase(Locale.ROOT)))
                .map(header -> new String(header.getKey()
                        + ": "
                        + String.join(", ", header.getValue())))
                .collect(Collectors.joining(System.lineSeparator()))
                + System.lineSeparator()
                + response.body()
                + System.lineSeparator()
                + "----------------------------------------------------------------------------");
    }
}
