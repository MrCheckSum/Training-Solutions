package introconstructors;

public class TaskMain {

    public static void main(String[] args) {
        Task task = new Task("Futás", "Marathon");

        System.out.println("Title: " + task.getTitle());
        System.out.println("Description: " + task.getDescription());

        task.startAt();
        task.setDuration(134);

        System.out.println("Indult " + task.getStartDateTime() + " és " + task.getDuration() + " percig tartot");
    }
}
