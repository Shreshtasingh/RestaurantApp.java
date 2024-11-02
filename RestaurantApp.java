import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Restaurant {
    String customerName;
    String foodType;
    List<String> selectedDishes;
    int totalBill;

    public Restaurant() {
        selectedDishes = new ArrayList<>();
        totalBill = 0;
    }

    public void acceptOrder() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        customerName = scanner.nextLine();

        System.out.print("Enter the type of food (Indian/Italian/Chinese): ");
        foodType = scanner.nextLine();

        displayDishOptions();

        String choice;
        do {
            System.out.print("Select a dish (or type 'exit' to finish): ");
            choice = scanner.nextLine().toLowerCase();
            if (!choice.equals("exit")) {
                selectedDishes.add(choice);
                totalBill += calculateDishPrice(choice);
            }
        } while (!choice.equals("exit"));
    }

    public int calculateDishPrice(String dish) {
        Map<String, Integer> dishPrices = new HashMap<>();
        dishPrices.put("chole bhature", 150);
        dishPrices.put("aalu paratha", 120);
        dishPrices.put("pasta", 200);
        dishPrices.put("pizza", 250);
        dishPrices.put("manchurian", 180);
        dishPrices.put("fried rice", 160);
        return dishPrices.getOrDefault(dish, 0);
    }

    // Method to display order details
    public void displayOrderDetails() {
        System.out.println("\nOrder Details:");
        System.out.println("Customer Name: " + customerName);
        System.out.println("Food Type: " + foodType);
        System.out.println("Selected Dishes: " + selectedDishes);
        System.out.println("Total Bill: $" + totalBill);
    }

    // Method to display dish options based on food type
    private void displayDishOptions() {
        System.out.println("\nDish Options:");

        switch (foodType.toLowerCase()) {
            case "indian":
                System.out.println("1. Chole Bhature - $150");
                System.out.println("2. Aalu Paratha - $120");
                break;
            case "italian":
                System.out.println("1. Pasta - $200");
                System.out.println("2. Pizza - $250");
                break;
            case "chinese":
                System.out.println("1. Manchurian - $180");
                System.out.println("2. Fried Rice - $160");
                break;
            default:
                System.out.println("Invalid food type.");
        }
    }
}

public class RestaurantApp {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();

        restaurant.acceptOrder();
        restaurant.displayOrderDetails();
    }
}
