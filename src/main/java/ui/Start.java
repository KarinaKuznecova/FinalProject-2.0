package ui;

import data.Storage;
import service.Worker;

import java.util.*;

public class Start {
    private Worker worker = new Worker(new Storage());
    private Reader reader = new Reader();
    private List<Action> actions = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Welcome");
        Start starter = new Start();
        starter.setUp();
        starter.mainMenu();
    }

    private void mainMenu() {
        System.out.println("Please, choose what to do:");
        System.out.println();
        System.out.println("1. Add new product");
        System.out.println("2. Find product by Id");
        System.out.println("3. List all products");
        System.out.println("4. Delete by Id");
        System.out.println("5. List all products by category");
        System.out.println("6. Set discount for category");
        System.out.println("7. Change product information");
        System.out.println("8. Clear product list");
        int pickedNumber = reader.getUserInput("Enter a number: ");
        menuSelected(pickedNumber);
    }

    private void setUp() {
        actions.add(0, new NewProductMenu());
        actions.add(1, new GetByIdMenu());
        actions.add(2, new ListAllMenu());
        actions.add(3, new RemoveByIdMenu());
        actions.add(4, new ListByCategoryMenu());
        actions.add(5, new DiscountForCategoryMenu());
        actions.add(6, new ChangeProductInfoMenu());
        actions.add(7, new RemoveAllMenu());
    }

    private void menuSelected(int userPickedNumber) {
        int index = userPickedNumber - 1;
        try {
            actions.get(index).action(worker);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Wrong number, try again");
        } finally {
            mainMenu();
        }
    }
}