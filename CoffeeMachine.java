package machine;
import java.util.Scanner;

public class CoffeeMachine {

    public static void showMachineContent (int[] machineContent) {
        String output = String.format("The coffee machine has:%n%d of water%n%d of milk%n%d of coffee beans%n%d of disposable cups%n%d of money", machineContent[0], machineContent[1], machineContent[2], machineContent[3], machineContent[4]);
        System.out.println(output);
    }

    public static void makeCoffee (int[] machineContent, int[] coffeeIngredients) {
        String output1 = "I have enough resources, making you a coffee!";
        String output2 = "";
        boolean canMakeCoffee = true;
        for (int i = 0; i < coffeeIngredients.length - 1; i++) {
            if (machineContent[i] < coffeeIngredients[i]) {
                output1 = "Sorry, not enough ";
                canMakeCoffee = false;
                if (i == 0) {
                    output2 = "water!";
                    break;
                }
                else if (i == 1) {
                    output2 = "milk";
                    break;
                }
                else if (i == 2) {
                    output2 = "coffee!";
                    break;
                }
                else if (i == 3) {
                    output2 = "cups!";
                    break;
                }
            }
        }
        if (canMakeCoffee) {
            for (int i = 0; i < coffeeIngredients.length - 1; i++) {
                machineContent[i] -= coffeeIngredients[i];
            }
            machineContent[4] += coffeeIngredients[4];
        }
        System.out.println(output1 + output2);
    }

    public static void buyCoffee (int[] machineContent) {
        Scanner scanner = new Scanner(System.in);
        int[] espresso = new int[] {250, 0, 16, 1, 4};
        int[] latte = new int[] {350, 75, 20, 1, 7};
        int[] cappuccino = new int[] {200, 100, 12, 1, 6};
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        String userChoice = scanner.next();
        switch (userChoice) {
            case "back":
                showMenu(machineContent);
            case "1":
                makeCoffee(machineContent, espresso);
                break;
            case "2":
                makeCoffee(machineContent, latte);
                break;
            case "3":
                makeCoffee(machineContent, cappuccino);
                break;
            default:
                System.out.println("Incorrect input!");
                buyCoffee (machineContent);
        }
        return;
    }

    public static void fillMachine (int[] machineContent) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water do you want to add:");
        machineContent[0] += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        machineContent[1] += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        machineContent[2] += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        machineContent[3] += scanner.nextInt();
        return;
    }

    public static void takeMoney (int[] machineContent) {
        System.out.println("I gave you $" + machineContent[4]);
        machineContent[4] = 0;
        return;
    }

    public static void showMenu (int[] machineContent) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write action (buy, fill, take):");
        String userChoice = scanner.next();
        switch (userChoice) {
            case "exit":
                System.exit(0);
                break;
            case "buy":
                buyCoffee(machineContent);
                break;
            case "fill":
                fillMachine(machineContent);
                break;
            case "take":
                takeMoney(machineContent);
                break;
            case "remaining":
                showMachineContent(machineContent);
                break;
            default:
                System.out.print("Incorrect input!");
                showMenu(machineContent);
        }
    }

    public static void main(String[] args) {
        int[] machineContent = new int[] {400, 540, 120, 9, 550}; //water, milk, coffee, cups, money
        while(true) {
            showMenu(machineContent);
        }
    }
}
