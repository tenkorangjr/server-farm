public class LeastWorkDispatcher extends JobDispatcher {

    public LeastWorkDispatcher(int k) {
        super(k);
    }

    public Server pickServer(Job j) {
        /*
         * Return server in serverCollection with the least work/least time remaining
         */
        Server leastServer = serverCollection.get(0);

        for (Server server : serverCollection) {
            if (server.remainingWorkInQueue() < leastServer.remainingWorkInQueue()) {
                leastServer = server;
            }
        }

        return leastServer;
    }
}
