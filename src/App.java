import java.util.List;

public class App {

    private static List<Worker> workers = WorkersTable.workers;

    public static void main(String[] args) {
        new MainFrame(workers);
    }
}
