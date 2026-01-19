public class CoffeeShop {
    public static void main(String[] args) {

        Customer c1 = new Customer("Joseph", 200);
        Customer c2 = new Customer("Peter", 0);
        Customer c3 = new Customer(); 

        c2.addPoints(135);
        c2.addPoints(20);
        System.out.println();
        c1.redeemReward();
        c2.redeemReward();
        c3.redeemReward();
        
        System.out.println("==[Customer Information]==\n");
        c1.displayCustomerInfo();
        c2.displayCustomerInfo();
        c3.displayCustomerInfo();
        Customer.displayTotalCustomers();
        System.out.println();

        Customer c4 = new Customer("Diane", 0);
        c4.addPoints(50);
        c4.displayCustomerInfo();
        Customer.displayTotalCustomers();
      System.out.println();
        Customer.getAllowedRewardsRedemption(c1);
        Customer.getAllowedRewardsRedemption(c2);
        Customer.getAllowedRewardsRedemption(c3);
        Customer.getAllowedRewardsRedemption(c4);
    }
}

class Customer {

    String name;
    int points;
    static int totalCustomers = 0;
    Customer() {
        name = "Unknown";
        points = 0;
        totalCustomers++;
    }

     Customer(String n, int p) {
        name = n;
        points = p;
        totalCustomers++;
    }

    void addPoints(int p) {
        points = points + p;
        System.out.println(name + " earned " + p + " points. Total points: " + points);
    }
    void redeemReward() {
        if (points >= 100) {
            points = points - 100;
            
            System.out.println("Congratulations " + name + "! You redeemed a free drink!");
            System.out.println("Remaining Points: " + points); } 
            else {
            System.out.println(name + " does not have enough points to redeem a drink.");
        }
        System.out.println();
    }
    void displayCustomerInfo() {
        System.out.println("Customer: " + name);
        System.out.println("Points: " + points);
        System.out.println();
        System.out.println("———————————————————");
        
    } 
    static void displayTotalCustomers() {
        System.out.println("Total Registered Customers: " + totalCustomers);
    }
    static void getAllowedRewardsRedemption(Customer c) {
        int redeemCount = c.points / 100;
        System.out.println(c.name + " can redeem " + redeemCount + " reward(s).");
    }
}
