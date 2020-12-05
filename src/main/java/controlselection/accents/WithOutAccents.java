package controlselection.accents;

public class WithOutAccents {

    public static final String LETTERS_WITH_ACCENTS = "áéíóöőúüűÁÉÍÓÖŐÚÜŰ";
    public static final String LETTERS_WITHOUT_ACCENTS = "aeiooouuuAEIOOOUUU";

    public char convertToWithOutAccentChar(char chr) {

        int idx = LETTERS_WITH_ACCENTS.indexOf(chr);
        if (idx >= 0) {
            return LETTERS_WITHOUT_ACCENTS.charAt(idx);
        } else {
            return chr;
        }
    }

}
