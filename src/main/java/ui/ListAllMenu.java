package ui;

import service.Worker;

class ListAllMenu implements Action {

    @Override
    public void action(Worker worker) {
        worker.listAll();
    }
}