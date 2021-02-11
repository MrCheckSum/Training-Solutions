package week14d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.RecursiveTask;

/*
Adott egy fájl melyben online bevásárlások találhatók. A fájl a még ki nem szállított rendeléseket tartalmazza.
Egy sorban egy egyedi azonosító és utána a termékek neve van felsorololva. Minden vásárlás legalább 2 termékből áll.
```
A233 bread,tomato,flour,sugar
A312 sugar,beer,apple,pear
B3402 meet,soda,cola,bbq_sauce
B341 pasta,passata,basil,cheese
A10 corn,hot_dog,rolls
CM231 beer,chips
C123 pepper,salt,rosmary,pizza_dough,passata,oregano
W34111 pasta,sugar,rosmary,cheese,meet,carrot,potato,tomato
K8921 wine,soda
```
Olvasd be a fájlt és tárold el az adatokat a memóriában, majd oldd meg a következő feladatokat.
1. Egyedi azonosító alapján legyenek lekérdezhetőek a vásárolt termékek ABC sorrendben.
2. Számoljuk össze, egy termék neve alapján, hogy abból a termékből mennyit adtak el.
3. Adjuk vissza egy vásárlási azonosító alapján, hogy hány termék szerepel a vásárlásban.
4. Készíts statisztikát melyben visszaadod, hogy az egyes termékek hányszor szerepelnek a fájlban.
 */
public class OnlineShop {

    private Map<String, List<String>> list = new LinkedHashMap<>();

    public void readFile(Path file) {
        try {
            BufferedReader bufferedReader = Files.newBufferedReader(file);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] listParts = line.split(" ");
                String[] items = listParts[1].split(",");
                List<String> result = new ArrayList<>();
                for (String item : items) {
                    result.add(item);
                }
                list.put(listParts[0], result);
            }

        } catch (IOException ioException) {
            throw new IllegalStateException("File is non-readable!", ioException);
        }
    }

    public List<String> getItemsById(String id) {
        List<String> items = new ArrayList<>(list.get(id));
        Collections.sort(items);
        return items;

    }

    public List<String> getSoldAmountByItemIdd(String id){
        List<String> amount = getItemsById(id);
        Collections.reverse(amount);
        return amount;
    }
/*
    public int getItemOfItemSold(String item){
        int nr =0;
        Collection<List<String>> values = list.values();

    }*/
}
