package exercise.connections;

// BEGIN
import exercise.TcpConnection;
public class Connected implements Connection {
    private TcpConnection tcpConnect;
    private final String STATE_NAME = "connected";
    Connected(TcpConnection tcpConnect) {
        this.tcpConnect = tcpConnect;
    }
    @Override
    public void connect() {
        System.out.println("Error! Connection already connected");
    }
    @Override
    public void disconnect() {
        tcpConnect.setState(new Disconnected(tcpConnect));
    }
    @Override
    public void write(String txt) {
        System.out.println(txt);
    }
    @Override
    public String getCurrentState() {
        return this.STATE_NAME;
    }
}
// END
