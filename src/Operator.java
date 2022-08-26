public class Operator implements Runnable {
    private String name;
    CallCenter callCenter = new CallCenter();

    public Operator() {
    }

    public Operator(CallCenter callCenter) {
        this.callCenter = callCenter;
    }

    public Operator(String name) {
        this.name = name;
    }

    public Operator(String name, CallCenter callCenter) {
        this.name = name;
        this.callCenter = callCenter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CallCenter getCallCenter() {
        return callCenter;
    }

    public void setCallCenter(CallCenter callCenter) {
        this.callCenter = callCenter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Operator operator = (Operator) o;

        if (name != null ? !name.equals(operator.name) : operator.name != null) return false;
        return callCenter != null ? callCenter.equals(operator.callCenter) : operator.callCenter == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (callCenter != null ? callCenter.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Operator{" +
                "name='" + name + '\'' +
                ", callCenter=" + callCenter +
                '}';
    }

    @Override
    public void run() {
        callCenter.take();
    }
}
