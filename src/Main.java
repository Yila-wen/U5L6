import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int input = 9;

        Bank b1 = new Bank();
        BankApp acc1 = new BankApp("Joe","1010",b1);

        while (input!= 0) {


            System.out.println(BankApp.appMenu());
            input = s.nextInt();
            if (input == 1) {
                System.out.println("How many bagels would you like to buy?");
                int quantity = s.nextInt();
                System.out.println("What is your PIN?");
                int PIN = s.nextInt();
                String pin = "" + PIN;

                System.out.println("");
                System.out.println(acc1.purchaseBagels(quantity, pin));
                System.out.println("");

            } else if (input == 2) {
                System.out.println("How many bagels will be returned?");
                int q = s.nextInt();
                System.out.println("What is your PIN?");
                int PIN = s.nextInt();
                String pin = "" + PIN;

                System.out.println("");
                System.out.println(acc1.returnBagels(q,pin));
                System.out.println("");

            } else if (input == 3) {
                System.out.println("How much would you like to pay?");
                int q = s.nextInt();
                System.out.println("");
                System.out.println(acc1.payment(q));
                System.out.println("");

            } else if (input == 4) {
                System.out.println("What PIN would you like?");
                int PIN = s.nextInt();
                String pin = "" + PIN;

                System.out.println("");
                System.out.println( acc1.secondCard(pin));
                System.out.println("");
                System.out.println("Enter 1 if you would like your first card to be used for purchase. \n" +
                        "Enter 2 if you would like your second card to be used for purchase.");
                int outcome = s.nextInt();
                if (outcome == 1 || outcome == 2){
                acc1.ucPurchaseSetter(outcome);}
                else while (outcome != 1 || outcome != 2){
                    System.out.println("Pleases enter a valid input.");
                outcome = s.nextInt();}
                acc1.ucPurchaseSetter(outcome);
                System.out.println("");


            } else if (input == 5) {
                System.out.println(acc1.compareCards());
                System.out.println("");


            } else if (input == 6) {
                System.out.println(acc1.depositProfit());
                System.out.println("");

            } else if (input == 7) {
                System.out.println(acc1.checkInventory());
                System.out.println("");

            } else if (input == 0) {
            } else System.out.println("Please enter a valid input.");
        }



    }
}