package fifth.BaseTask.Models;

public class Request {

    private String cmd;
    private String id;
    private String timeToCook;
    public Request(String comm){
        comm = comm.replaceAll("\"","");
        if ((comm.split("cmd:")[1].split(",")[0]).equals("new-order")){
            this.cmd = comm.split("cmd:")[1].split(",")[0];
            this.id = comm.split("id:")[1].split(",")[0];
            this.timeToCook = Integer.toString(GetSum(comm));
            return;
        }
        this.cmd = comm.split("cmd:")[1].split(",")[0];
    }
    private int GetSum(String item){
        String[] split = item.split("timeToCook:");
        int sum = 0;
        for (int i = 1; i < split.length;i++){
            sum += Integer.parseInt(split[i].split("}")[0]);
        }
        return sum;
    }

    public String getCmd(){
        return this.cmd;
    }

    public String getId() {
        return this.id;
    }

    public String getTimeToCook() {
        return this.timeToCook;
    }

    public Request getRequest(){
        return this;
    }
}
