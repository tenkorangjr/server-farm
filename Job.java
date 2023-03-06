/*
 * Name: Michael Tenkorang
 * Class Purpose: Working with the Queue Abstract Data Structure
 */

public class Job {
    double arrivalTime;
    double processingTime;
    double currProcessedTime;
    double finishedTime;

    public Job(double arrivalTime, double processingTime) {
        this.arrivalTime = arrivalTime;
        this.processingTime = processingTime;
        this.currProcessedTime = 0;
        this.finishedTime = 0;
    }

    public double getArrivalTime() {
        /*
         * Return the arrival time of job
         */
        return arrivalTime;
    }

    public double getTotalProcessingTime() {
        /*
         * Return the total processing time of job
         */
        return processingTime;
    }

    public boolean isFinished() {
        /*
         * Check whether the job has finished procession
         */
        return currProcessedTime == processingTime;
    }

    public double timeInQueue() {
        /*
         * get time spent in queue
         */
        return finishedTime - arrivalTime;
    }

    public double getFinishTime() {
        /*
         * Get the finished time
         */
        return finishedTime;
    }

    public void setFinishTime(double time) {
        /*
         * Set the finished time of job
         */
        finishedTime = time;
    }

    public double getTimeProcessed() {
        return currProcessedTime;
    }

    public double getTimeRemaining() {
        /*
         * Get the timeRemaining
         */
        return processingTime - currProcessedTime;
    }

    public void process(double time) {
        /*
         * Process job for "time" amount of time
         */
        currProcessedTime += time;
    }

}
