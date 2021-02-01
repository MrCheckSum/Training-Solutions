package week12d03;

import xtest.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Készítsd el a week12d03.NumberStat osztályt melyben legyen egy metódus, ami paraméterül vár egy egész számokból álló listát.
Add vissza azt a számot amelyik pontosan egyszer szerepel a listában. Ha több ilyen szám van akkor a kisebbet!
Ellenőrizd, hogy olyan listát fogadunk el, ami legalább 1 elemű, ha a lista nem ilyen, dobj kivételt!
pl: {1,1,5,3,4,5,6,5,6,4,1,6,5,4} A megoldás: 3
Bónusz: Módosítsd az osztályt. Legyen egy egész számokból álló lista attribútuma.
A fent megírt metódus ezen a listán dolgozzon. A lista elemeit fájlból töltsük fel.
A file úgy néz ki, hogy egy sorban három szám van vesszővel elválasztva. Tehát:
1,1,4
2,3,5
2,2,5 (edited)
 */
public class NumberStat {

    private List<Integer> numbers = new ArrayList<>();

    public int findSmallestUnique() {
        if (numbers.size() == 0) {
            throw new IllegalStateException("Attribute is empty!");
        }
        if (numbers.size() == 1) {
            return numbers.get(0);
        }

        List<Integer> sortedNumbers = new ArrayList<>();
        Collections.sort(sortedNumbers);

        if (numbers.get(0) != numbers.get(1)) {
            return numbers.get(0);
        }

        for (int i = 1; i < sortedNumbers.size(); i++) {
            if (sortedNumbers.get(i) != sortedNumbers.get(i - 1) && sortedNumbers.get(i) != sortedNumbers.get(i + 1)) {
                return sortedNumbers.get(i);
            }
        } if (numbers.get(numbers.size() - 1) != numbers.get(numbers.size() - 2)) {
            return sortedNumbers.get(numbers.size() - 1);
        }
        throw new IllegalStateException("No unique number!");
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void readFile(String fileName) {
        Path path = Path.of(fileName);

        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] temp = line.split(",");
                addNumbers(temp);
            }
        } catch (IOException exception) {
            throw new IllegalArgumentException("File reading is failed!");
        }
    }

    public void addNumbers(String[] temp) {
        for (String s : temp) {
            numbers.add(Integer.parseInt(s));
        }
    }

    public static void main(String[] args) {
        NumberStat numberStat = new NumberStat();
        numberStat.readFile("test.txt");
        System.out.println(numberStat.getNumbers());
        System.out.println(numberStat.findSmallestUnique());
    }

}
