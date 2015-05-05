package org.eclipse.viatra.cep.jnect.eventmodel.handlers;

public class Stats {
    private static Stats instance;

    public static Stats getInstance() {
        if (instance == null) {
            instance = new Stats();
        }
        return instance;
    }

    private int matches = 0;
    private long startTime = 0l;

    public long getRunningTime(long currentTimestamp) {
        return currentTimestamp - startTime;
    }

    public int getMatches() {
        return matches;
    }

    public void setMatches(int matches) {
        this.matches = matches;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public void addMatch() {
        matches++;
    }
}
