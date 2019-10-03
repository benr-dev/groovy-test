package org.example;

public class BowlingGame {
    public static final int MAX_ROLLS_IN_GAME = 21;
    public static final int MAX_FRAMES_IN_GAME = 10;

    private int[] scores = new int[MAX_ROLLS_IN_GAME];
    private int rollNumber = 0;

    public void roll(int ... rolls) {
        for(int roll: rolls) {
            this.scores[rollNumber++] = roll;
        }
    }

    public int score() {
        int sum = 0;
        int roll = 0;

        for(int frame = 1; frame <= MAX_FRAMES_IN_GAME; frame++) {
            if(isAStrike(roll)) {
                sum += getStrikeScore(roll);
                roll += 1;
            }
            else if(isASpare(roll)) {
                sum += getSpareScore(roll);
                roll += 2;
            }
            else {
                sum += getRegularFrameScore(roll);
                roll += 2;
            }
        }
        return sum;
    }

    private int getSpareScore(int roll) {
        return 10 + scores[roll+2];
    }

    private int getStrikeScore(int roll) {
        return 10 + getRegularFrameScore(roll+1);
    }

    private int getRegularFrameScore(int roll) {
        return scores[roll] + scores[roll+1];
    }

    private boolean isAStrike(int roll) {
        return scores[roll] == 10;
    }

    private boolean isASpare(int roll) {
        return getRegularFrameScore(roll) == 10;
    }
}
