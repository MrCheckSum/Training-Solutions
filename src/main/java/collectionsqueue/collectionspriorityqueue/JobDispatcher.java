package collectionsqueue.collectionspriorityqueue;

import collectionsqueue.job.Job;
import collectionsqueue.job.NoJobException;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class JobDispatcher {

    public Queue<Job> addJob(Job... jobs) {
        PriorityQueue<Job> jobPriorityQueue = new PriorityQueue<>();
        for (Job job : jobs) {
            jobPriorityQueue.add(job);
        }
        return jobPriorityQueue;

    }

    public Job dispatchNextJob(Queue<Job> jobs) throws NoJobException {

        if (jobs.isEmpty()) {
            throw new NoJobException("No job available, get a rest!");
        }
        return jobs.poll();
    }

    public static void main(String[] args) {
        JobDispatcher jd = new JobDispatcher();

        Queue<Job> j = jd.addJob(new Job(1, "mentőorvos"), new Job(6, "mentősegéd"));
        System.out.println(j);

    }
}
