package week15d04;

import week15d02.Category;

public class Covid19ByWeeks implements Comparable<Covid19ByWeeks>{
    private String week;
    private  int nrOfCases;

    public Covid19ByWeeks(String week, int nrOfCases) {
        this.week = week;
        this.nrOfCases = nrOfCases;
    }

    public String getWeek() {
        return week;
    }

    public int getNrOfCases() {
        return nrOfCases;
    }

    @Override
    public String toString() {
        return "Covid19ByWeeks{" +
                "week='" + week + '\'' +
                ", nrOfCases=" + nrOfCases +
                '}';
    }

    @Override
    public int compareTo(Covid19ByWeeks o) {
        return o.nrOfCases-this.nrOfCases;
    }
}
