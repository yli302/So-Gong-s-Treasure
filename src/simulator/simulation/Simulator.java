package simulator.simulation;

import simulator.generator.TargetGenerator;
import simulator.verification.RoundResult;
import simulator.verification.VerifyResult;

import java.util.Scanner;

public class Simulator {
    private boolean hideTarget = false;
    private boolean testPurpose = false;

    private final Result result = new Result();

    public void checkArgument(String arg) {
        if (arg.startsWith("-hide=")) {
            hideTarget = Boolean.parseBoolean(arg.substring(6));
        } else if (arg.startsWith("-infinite=")) {
            result.setInfiniteTries(Boolean.valueOf(arg.substring(10)));
        } else if (arg.startsWith("-max=")) {
            result.setMaxTries(Integer.parseInt(arg.substring(5)));
        } else if (arg.startsWith("-test=")) {
            testPurpose = Boolean.parseBoolean(arg.substring(6));
        }
    }

    public Result simulate() {
        char[] target = TargetGenerator.generate();
        if (!testPurpose && !hideTarget) System.out.println("\n-- Target: " + target[0] + " " + target[1] + " " + target[2] + "\n");

        while (true) {
            if (round(target)) break;
        }

        return result;
    }

    private boolean round(char[] target) {
        if (!testPurpose) System.out.print("> Enter your try (space between each digit): ");
        Scanner scanner = new Scanner(System.in);
        char[] input = scanner.next().replaceAll(" ", "").toCharArray();
        if (input.length == 1 && input[0] == 'q') throw new RuntimeException("FORCE QUIT GAME");
        if (input.length != 3
                || !Character.isDigit(input[0])
                || !Character.isDigit(input[1])
                || !Character.isDigit(input[2])) {
            if (!testPurpose) System.out.println("!!! Invalid Input !!!");
            return false;
        }

        try {
            RoundResult roundResult = VerifyResult.verify(result, target, input);
            if (!testPurpose) System.out.println(roundResult);
        } catch (Exception e) {
            return true;
        }

        return false;
    }
}
