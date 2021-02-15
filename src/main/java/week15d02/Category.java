package week15d02;

public class Category {

    private String question;

    private int answer;

    private int points;

    private String topic;

    public Category(String question, int answer, int points, String topic) {
        this.question = question;
        this.answer = answer;
        this.points = points;
        this.topic = topic;
    }

    public String getQuestion() {
        return question;
    }

    public int getAnswer() {
        return answer;
    }

    public int getPoints() {
        return points;
    }

    public String getTopic() {
        return topic;
    }

    @Override
    public String toString() {
        return "Category{" +
                "question='" + question + '\'' +
                ", answer=" + answer +
                ", points=" + points +
                ", topic='" + topic + '\'' +
                '}';
    }
}
