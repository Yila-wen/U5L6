public class BankApp {


    private String name;
    private String PIN;
    private Bank userBank;
    private CreditCard userCard;
    private int ucPurchase;
    // 1: userCard = purchase
    // 2: secondUserCard = purchase
    // 3: only 1 card
    private CreditCard secondUserCard;
    private BagelShop userBagelShop;



    public BankApp(String name,String PIN,Bank userBank){
        ucPurchase = 3;
        CreditCard userCard = new CreditCard(name,PIN);
        BagelShop userBagelShop = new BagelShop("Mike koxlong's Bagel Shop",50,5,userBank);
        this.name = name;
        this.PIN = PIN;
        this.userBank = userBank;
        this.userCard = userCard;
        this.userBagelShop = userBagelShop;


    }

    public static String appMenu() {
        return "Enter 1 if, You would like to make a purchase at the bagel shop. \n"+
                "Enter 2 if, You would like to make a return at the bagel shop.\n"+
                "Enter 3 if, You would like to make a payment on the credit card.\n"+
                "Enter 4 if, You would like to open a second card.\n"+
                "Enter 5 if, You would like to compare credit card balances.\n"+
                "Enter 6 if, You would like to deposit profits into the bank.\n"+
                "Enter 7 if, You would like to check the inventory.\n"+
                "Enter 0 if, you would like to exit.\n";

    }
    public void ucPurchaseSetter(int value){
        ucPurchase = value;
    }



    public String purchaseBagels(int quantity,String cardPIN){
        boolean outcome = false;
        if (ucPurchase == 1 ){
            outcome = userBagelShop.payForBagels(userCard,quantity,cardPIN);
        if (outcome == false){ return "Your purchase was not successful.";}
        else return "Receipt \n"+ quantity + " Bagels  "+ "$"+(userBagelShop.getBagelPrice()*quantity);
        }
        else if (ucPurchase == 2){
             outcome = userBagelShop.payForBagels(secondUserCard,quantity,cardPIN);
            if (outcome == false){ return "Your purchase was not successful.";}
            else return "Receipt \n"+ quantity + " Bagels  "+ "$"+(userBagelShop.getBagelPrice()*quantity);
        }
        else
            outcome = userBagelShop.payForBagels(userCard,quantity,cardPIN);
        if (outcome == false){ return "Your purchase was not successful.";}
        else return "Receipt \n"+ quantity + " Bagels  "+ "$"+(userBagelShop.getBagelPrice()*quantity);}


    public BagelShop returnBagels(int quantity,String cardPIN){
        if  (ucPurchase == 1){
            userBagelShop.returnBagels(secondUserCard,quantity,cardPIN);
            return userBagelShop;

        }
        else if (ucPurchase == 2){
        userBagelShop.returnBagels(userCard,quantity,cardPIN);
        return userBagelShop;}
        else userBagelShop.returnBagels(userCard,quantity,cardPIN);
        return userBagelShop;
    }

    public CreditCard payment(int payment){
        userBank.makePayment(userCard,payment);
        return  userCard;
    }

    public CreditCard secondCard(String PIN){
        CreditCard secondUserCard = new CreditCard(name,PIN);
        this.secondUserCard = secondUserCard;
        return secondUserCard;
    }

    public CreditCard compareCards() {
        if (secondUserCard != null){
        return userBank.lowerBalance(userCard,secondUserCard);}
        else
            return userCard;

    }

    public Bank depositProfit(){
        userBagelShop.depositProfits();
        return userBank;
    }
    public String checkInventory(){
        int num = userBagelShop.getInventory();
        return "Inventory: "+ num;
    }




}
