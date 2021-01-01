package stringbuilder;

public class NameBuilder {
    public String concatNameWesternStyle(String familyName, String middleName, String givenName, Title title) {
        if (isEmpty(familyName) || isEmpty(givenName)) {
            throw new IllegalArgumentException("Family or given name is empty!");
        }
        StringBuilder nameString = new StringBuilder();

        if (title != null) {
            nameString.append(title.getTitleString()).append(" ").append(givenName);
        } else {
            nameString.append(givenName);
        }
        nameString.append(" ");
        if (middleName != null && !"".equals(middleName)) {
            nameString.append(middleName).append(" ");
        }
        nameString.append(familyName);

        return nameString.toString();
    }

    public String concatNameHungarianStyle(String familyName, String middleName, String givenName, Title title) {
        if (isEmpty(familyName) || isEmpty(givenName)) {
            throw new IllegalArgumentException("Family or given name is empty!");
        }

        StringBuilder nameString = new StringBuilder();

        if (title != null) {
            nameString.append(title.getTitleString()).append(" ").append(familyName);
        } else {
            nameString.append(familyName);
        }
        nameString.append(" ");
        if (middleName != null && !"".equals(middleName)) {
            nameString.append(middleName).append(" ");
        }
        nameString.append(givenName);
        return nameString.toString();
    }

    public String insertTitle(String name, Title title, String where) {
        StringBuilder sb = new StringBuilder(name);
        int index = sb.indexOf(where);
        sb.insert(index + 1, (title.getTitleString() + " "));
        return sb.toString();
    }

    public String deleteNamePart(String name, String deleteString) {
        int index = name.indexOf(deleteString);
        StringBuilder sb = new StringBuilder(name);
        sb.delete(index, index + deleteString.length());

        return sb.toString();
    }

    private boolean isEmpty(String str) {
        return str == null || "".equals(str.trim());
    }

}
