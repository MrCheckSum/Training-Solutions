package ioprintwriter.talentshow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ResultCalculator {

    private List<Production> productions = new ArrayList<>();
    private List<Vote> votes = new ArrayList<>();
    private Object IOException;

    public void readTalents(Path file) {
        try (BufferedReader bufferedReader = Files.newBufferedReader(file)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] dataLine = line.split(" ");
                Production production = new Production(Long.parseLong(dataLine[0]), dataLine[1]);
                productions.add(production);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("File is non-readable!", ioe);
        }
    }

    private void addVote(int id) {
        boolean exist = false;
        for (Vote vote : votes) {
            if (vote.getId() == id) {
                vote.increaseNumber();
                exist = true;
            }
        }
        if (!exist) {
            votes.add(new Vote(id, 1));
        }
    }

    public void calculateVotes(Path file) {
        try (BufferedReader bufferedReader = Files.newBufferedReader(file)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                int vote = Integer.parseInt(line);
                addVote(vote);
            }
        } catch (IOException ioException) {
            throw new IllegalStateException("File is non-readable!", ioException);
        }
    }

    private Production findProductionById(long id) {
        for (Production production : productions) {
            if (production.getId() == id) {
                return production;
            }
        }
        return null;
    }

    private Production findWinner() {
        int max = votes.get(0).getNumber();
        long maxId = votes.get(0).getId();
        for (Vote vote : votes) {
            if (vote.getNumber() > max) {
                max = vote.getNumber();
                maxId = vote.getId();
            }
        }

        for (Production production : productions) {
            if (maxId == production.getId()) {
                return production;
            }
        }
        return null;

    }


    public void writeResultToFile(Path file) {
        try (PrintWriter printWriter = new PrintWriter(Files.newBufferedWriter(file))) {
            for (Vote vote : votes) {
                Production production = findProductionById(vote.getId());
                printWriter.print(vote.getId() + " ");
                printWriter.print(production.getName() + " ");
                printWriter.print(vote.getNumber() + " ");
                printWriter.println();
            }
            printWriter.print("Winner: " + findWinner().getName());
        } catch (java.io.IOException ioException) {
            throw new IllegalStateException("File is non-writeable!", ioException);
        }
    }

    public List<Production> getProductions() {
        return productions;
    }

    public List<Vote> getVotes() {
        return votes;
    }
}
