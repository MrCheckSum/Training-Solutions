package catalog;

import java.util.ArrayList;
import java.util.List;

public class CatalogItem {

    private List<Feature> features = new ArrayList<>();
    private final int price;
    private final String registrationNumber;

    public CatalogItem(String registrationNumber, int price, Feature... feature) {
        this.registrationNumber = registrationNumber;
        this.price = price;

        for (int i = 0; i < feature.length; i++) {
            features.add(feature[i]);
        }
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public int getPrice() {
        return price;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public int fullLengthAtOneItem() {
        int sum = 0;
        for (Feature feature : features) {
            if (feature instanceof AudioFeatures) {
                sum += ((AudioFeatures) feature).getLength();
            }
        }
        return sum;
    }

    public List<String> getContributors() {

        List<String> contributorsList = new ArrayList<>();
        List<String> listOfContributors = new ArrayList<>();

        for (Feature feature : features) {
            for (String item : feature.getContributors()) {
                listOfContributors.add(item);
            }
        }
        for (int i = 0; i < listOfContributors.size(); i++) {
            contributorsList.add(listOfContributors.get(i));
        }
        return contributorsList;
    }

    public List<String> getTitles() {
        List<String> titleList = new ArrayList<>();
        for (Feature feature : features) {
            titleList.add(feature.getTitle());
        }
        return titleList;
    }

    public boolean hasAudioFeature() {
        boolean hasAudio = false;
        for (Feature feature : features) {
            if (feature instanceof AudioFeatures) {
                hasAudio = true;
                break;
            }
        }
        return hasAudio;
    }

    public boolean hasPrintedFeature() {
        boolean hasPrinted = false;
        for (Feature feature : features) {
            if (feature.getClass() == PrintedFeatures.class) {
                hasPrinted = true;
                break;
            }
        }
        return hasPrinted;
    }

    public int numberOfPagesAtOneItem() {
        int numberOfPages = 0;
        for (Feature feature : features) {
            if (feature.getClass() == PrintedFeatures.class) {
                numberOfPages = ((PrintedFeatures) feature).getNumberOfPages();
            }
        }
        return numberOfPages;
    }
}