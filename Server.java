public class Server {
    double sysTime;
    Queue<Job> sysQueue;
    double totalWork;

    public Server() {
        sysTime = 0;
        sysQueue = new LinkedList<>();
        totalWork = 0;
    }

    public void addJob(Job job) {
        sysQueue.offer(job);
        totalWork += job.getTotalProcessingTime();
    }

    public void processTo(double time) {
        double myTimeRemaining = time - sysTime;

        while ((sysQueue.size() > 0) && (myTimeRemaining > 0)) {
            Job currentJob = sysQueue.peek();
            double timeToProcess = currentJob.getTimeRemaining();

            if (timeToProcess >= myTimeRemaining) {
                currentJob.process(myTimeRemaining);
                totalWork -= myTimeRemaining;
                sysTime += myTimeRemaining;
                currentJob.setFinishTime(sysTime);
                myTimeRemaining = 0;
            } else {
                currentJob.process(timeToProcess);
                totalWork -= timeToProcess;
                myTimeRemaining -= timeToProcess;
                sysTime += timeToProcess;
                currentJob.setFinishTime(sysTime);
                sysQueue.poll();
            }
        }

        sysTime = time;
    }

    public double remainingWorkInQueue() {
        return totalWork;
    }

    public int size() {
        return sysQueue.size();
    }

    public static void main(String[] args) {
        // Setup
        Job job = new Job(0, 20);
        Job job2 = new Job(10, 30);
        Job job3 = new Job(20, 10);
        Job job4 = new Job(25, 30);

        Server server = new Server();
        server.addJob(job);
        server.addJob(job2);
        server.addJob(job3);
        server.addJob(job4);

        System.out.println(server.remainingWorkInQueue() + " == 90.0");

        server.processTo(55);
        System.out.println(server.sysTime + " == 50.0");
        System.out.println(server.sysQueue.peek().getTimeProcessed() + " == 10.0");
        System.out.println(server.sysQueue.peek().getTimeRemaining() + " == 10.0");
        System.out.println(server.remainingWorkInQueue() + " == 80.0\n");

    }
}
