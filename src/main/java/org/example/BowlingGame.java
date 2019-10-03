package org.example;

public class BowlingGame {
    private int[] scores = new int[21];
    private int rollNumber = 0;

    public void roll(int ... rolls) {
        for(int roll: rolls) {
            this.scores[rollNumber++] = roll;
        }
    }

    public int score() {
        int sum = 0;
        int roll = 0;

        for(int frame = 1; frame <= 10; frame++) {
            if(scores[roll] == 10) {
                sum += 10 + scores[roll+1] + scores[roll+2];
                roll += 1;
            }
            else if(isASpare(roll)) {
                sum += 10 + scores[roll + 2];
                roll += 2;
            }
            else {
                sum += scores[roll] + scores[roll+1];
                roll += 2;
            }
        }
        return sum;
    }

    private boolean isASpare(int roll) {
        return scores[roll] + scores[roll+1] == 10;
    }
}
