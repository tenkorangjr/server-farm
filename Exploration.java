public class Exploration {
    public static void main(String[] args) {

        double totalTimeInQueue = 0;
        JobReader jr = new JobReader();
        RandomDispatcher dispatcher = new RandomDispatcher(10);

        dispatcher.handleJobs(jr.readJobFile("JobSequence_3_100.txt"));

        for (Job job : dispatcher.storeJobs) {
            totalTimeInQueue += job.timeInQueue();
        }

        System.out.println(totalTimeInQueue);

        double average = totalTimeInQueue / dispatcher.storeJobs.size();

        System.out.println("The average wait time in the jobs queue is " + average + ".");
    }
}
