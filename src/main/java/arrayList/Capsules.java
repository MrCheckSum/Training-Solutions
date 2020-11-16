package arrayList;

import java.util.ArrayList;
import java.util.List;

public class Capsules {

    List<String> capsuleColours = new ArrayList<>();

    public void addLast(String colour) {
        capsuleColours.add(colour);
    }

    public void addFirst(String colour) {
        capsuleColours.add(0, colour);
    }

    public void removeFirst() {
        capsuleColours.remove(0);
    }

    public void removeLast() {
        capsuleColours.remove(capsuleColours.size() - 1);
    }

    public List<String> getCapsuleColours() {
        return capsuleColours;
    }

    public static void main(String[] args) {
        Capsules capsules = new Capsules();
        capsules.addFirst("Blue");
        capsules.addFirst("Red");
        capsules.addLast("Green");
        capsules.addLast("Violet");
        capsules.removeFirst();
        capsules.removeLast();
        System.out.println(capsules.getCapsuleColours());
    }

}
