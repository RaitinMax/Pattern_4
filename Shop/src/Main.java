import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Seller seller = null;
        Shop shop = new Shop(System.out::println);
        try (Scanner scanner = new Scanner(System.in)){
            while (true) {
                System.out.println("1. Products \n" +
                        "2. Pay\n" +
                        "3. Sell goods\n" +
                        "4. Exit");
                int input = input(scanner);
                if (input == 4) break;
                switch (input) {
                    case 1 -> {
                        System.out.println(shop);
                        System.out.println("");
                        int number = input(scanner);
                        System.out.println("Enter quantity");
                        int count = input(scanner);
                        shop.add(shop.getItems().get(number - 1), count);
                        System.out.println("Product added to cart!");
                    }
                    case 2 -> {
                        if (!shop.isEmpty()) shop.buy();
                    }
                    case 3 -> {
                        if (seller == null) {
                            System.out.println("What is the name of your organization");
                            seller = new Seller(scanner.nextLine());
                        }
                        System.out.println("What do you want to sell?");
                        String item = scanner.nextLine();
                        System.out.println("How much will your product cost?");
                        int price = input(scanner);
                        shop.addItem(new Item(item, price, seller));
                        System.out.println("Item is up for sale");
                    }
                }
            }
        }
    }

    public static int input(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Введено не число. Введите повторно");
            return input(scanner);
        }
    }
}
