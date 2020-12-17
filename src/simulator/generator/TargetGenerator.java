package simulator.generator;

import java.util.Random;

public class TargetGenerator {

    public static char[] generate() {
        char[] target = new char[3];

        Random random = new Random();
        target[0] = (char)('0' + random.nextInt(10));
        target[1] = (char)('0' + random.nextInt(10));
        while (target[0] == target[1]) {
            target[1] = (char)('0' + random.nextInt(10));
        }
        target[2] = (char)('0' + random.nextInt(10));
        while (target[0] == target[2] || target[1] == target[2]) {
            target[2] = (char)('0' + random.nextInt(10));
        }

        return target;
    }
}
