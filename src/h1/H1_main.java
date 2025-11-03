package h1;

import java.util.random.RandomGenerator;

public class H1_main {

    double balance, monInc;
    int rating;
    boolean warning, negative;

    public static void main(String[] args) {
        H1_main ref = new H1_main();
        ref.setupValues();
        ref.bankAccountEvaluation();
        ref.outputEvaluation();
    }

    public void setupValues() {
        //Set random balance + round it to 2 decimals (cents)
        balance = RandomGenerator.getDefault().nextDouble(-20000, 10000);
        balance = (double) Math.round(balance * 100) / 100;

        //Random monthly income from 500 to 10000
        monInc = (double) RandomGenerator.getDefault().nextInt(500, 10000);

        //Normal bank account
        rating = 0;
    }

    public void bankAccountEvaluation() {

        //Account not in debt
        if(balance > 0) {
            negative = false;
            rating = rating + 3;
        }
        //Account in debt
        else if(balance < 0){
            negative = true;

            //Monthly income higher then debt
            if(Math.abs(monInc) >= Math.abs(balance)) {
                rating++;
            }
            else {
                rating--;
                //Warning
                if(rating < 0) {
                    warning = true;
                }
            }
        }
        //Balance == 0
        else {

            rating = rating + 2;
        }

    }

    //Print Evaluation results
    public void outputEvaluation() {
        System.out.println("[Simple Bank]");
        System.out.println("\n" + "Account balance: " + balance);
        System.out.println("Monthly income: " + monInc);
        System.out.println("Account rating: " + rating + "\n");

        if(negative) {
            System.out.println("[WARNING] Account is in debt!");
        }
        if(warning) {
            System.out.println("[WARNING] This account is not financially stable!");
        }
    }


}
