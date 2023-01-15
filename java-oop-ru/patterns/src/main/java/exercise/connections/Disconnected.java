package exercise.connections;

// BEGIN
import exercise.TcpConnection;
public class Disconnected implements Connection {
    private TcpConnection tcpConnect;
    private final String STATE_NAME = "disconnect";
    Disconnected (TcpConnection tcpConnect) {
        this.tcpConnect = tcpConnect;
    }
    @Override
    public String getCurrentState() {
        return this.STATE_NAME;
    }
    @Override
    public void write(String txt) {
        System.out.println(Error! + txt);
    }
    @Override
    public void connect() {
        tcpConnect.setState(new Connected(tcpConnect));
    }
    @Override
    public void disconnect() {
        System.out.println(Error! Connection already broken);
    }
}
// END
