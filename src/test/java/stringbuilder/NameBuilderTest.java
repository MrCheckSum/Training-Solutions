package stringbuilder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NameBuilderTest {

    @Test
    public void invalidParametersShouldThrowExceptionNullFamilyName() throws IllegalArgumentException {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new NameBuilder().concatNameHungarianStyle(null, "Van", "Jean-Claude", Title.MR);
        });
        Assertions.assertEquals("Family or given name is empty!", exception.getMessage());
    }

    @Test
    public void invalidParametersShouldThrowExceptionNullGivenName() throws IllegalArgumentException {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            new NameBuilder().concatNameHungarianStyle("Damme","Van", null, Title.MR);
        });
        Assertions.assertEquals("Family or given name is empty!", exception.getMessage());
    }

    @Test
    public void invalidParametersShouldThrowExceptionEmptyFamilyName() throws IllegalArgumentException {

        Exception ex = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new NameBuilder().concatNameHungarianStyle("", "Van", "Jean-Claude", Title.MR);
        });

        Assertions.assertEquals("Family or given name is empty!", ex.getMessage());


    }

    @Test
    public void invalidParametersShouldThrowExceptionEmptyGivenName() throws IllegalArgumentException {
        Exception ex = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new NameBuilder().concatNameHungarianStyle("Damme", "Van", "", Title.MR);

        });

        Assertions.assertEquals("Family or given name is empty!", ex.getMessage());
    }

    @Test
    public void westernStyleNameConcatenation() {

        Assertions.assertEquals("Mr. Jean-Claude Van Damme", new NameBuilder().concatNameWesternStyle("Damme", "Van", "Jean-Claude", Title.MR));
        Assertions.assertEquals("John W Doe", new NameBuilder().concatNameWesternStyle("Doe", "W", "John", null));
        Assertions.assertEquals("Mr. John Smith", new NameBuilder().concatNameWesternStyle("Smith", "", "John", Title.MR));
        Assertions.assertEquals("Mr. John Smith", new NameBuilder().concatNameWesternStyle("Smith", null, "John", Title.MR));
    }

    @Test
    public void hungarianStyleNameConcatenation() {

        Assertions.assertEquals("Mr. Smith G John", new NameBuilder().concatNameHungarianStyle("Smith", "G", "John", Title.MR));
        Assertions.assertEquals("Smith G John", new NameBuilder().concatNameHungarianStyle("Smith", "G", "John", null));
        Assertions.assertEquals("Mr. Smith John", new NameBuilder().concatNameHungarianStyle("Smith", "", "John", Title.MR));
        Assertions.assertEquals("Mr. Smith John", new NameBuilder().concatNameHungarianStyle("Smith", null, "John", Title.MR));
    }

    @Test
    public void insertTitle() {
        //Given
        String name = "Dr. John G Smith";
        //Then
        Assertions.assertEquals("Dr. Prof. John G Smith", new NameBuilder().insertTitle(name, Title.PROF, " "));
    }

    @Test
    public void deleteNamePart() {

        Assertions.assertEquals("Dr. John G Smith", new NameBuilder().deleteNamePart("Dr. Prof. John G Smith", "Prof. "));
    }
}
