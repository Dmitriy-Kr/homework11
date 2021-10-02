import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class Main {
    public static String URL = "https://jsonplaceholder.typicode.com/posts";

    public static void main(String[] args) {

        MyHttpClient httpClient = new MyHttpClientImpl();
        ProcessResponse processResponse = new ProcessResponse();
        ProcessException processException = new ProcessException();

        Message postMessage = new Message();
        postMessage.setId(null);
        postMessage.setUserId(1);
        postMessage.setTitle("My post request title");
        postMessage.setBody("My post request body");

        Message putMessage = new Message();
        putMessage.setId(49);
        putMessage.setUserId(49);
        putMessage.setTitle("My put request title");
        putMessage.setBody("My put request body");

        String postData = "";
        String putData = "";

        ObjectMapper objectMapper = new ObjectMapper();

//        System.out.println("--------------------GET  START-------------------------------");
        for (int i = 50; i <= 52; i++) {
            String getUrl = URL + "/" + i;

            httpClient.getAsync(getUrl,
                    Map.of("Accept", "application/json"),
                    processResponse,
                    processException);
        }
//        System.out.println("--------------------GET  END-------------------------------" + System.lineSeparator());


//        System.out.println("--------------------POST  START-------------------------------");
        for (int i = 1; i <= 3; i++) {
            postMessage.setTitle("My POST request title " + i);
            postMessage.setBody("My POST request body " + i);

            try {
                postData = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(postMessage);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            httpClient.postAsync(URL,
                    Map.of("Accept", "application/json",
                            "Content-Type", "application/json; charset=utf-8"),
                    postData,
                    processResponse,
                    processException);
        }
//        System.out.println("--------------------POST  END-------------------------------" + System.lineSeparator());

//        System.out.println("--------------------PUT  START-------------------------------");
        for (int i = 32; i <= 34; i++) {
            putMessage.setTitle("My PUT request title " + i);
            putMessage.setBody("My PUT request body " + i);
            putMessage.setId(i);
            putMessage.setUserId(i);

            try {
                putData = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(putMessage);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            String putUrl = URL + "/" + i;

            httpClient.putAsync(putUrl,
                    Map.of("Accept", "application/json",
                            "Content-Type", "application/json; charset=utf-8"),
                    putData,
                    processResponse,
                    processException);
        }
//        System.out.println("--------------------PUT  END-------------------------------" + System.lineSeparator());

//        System.out.println("--------------------DELETE  START-------------------------------");
        for (int i = 42; i <= 44; i++) {

            String deleteUrl = URL + "/" + i;
            String deleteData = "";

            httpClient.deleteAsync(deleteUrl,
                    Map.of("Accept", "application/json",
                            "Content-Type", "application/json; charset=utf-8"),
                    deleteData,
                    processResponse,
                    processException);
        }
//        System.out.println("--------------------DELETE  END-------------------------------" + System.lineSeparator());

    }
}
