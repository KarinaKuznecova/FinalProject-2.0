package ui;

import service.Worker;

class RemoveAllMenu implements Action {

    @Override
    public void action(Worker worker) {
        worker.removeAll();
    }
}