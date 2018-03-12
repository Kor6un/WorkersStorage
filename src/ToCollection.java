import java.util.HashMap;
import java.util.Map;

public class ToCollection implements WorkersStorage {
    private String name;
    private String surname;
    private String passportNumber;

    private static Map<String, Worker> workers;

    public Map<String, Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(Map<String, Worker> workers) {
        this.workers = workers;
    }

    @Override
    public void addWorker(String name, String surname, String passportNumber) {
        Worker worker = new Worker(name, surname, passportNumber);
        workers.put(passportNumber, worker);
        System.out.println("Работник успешно добавлен!");
    }

    @Override
    public void deleteWorker(String passportNumber) {

    }

    @Override
    public void changeWorker(String passportNumber) {

    }

    @Override
    public void findWorker(String surname) {

    }
}
