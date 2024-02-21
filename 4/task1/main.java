package task1;

import BaseTask.BuffetService;
import BaseTask.interfases.OrderQueuer;

public class main {
    public static void main(String[] args) {
        OrderQueuer OQ = new RingBuffer();

        BuffetService.RunUntilDone(OQ);
    }
}
