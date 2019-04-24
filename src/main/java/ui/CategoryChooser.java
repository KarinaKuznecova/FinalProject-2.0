package ui;

import service.category;

class CategoryChooser {

    private Reader reader = new Reader();

    category getCategory() {
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
                return category.FRUIT;
            case 2:
                return category.VEGETABLE;
            case 3:
                return category.DRINKS;
            case 4:
                return category.DAIRY;
            case 5:
                return category.MEAT;
            case 6:
                return category.SWEETS;
            case 7:
                return category.FISH;
            default:
                System.out.println("Wrong number");
                getCategory();
        }
        return null;
    }
}