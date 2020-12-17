package simulator.verification;

public class RoundResult {
    private int triangular;
    private int fork;
    private int circle;

    public RoundResult(int triangular, int fork, int circle) {
        this.triangular = triangular;
        this.fork = fork;
        this.circle = circle;
    }

    @Override
    public String toString() {
        return "o-" + circle +
                "  x-" + fork +
                "  *-" + triangular;
    }
}
