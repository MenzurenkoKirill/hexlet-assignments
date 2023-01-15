package exercise.connections;

public interface Connection {
    // BEGIN
    String getCurrentState();
    void write(String txt);
    void connect();
    void disconnect();
    // END
}
