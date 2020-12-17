package simulator.simulation;

public class Result {
    private int MAX_TRIES = 15;

    private int triedTimes;
    private boolean success;
    private int usefulTries;
    private int wastedTries;
    private boolean infiniteTries;
    private char[] target;

    public Result() {
        this.triedTimes = 0;
        this.success = false;
        this.usefulTries = 0;
        this.wastedTries = 0;
        this.infiniteTries = false;
    }

    public void setInfiniteTries(Boolean infiniteTries) {
        this.infiniteTries = infiniteTries;
    }
    public void setMaxTries(int maxTries) {
        this.MAX_TRIES = maxTries;
    }
    public void setTarget(char[] target) { this.target = target;}

    public void win() {
        this.success = true;
        throw new RuntimeException("SUCCEED");
    }

    public void usefulTry() {
        ++triedTimes;
        ++usefulTries;
        checkEndOfGame();
    }

    public void wastefulTry() {
        ++triedTimes;
        ++wastedTries;
        checkEndOfGame();
    }

    private void checkEndOfGame() {
        if (infiniteTries) return;
        if (triedTimes > MAX_TRIES) {
            throw new RuntimeException("Reaching MAX tried times: " + MAX_TRIES);
        }
    }

    @Override
    public String toString() {
        return "--------------------------------------------\n" +
                "Round Result:\n" +
                "  target      : " + target.toString() +
                "  result      : " + (success ? "WIN" : "LOSE") + "\n" +
                "  tried       : " + triedTimes + " time(s)" + "\n" +
                "  useful tries: " + usefulTries + " time(s)" + "\n" +
                "  wasted tries: " + wastedTries + " time(s)" + "\n" +
                "--------------------------------------------";
    }
}
