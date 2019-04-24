package ui;

import service.Worker;

class GetByIdMenu implements Action {
    private Reader reader = new Reader();

    @Override
    public void action(Worker worker) {
        long id = (long) reader.getUserInput("Enter product Id:");
        worker.getById(id);
    }
}