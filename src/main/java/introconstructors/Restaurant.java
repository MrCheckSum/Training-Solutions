package introconstructors;

import java.util.Arrays;
import java.util.List;

public class Restaurant {

    private List<String> menu;
    private String name;
    private int capacity;

    public Restaurant(String name, int capacity) {
        this.name = name;
        this.capacity = capacity * 4;
        this.menu = carte();

    }

    private List<String> carte() {
        return Arrays.asList("bécsi szelet", "sült oldalas");
    }

    public List<String> getMenu() {
        return menu;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }
}
