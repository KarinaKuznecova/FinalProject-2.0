package ui;

import service.Worker;
import service.category;

import java.math.BigDecimal;

class DiscountForCategoryMenu implements Action {
    private Reader reader = new Reader();
    private CategoryChooser categoryChooser = new CategoryChooser();

    @Override
    public void action(Worker worker) {
        category type = categoryChooser.getCategory();
        BigDecimal enteredDiscount = BigDecimal.valueOf(reader.getUserInput("Enter discount:"));
        worker.setDiscountForCategory(type, enteredDiscount);
    }
}