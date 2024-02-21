package fifth.Task0;

import fifth.BaseTask.BuffetService;
import fifth.BaseTask.Order.*;
import fifth.BaseTask.Service.HTTP.*;

public class main {
    public static void main(String[] args) {
        MyQuene quene = new LinkedList();
        RequestFetcher RF = new HTTPRequestFetcher();
        OrderQueuer memory = new InMemoryOrderQuener(quene);
        ResponsePusher RP = new HTTPResponsePusher();

        BuffetService B = new BuffetService(RF, memory,RP);
        B.runUnntilDone();
    }
}
