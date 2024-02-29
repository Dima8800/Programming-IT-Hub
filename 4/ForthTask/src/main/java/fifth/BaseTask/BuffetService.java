package fifth.BaseTask;

import fifth.BaseTask.Models.*;

import fifth.BaseTask.Order.*;

import fifth.BaseTask.Service.HTTP.*;

public class BuffetService {
    RequestFetcher RF;
    OrderQueuer memory;
    ResponsePusher RP;
    public BuffetService(RequestFetcher RF, OrderQueuer memory, ResponsePusher RP){
        this.RF = RF;
        this.memory = memory;
        this.RP = RP;
    }

    public static void main(String[] args) {
        MyQuene quene = new QueneForBaseTaskArrayList();
        RequestFetcher RF = new HTTPRequestFetcher();
        OrderQueuer memory = new InMemoryOrderQuener(quene);
        ResponsePusher RP = new HTTPResponsePusher();

        BuffetService B = new BuffetService(RF, memory,RP);
        B.runUnntilDone();
    }
    public void runUnntilDone(){
        String command;

        while (true){
            Request R = (Request) RF.getNext();
            command = R.getCmd();

            switch (command){
                case "new-order":
                    Order O = new Order(R.getId(), Integer.parseInt(R.getTimeToCook()));
                    memory.addOrder(O);
                    break;
                case "serve-order":
                    ServeResponse SR;
                    Object serverOrder = memory.serverOrder();
                    if (serverOrder != null) {
                        SR = new ServeResponse(serverOrder.toString());
                    } else {
                        SR = new ServeResponse("null");
                    }
                    RP.pushServe(SR.getResponse());
                    break;
                case "time-to-serve-all":
                    TimeResponse TR = new TimeResponse(memory.getTotalTimeToCook());
                    RP.pushTime(TR.getTimeResponse());
                    break;
                case "none":
                    if (!RP.finished())
                        System.out.println("дибил");
                    return;
                default:
                    System.out.println("Error pars/ Error response");
                    break;
            }
        }
    }
}