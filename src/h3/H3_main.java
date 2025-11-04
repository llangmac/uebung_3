package h3;

import java.util.random.RandomGenerator;

public class H3_main {

    int max, fix, waiting;
    boolean maxCapacity;

    public static void main(String[] args) {
        H3_main ref = new H3_main();

        ref.setupValues();
        ref.outputValues();
        ref.equalizeSlots();
        ref.outputValues();
    }

    //Original Setup of Values (random)
    public void setupValues() {
        max = RandomGenerator.getDefault().nextInt(2500, 5000);
        fix = max - RandomGenerator.getDefault().nextInt(500, 1000);
        waiting = RandomGenerator.getDefault().nextInt(2500, 10000);
    }

    //Filling up leftover space
    public void equalizeSlots() {
        if(!maxCapacity) {
            //Temp int to save difference
            int i = max - fix;
            //Subtract available ticket slots from waiting list
            waiting = waiting - i;
            //Fix = max now, max Capacity reached
            fix = max;
            maxCapacity = true;

            //Preparing for printing updated values
            System.out.println("\n" + "[WARNING] Full capacity not reached, auto-updating values!");
            System.out.println("\n" + "----[Updated Values]----");
        }
    }

    //Printing ticket stats
    public void outputValues() {
        System.out.println("\n" + "[Ticket Manager]  ");
        System.out.println("Max Capacity: " + max);
        System.out.println("Sold Tickets: " + fix);
        System.out.println("Waiting List: " + waiting);
    }
}
