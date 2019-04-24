package ui;

import service.Worker;
import service.category;

class ListByCategoryMenu implements Action {

    private CategoryChooser categoryChooser = new CategoryChooser();

    @Override
    public void action(Worker worker) {
        category pickedCategory = categoryChooser.getCategory();
        worker.listByCategory(pickedCategory);
    }
}