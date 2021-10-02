import java.util.function.Consumer;

public class ProcessException implements Consumer<Exception> {
    @Override
    public void accept(Exception e) {
        System.out.println("Ошибка при выполнении запроса: " + e.getMessage());
    }
}
