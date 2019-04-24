package ui;

import service.Worker;

class RemoveByIdMenu implements Action {
    private Reader reader = new Reader();

    @Override
    public void action(Worker worker) {
        long id = (long) reader.getUserInput("Enter product Id:");
        worker.deleteById(id);
    }
}