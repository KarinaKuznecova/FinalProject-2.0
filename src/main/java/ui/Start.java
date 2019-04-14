package ui;

import data.Storage;
import service.Worker;
import service.category;

import java.math.BigDecimal;

public class Start {
    private Worker worker = new Worker(new Storage());
    private Reader reader = new Reader();

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
        int pickedNumber = reader.getUserInput("Enter a number: ");
        menuSelected(pickedNumber);
    }

    private void menuSelected(int userPickedNumber) {
        switch (userPickedNumber) {
            case 1:
                newProductMenu();
                mainMenu();
                break;
            case 2:
                getByIdMenu();
                mainMenu();
                break;
            case 3:
                listAllMenu();
                mainMenu();
                break;
            case 4:
                removeById();
                mainMenu();
                break;
            case 5:
                listByCategoryMenu();
                mainMenu();
                break;
            case 6:
                discountForCategoryMenu();
                mainMenu();
                break;
            case 7:
                changeProductInfoMenu();
                mainMenu();
                break;
            case 8:
                removeAllMenu();
                mainMenu();
                break;
            case 9:
                worker.saveAll();
                mainMenu();
                break;
            case 10:
                worker.loadAll();
                mainMenu();
                break;
            default:
                System.out.println("Wrong number");
                mainMenu();
        }
    }

    private void newProductMenu() {
        category pickedCategory = categoryChooser();
        String enteredName = reader.getUserInputLine("Enter product name:");
        BigDecimal enteredPrice = BigDecimal.valueOf(reader.getUserInputDouble("Enter product price:"));
        worker.createNew(enteredName, enteredPrice, pickedCategory);
    }

    private void getByIdMenu() {
        long id = (long) reader.getUserInput("Enter product Id:");
        worker.getById(id);
    }

    private void listAllMenu() {
        worker.listAll();
    }

    private void removeById() {
        long id = (long) reader.getUserInput("Enter product Id:");
        worker.deleteById(id);
    }

    private void listByCategoryMenu() {
        category type = categoryChooser();
        worker.listByCategory(type);
    }

    private void discountForCategoryMenu() {
        category type = categoryChooser();
        BigDecimal enteredDiscount = BigDecimal.valueOf(reader.getUserInput("Enter discount:"));
        worker.setDiscountForCategory(type, enteredDiscount);
    }

    private void removeAllMenu() {
        worker.removeAll();
    }

    private void changeProductInfoMenu() {
        long id = (long) reader.getUserInput("Enter product Id");
        worker.getById(id);
        int pickedAction = changeProductInfoMenuStep2();
        switch (pickedAction) {
            case 1:
                String newName = reader.getUserInputLine("Enter new name");
                worker.changeName(id, newName);
                break;
            case 2:
                BigDecimal newPrice = BigDecimal.valueOf(reader.getUserInputDouble("Enter new price"));
                worker.setPriceById(id, newPrice);
                break;
            case 3:
                BigDecimal newDiscount = BigDecimal.valueOf(reader.getUserInputDouble("Enter new discount"));
                worker.setDiscountById(id, newDiscount);
                break;
            case 4:
                String newDescription = reader.getUserInputLine("Enter new description");
                worker.changeProductDescription(id, newDescription);
                break;
            default:
                System.out.println("Wrong number");
                changeProductInfoMenu();
        }
        System.out.println("Information is updated");
    }

    private int changeProductInfoMenuStep2() {
        System.out.println("Please, choose what to do:");
        System.out.println();
        System.out.println("1. Change name");
        System.out.println("2. Change price");
        System.out.println("3. Set Discount");
        System.out.println("4. Change description");
        System.out.println();
        return reader.getUserInput("Enter a number: ");
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
        int enteredCategory = reader.getUserInput("Enter a number: ");

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
                categoryChooser();
        }
        return myChoose;
    }
}