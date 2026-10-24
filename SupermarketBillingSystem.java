import java.util.Scanner;

class Product {
    String name;
    double price;
    int quantity;

    Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    double getTotal() {
        return price * quantity;
    }
}

public class SupermarketBillingSystem
 {

    public static double calculateDiscount(double total) {
        double discount = 0;

        if (total >= 5000) {
            discount = total * 0.20; // 20% discount
        } else if (total >= 3000) {
            discount = total * 0.15; // 15% discount
        } else if (total >= 1000) {
            discount = total * 0.10; // 10% discount
        }

        return discount;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== Supermarket Checkout System =====");
        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        Product[] items = new Product[n];
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for item " + (i + 1));

            System.out.print("Product Name: ");
            sc.nextLine(); // clear buffer
            String name = sc.nextLine();

            System.out.print("Price: ");
            double price = sc.nextDouble();

            System.out.print("Quantity: ");
            int quantity = sc.nextInt();

            items[i] = new Product(name, price, quantity);
            grandTotal += items[i].getTotal();
        }

        double discount = calculateDiscount(grandTotal);
        double finalAmount = grandTotal - discount;

        // Bill printing
        System.out.println("\n========= BILL =========");
        System.out.printf("%-15s %-10s %-10s %-10s\n", "Item", "Price", "Qty", "Total");

        for (Product p : items) {
            System.out.printf("%-15s %-10.2f %-10d %-10.2f\n",
                    p.name, p.price, p.quantity, p.getTotal());
        }

        System.out.println("------------------------------");
        System.out.printf("Grand Total : %.2f\n", grandTotal);
        System.out.printf("Discount    : %.2f\n", discount);
        System.out.printf("Final Amount: %.2f\n", finalAmount);
        System.out.println("==============================");

        sc.close();
    }
}