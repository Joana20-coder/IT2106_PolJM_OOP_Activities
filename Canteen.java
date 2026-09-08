import java.util.Scanner;

class Canteen {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        char again;

        do {
            // MENU
            System.out.println("===== M E N U =====");
            System.out.println("1. Chicken Rice  - $110.00");
            System.out.println("2. Spaghetti     - $95.00");
            System.out.println("3. Siomai        - $60.00");
            System.out.println("4. French Fries  - $75.00");
            System.out.println("5. Iced Tea      - $50.00");
            System.out.println();

            // INPUT
            System.out.print("Enter item number: ");
            int item = input.nextInt();

            System.out.print("Enter quantity: ");
            int quantity = input.nextInt();

            // VALIDATION
            if (item < 1 || item > 5 || quantity < 1 || quantity > 10) {

                System.out.println();
                System.out.println(
                    "Invalid order! Please enter a valid item and quantity."
                );

            } else {

                System.out.print("Are you a student? (Y/N): ");
                char student = input.next().charAt(0);

                // Check student input
                if (student != 'Y' && student != 'y' &&
                    student != 'N' && student != 'n') {

                    System.out.println(
                        "Invalid student status! Please enter Y or N."
                    );

                } else {

                    double price = 0;

                    // ITEM PRICE
                    switch (item) {
                        case 1:
                            price = 110;
                            break;
                        case 2:
                            price = 95;
                            break;
                        case 3:
                            price = 60;
                            break;
                        case 4:
                            price = 75;
                            break;
                        case 5:
                            price = 50;
                            break;
                    }

                    // SUBTOTAL
                    double subtotal = price * quantity;

                    // DISCOUNT
                    double discountRate = 0;

                    if ((student == 'Y' || student == 'y') && subtotal >= 500) {
                        // Student + $500 or more = 15%
                        discountRate = 0.15;
                    }
                    else if (student == 'Y' || student == 'y') {
                        // Student = 10%
                        discountRate = 0.10;
                    }
                    else if (subtotal >= 500) {
                        // $500 or more = 5%
                        discountRate = 0.05;
                    }

                    // CALCULATE DISCOUNT
                    double discount = subtotal * discountRate;

                    // CALCULATE ORDER TOTAL
                    double orderTotal = subtotal - discount;

                    // OUTPUT
                    System.out.printf("%nSubtotal: $%.2f%n", subtotal);
                    System.out.printf("Discount: $%.2f%n", discount);
                    System.out.printf("Order total: $%.2f%n", orderTotal);
                }
            }

            // ORDER AGAIN
            System.out.print("\nDo you want to order again? (Y/N): ");
            again = input.next().charAt(0);

            System.out.println();

        } while (again == 'Y' || again == 'y');

        System.out.println("Thank you for ordering!");

        input.close();
    }
}
