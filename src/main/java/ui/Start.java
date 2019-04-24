package ui;

import data.Storage;
import service.Worker;

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
                NewProductMenu newProductMenu = new NewProductMenu();
                newProductMenu.action(worker);
                mainMenu();
                break;
            case 2:
                GetByIdMenu getByIdMenu = new GetByIdMenu();
                getByIdMenu.action(worker);
                mainMenu();
                break;
            case 3:
                ListAllMenu listAllMenu = new ListAllMenu();
                listAllMenu.action(worker);
                mainMenu();
                break;
            case 4:
                RemoveByIdMenu removeByIdMenu = new RemoveByIdMenu();
                removeByIdMenu.action(worker);
                mainMenu();
                break;
            case 5:
                ListByCategoryMenu listByCategoryMenu = new ListByCategoryMenu();
                listByCategoryMenu.action(worker);
                mainMenu();
                break;
            case 6:
                DiscountForCategoryMenu discountForCategoryMenu = new DiscountForCategoryMenu();
                discountForCategoryMenu.action(worker);
                mainMenu();
                break;
            case 7:
                ChangeProductInfoMenu changeProductInfoMenu = new ChangeProductInfoMenu();
                changeProductInfoMenu.action(worker);
                mainMenu();
                break;
            case 8:
                RemoveAllMenu removeAllMenu = new RemoveAllMenu();
                removeAllMenu.action(worker);
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
}