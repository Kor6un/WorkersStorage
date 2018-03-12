public interface WorkersStorage {
    String name = null;
    String surname = null;
    String passportNumber = null;

    void addWorker(String name, String surname, String passportNumber);
    void deleteWorker(String passportNumber);
    void changeWorker(String passportNumber);
    void findWorker(String surname);
}
