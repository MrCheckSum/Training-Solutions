package collectionsset.collectionshashset;

import collectionsset.helper.RandomStringGenerator;
import org.junit.jupiter.api.Test;


import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class StringsHandlerTest {

    RandomStringGenerator rsg = new RandomStringGenerator();
    Set<String> testStrings1 = new HashSet<>(rsg.createStrings(10, 100));
    Set<String> testStrings2 = new HashSet<>(rsg.createStrings(10, 100));


    @Test
    void filterUniqueStrings() {
        Collection<String> testCollection = new RandomStringGenerator().createStrings(2, 1000);

        Set<String> testStrings3 = new StringsHandler().filterUniqueStrings(testCollection);
      //  System.out.println(testCollection);
      //  System.out.println("");
      //  System.out.println(testStrings3);
        assertTrue(testStrings3.size() < testCollection.size());

    }

    @Test
    void selectIdenticalStrings() {

        int a = testStrings1.size();
        int b = testStrings2.size();

        testStrings1 = new StringsHandler().selectIdenticalStrings(testStrings1, testStrings2);

        assertTrue(testStrings1.size() < (a + b));

    }
}