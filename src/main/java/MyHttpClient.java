import java.net.http.HttpResponse;
import java.util.Map;
import java.util.function.Consumer;

public interface MyHttpClient {

    void getAsync(String url,
                  Map<String,String> headers,
                  Consumer<HttpResponse<String>> processResponse,
                  Consumer<Exception> processException);

    void postAsync(String url,
                   Map<String,String> headers,
                   String requestBody,
                   Consumer<HttpResponse<String>> processResponse,
                   Consumer<Exception> processException);

    void putAsync(String url,
                  Map<String,String> headers,
                  String requestBody,
                  Consumer<HttpResponse<String>> processResponse,
                  Consumer<Exception> processException);

    void deleteAsync(String url,
                     Map<String,String> headers,
                     String requestBody,
                     Consumer<HttpResponse<String>> processResponse,
                     Consumer<Exception> processException);
}
