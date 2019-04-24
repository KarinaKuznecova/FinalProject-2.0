package ui;

import service.Worker;

import java.math.BigDecimal;

class ChangeProductInfoMenu implements Action {
    private Reader reader = new Reader();

    @Override
    public void action(Worker worker) {
        long id = (long) reader.getUserInput("Enter product Id");
        worker.getById(id);
        int pickedAction = pickAction();
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
                action(worker);
        }
        System.out.println("Information is updated");
    }

    private int pickAction() {
        System.out.println("Please, choose what to do:");
        System.out.println();
        System.out.println("1. Change name");
        System.out.println("2. Change price");
        System.out.println("3. Set Discount");
        System.out.println("4. Change description");
        System.out.println();
        return reader.getUserInput("Enter a number: ");
    }
}