import java.util.Random;

public class RandomDispatcher extends JobDispatcher {
    Random randomPicker;

    public RandomDispatcher(int k) {
        super(k);
        randomPicker = new Random();
    }

    public Server pickServer(Job j) {
        int randPick = randomPicker.nextInt(0, serverCollection.size());

        return serverCollection.get(randPick);
    }

    public static void main(String[] args) {
        RandomDispatcher dispatcher = new RandomDispatcher(1);

        Job job = new Job(0, 20);
        Job job2 = new Job(20, 30);

        Queue<Job> queueOfJobs = new LinkedList<>();
        queueOfJobs.offer(job);
        queueOfJobs.offer(job2);

        dispatcher.handleJobs(queueOfJobs);
    }
}
