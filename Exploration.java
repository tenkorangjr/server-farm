/*
 * Name: Michael Tenkorang
 * Class Purpose: Working with the Queue Abstract Data Structure
 */

public class Exploration {
    public static void main(String[] args) {

        /*
         * Exploration with test files
         */
        RandomDispatcher dispatcher;
        double totalTimeInQueue = 0;
        JobReader jr = new JobReader();

        if (args.length == 0) {
            dispatcher = new RandomDispatcher(34);

        } else {
            dispatcher = new RandomDispatcher(Integer.parseInt(args[0]));
        }

        dispatcher.handleJobs(jr.readJobFile("JobSequence_3_100.txt"));

        for (Job job : dispatcher.storeJobs) {
            totalTimeInQueue += job.timeInQueue();
        }

        double average = totalTimeInQueue / dispatcher.storeJobs.size();

        System.out.println("The average wait time in the jobs queue is " + average + ".");
    }
}
