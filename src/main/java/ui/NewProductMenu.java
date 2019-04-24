package ui;

import service.Worker;
import service.category;

import java.math.BigDecimal;

class NewProductMenu implements Action {

    private Reader reader = new Reader();
    private CategoryChooser categoryChooser = new CategoryChooser();

    @Override
    public void action(Worker worker) {
        category pickedCategory = categoryChooser.getCategory();
        String enteredName = reader.getUserInputLine("Enter product name:");
        BigDecimal enteredPrice = BigDecimal.valueOf(reader.getUserInputDouble("Enter product price:"));
        worker.createNew(enteredName, enteredPrice, pickedCategory);
    }
}