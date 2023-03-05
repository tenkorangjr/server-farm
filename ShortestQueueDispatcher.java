public class ShortestQueueDispatcher extends JobDispatcher {

    Server shortestServer;

    public ShortestQueueDispatcher(int k) {
        super(k);
        shortestServer = null;
    }

    public Server pickServer(Job j) {
        /*
         * Return the server with the least number of jobs in queue
         */
        if (serverCollection.size() > 0) {
            shortestServer = serverCollection.get(0);
        } else {
            return null;
        }

        for (Server server : serverCollection) {
            if (server.size() < shortestServer.size()) {
                shortestServer = server;
            }
        }

        return shortestServer;
    }
}
