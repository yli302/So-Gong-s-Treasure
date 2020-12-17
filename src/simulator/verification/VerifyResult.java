package simulator.verification;

import simulator.simulation.Result;

public class VerifyResult {
    public static RoundResult verify (Result result, char[] target, char[] input) {
        int triangular = 0;
        int circle = 0;
        int fork = 0;

        if (input[0] == target[0]) {
            ++circle;
        } else {
            int temp = triangular;
            if (input[0] == target[1]) ++triangular;
            if (input[0] == target[2]) ++triangular;
            if (temp == triangular) ++fork;
        }

        if (input[1] == target[1]) {
            ++circle;
        } else {
            int temp = triangular;
            if (input[1] == target[0]) ++triangular;
            if (input[1] == target[2]) ++triangular;
            if (temp == triangular) ++fork;
        }

        if (input[2] == target[2]) {
            ++circle;
        } else {
            int temp = triangular;
            if (input[2] == target[0]) ++triangular;
            if (input[2] == target[1]) ++triangular;
            if (temp == triangular) ++fork;
        }

        if (fork == 3) result.wastefulTry();
        else result.usefulTry();
        if (circle == 3) result.win();

        return new RoundResult(triangular, fork, circle);
    }

}