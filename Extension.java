/*
 * Name: Michael Tenkorang
 * Class Purpose: Working with the Queue Abstract Data Structure
 */

public class Extension extends RandomDispatcher {

    public Extension(int k) {
        super(k);
    }

    public Server pickServer(Job j) {
        /*
         * Pick appropriate server for dispatcher depending on dispatcher properties
         */
        int randPick1 = randomPicker.nextInt(0, serverCollection.size());
        int randPick2 = randomPicker.nextInt(0, serverCollection.size());

        Server server1 = serverCollection.get(randPick1);
        Server server2 = serverCollection.get(randPick2);

        if (server1.remainingWorkInQueue() > server2.remainingWorkInQueue()) {
            return server2;
        } else {
            return server1;
        }
    }

    public static void main(String[] args) {
        /*
         * Creating two random dispatchers, getting the leastwork of those two
         * dispatchers and having it run.
         */

        double totalTimeInQueue = 0;

        JobReader jr = new JobReader();
        RandomDispatcher dispatcher = new RandomDispatcher(34);

        dispatcher.handleJobs(jr.readJobFile("JobSequence_3_100.txt"));

        for (Job job : dispatcher.storeJobs) {
            totalTimeInQueue += job.timeInQueue();
        }

        double average = totalTimeInQueue / dispatcher.storeJobs.size();

        System.out.println("The average wait time in the jobs queue is " + average + ".");

    }
}
