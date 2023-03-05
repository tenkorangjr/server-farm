public class RoundRobinDispatcher extends JobDispatcher {
    int index;

    public RoundRobinDispatcher(int k) {
        super(k);
        index = 0;
    }

    public Server pickServer(Job j) {
        if (index == serverCollection.size()) {
            index = 0;
        }
        return serverCollection.get(index++);
    }
}
