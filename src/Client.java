import java.util.Objects;

public class Client implements Runnable {
    private String name;
    CallCenter callCenter = new CallCenter();

    public Client() {
    }
    public Client(String name) {
        this.name = name;
    }
    public Client(CallCenter callCenter) {
        this.callCenter = callCenter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(name, client.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "" + name;
    }

    @Override
    public void run() {
        callCenter.put();
    }

}
