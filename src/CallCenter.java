import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CallCenter {
    BlockingQueue<Client> clients = new LinkedBlockingQueue<>();

    public void started() {
        System.out.println("Call center started work");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void finished() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Call center finished work");
    }

    public void producerConsumer() {

        CallCenter callCenter = new CallCenter();

        Thread operators1 = new Thread(new Operator(callCenter));
        operators1.setName("Operator 1");
        operators1.start();
        Thread operators2 = new Thread(new Operator(callCenter));
        operators2.setName("Operator 2");
        operators2.start();
        Thread operators3 = new Thread(new Operator(callCenter));
        operators3.setName("Operator 3");
        operators3.start();

        Thread clients = new Thread(new Client(callCenter));
        clients.start();
    }

    int numberOfClients = 9;

    public void put() {
        int clientsCount = 1;
        while (numberOfClients != 0) {
            try {
                clients.put(new Client("" + clientsCount));
                clientsCount++;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            numberOfClients--;
        }
    }

    public void take() {
        System.out.println(Thread.currentThread().getName() + " started work");
        while (true) {
            if (numberOfClients == 0) {
                if (clients.isEmpty()) {
                    System.out.println(Thread.currentThread().getName() + " finished work");
                    break;
                }
            }
            try {
                Client client = clients.take();
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " took Client " + client.getName());
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " talked with Client " + client.getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
