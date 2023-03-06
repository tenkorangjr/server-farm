/*
 * Name: Michael Tenkorang
 * Class Purpose: Working with the Queue Abstract Data Structure
 */

public class RoundRobinDispatcher extends JobDispatcher {
    int index;

    public RoundRobinDispatcher(int k) {
        super(k);
        index = 0;
    }

    public Server pickServer(Job j) {
        /*
         * Pick appropriate server for dispatcher depending on dispatcher properties
         */

        if (index == serverCollection.size()) {
            index = 0;
        }
        return serverCollection.get(index++);
    }
}
