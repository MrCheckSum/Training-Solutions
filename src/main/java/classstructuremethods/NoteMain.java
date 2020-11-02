package classstructuremethods;

public class NoteMain {
    public static void main(String[] args) {
        Note noteMainText = new Note();

        noteMainText.setName("Ian Flemming");
        noteMainText.setTopic("007");
        noteMainText.setText("Kár érte, jó ügynök volt! R.I.P Sean Connery :(");

        System.out.println(noteMainText.getName());
        System.out.println(noteMainText.getTopic());
        System.out.println(noteMainText.getText());

        System.out.println(noteMainText.getNoteText());
    }
}
