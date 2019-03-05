package ui;

import service.Worker;
import service.category;

import java.math.BigDecimal;
import java.util.Scanner;

public class Start {
    private Worker worker = new Worker();

    public static void main(String[] args) {
        System.out.println("Welcome");
        Start starter = new Start();
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
        System.out.println("9. Save product list");
        System.out.println("10. Load product list");
        int pickedNumber = getUserInput();
        menuSelected(pickedNumber);
    }

    private int getUserInput() {
        Scanner sc = new Scanner(System.in);
        String userInputLine = sc.next();
        try {
            return Integer.parseInt(userInputLine);
        } catch (NumberFormatException ex) {
            return 0;
        }
    }

    private String getUserInputLine(String prompt) {
        System.out.println(prompt + "  ");
        Scanner sc = new Scanner(System.in);
        String inputLine = sc.nextLine();
        if (inputLine.length() == 0) {
            System.out.println("Try again");
            mainMenu();
        }
        return inputLine;
    }

    private double getUserInputDouble(String prompt) {
        System.out.println(prompt + "  ");
        Scanner sc = new Scanner(System.in);
        try {
            return sc.nextDouble();
        } catch (NumberFormatException ex) {
            System.out.println("Something wrong");
            mainMenu();
        }
        return 0;
    }

    private void menuSelected(int userPickedNumber) {
        switch (userPickedNumber) {
            case 1:
                newProductMenu();
                break;
            case 2:
                getByIdMenu();
                break;
            case 3:
                listAllMenu();
                break;
            case 4:
                removeById();
                break;
            case 5:
                listByCategoryMenu();
                break;
            case 6:
                discountForCategoryMenu();
                break;
            case 7:
                changeProductInfoMenu();
                break;
            case 8:
                removeAllMenu();
                break;
            case 9:
                worker.saveAll();
                break;
            case 10:
                worker.loadAll();
                break;
            default:
                System.out.println("Wrong number");
                mainMenu();
        }
    }

    private void newProductMenu() {
        category pickedCategory = categoryChooser();
        String enteredName = getUserInputLine("Enter product name:");
        BigDecimal enteredPrice = BigDecimal.valueOf(getUserInputDouble("Enter product price:"));
        worker.createNew(enteredName, enteredPrice, pickedCategory);

        System.out.println();
        mainMenu();
    }

    private void getByIdMenu() {
        System.out.println("Enter product Id:");
        long Id = (long) getUserInput();
        worker.getById(Id);

        System.out.println();
        mainMenu();
    }

    private void listAllMenu() {
        worker.listAll();

        System.out.println();
        mainMenu();
    }

    private void removeById() {
        System.out.println("Enter product Id:");
        long Id = (long) getUserInput();
        worker.deleteById(Id);

        System.out.println();
        mainMenu();
    }

    private void listByCategoryMenu() {
        category type = categoryChooser();
        worker.listByCategory(type);

        System.out.println();
        mainMenu();
    }

    private void discountForCategoryMenu() {
        category type = categoryChooser();
        System.out.println("Enter discount:");
        BigDecimal enteredDiscount = BigDecimal.valueOf(getUserInput());
        worker.setDiscountForCategory(type, enteredDiscount);

        System.out.println();
        mainMenu();
    }

    private void removeAllMenu() {
        worker.removeAll();

        System.out.println();
        mainMenu();
    }

    private void changeProductInfoMenu() {
        System.out.println("Enter Id");
        long id = (long) getUserInput();
        worker.getById(id);
        int pickedAction = changeProductInfoMenuStep2();
        switch (pickedAction) {
            case 1:
                String newName = getUserInputLine("Enter new name");
                worker.changeName(id, newName);
                break;
            case 2:
                BigDecimal newPrice = BigDecimal.valueOf(getUserInputDouble("Enter new price"));
                worker.setPriceById(id, newPrice);
                break;
            case 3:
                BigDecimal newDiscount = BigDecimal.valueOf(getUserInputDouble("Enter new discount"));
                worker.setDiscountById(id, newDiscount);
                break;
            case 4:
                String newDescription = getUserInputLine("Enter new description");
                worker.changeProductDescription(id, newDescription);
                break;
            default:
                System.out.println("Wrong number");
                mainMenu();
        }
        System.out.println("Information is updated");
        System.out.println();
        mainMenu();
    }

    private int changeProductInfoMenuStep2() {
        System.out.println("Please, choose what to do:");
        System.out.println();
        System.out.println("1. Change name");
        System.out.println("2. Change price");
        System.out.println("3. Set Discount");
        System.out.println("4. Change description");
        System.out.println();
        return getUserInput();
    }

    private category categoryChooser() {
        category myChoose = null;

        System.out.println("Enter product category:");
        System.out.println("1. " + category.FRUIT);
        System.out.println("2. " + category.VEGETABLE);
        System.out.println("3. " + category.DRINKS);
        System.out.println("4. " + category.DAIRY);
        System.out.println("5. " + category.MEAT);
        System.out.println("6. " + category.SWEETS);
        System.out.println("7. " + category.FISH);
        int enteredCategory = getUserInput();

        switch (enteredCategory) {
            case 1:
                myChoose = category.FRUIT;
                break;
            case 2:
                myChoose = category.VEGETABLE;
                break;
            case 3:
                myChoose = category.DRINKS;
                break;
            case 4:
                myChoose = category.DAIRY;
                break;
            case 5:
                myChoose = category.MEAT;
                break;
            case 6:
                myChoose = category.SWEETS;
                break;
            case 7:
                myChoose = category.FISH;
            default:
                System.out.println("Wrong number");
                mainMenu();
        }
        return myChoose;
    }
}