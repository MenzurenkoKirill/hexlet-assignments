package exercise;
import java.util.List;
import java.util.ArrayList;

// BEGIN
import exercise.connections.Connection;
import exercise.connections.Disconnected;
public class TcpConnection implements Connection {
    private String ipAddress;
    private int port;
    private Connection state;
    private List<String> buffer = new ArrayList<>();
    public TcpConnection(String ipAddress, int port) {
        this.ipAddress = ipAddress;
        this.port = port;
        this.state = new Disconnected(this);
    }
    @Override
    public String getCurrentState() {
        return this.state.getCurrentState();
    }
    @Override
    public void write(String txt) {
        this.state.write(txt);
    }
    @Override
    public void connect() {
        this.state.connect();
    }
    @Override
    public void disconnect() {
        this.state.disconnect();
    }
    public void setState(Connection tcpConnection) {
        this.state = tcpConnection;
    }
}
// END
