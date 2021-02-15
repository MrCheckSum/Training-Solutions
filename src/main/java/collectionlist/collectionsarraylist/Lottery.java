package collectionlist.collectionsarraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottery {

    private List<Integer> allBalls(int nrOfBalls) {
        List<Integer> balls = new ArrayList<>();
        for (int idx = 1; idx < nrOfBalls; idx++) {
            balls.add(idx);
        }
        Collections.shuffle(balls);
        return balls;
    }

    public List<Integer> selectWinningNumbers(int lotteryType, int ballCount) throws IllegalArgumentException {
        if (ballCount < lotteryType) {
            throw new IllegalArgumentException("Number of all balls must be more than the number of winning balls!");
        }
        List<Integer> balls = allBalls(ballCount);
        List<Integer> winningBalls = balls.subList(0, lotteryType);
        return winningBalls;
    }

    public static void main(String[] args) {
        Lottery lottery = new Lottery();
        System.out.println(lottery.selectWinningNumbers(5, 90));
    }
}


