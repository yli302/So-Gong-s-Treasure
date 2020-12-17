package simulator;

import simulator.simulation.Result;
import simulator.simulation.Simulator;

public class SimulatorMain {

    public static void main(String[] args) {
        System.out.println("-------- Simulator Starts --------");

        Simulator simulator = new Simulator();
        for (String arg : args) {
            simulator.checkArgument(arg);
        }

        Result result = simulator.simulate();
        System.out.println(result);

        System.out.println("-------- Simulator Ends --------");
    }
}
