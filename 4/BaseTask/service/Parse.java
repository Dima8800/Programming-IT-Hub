package BaseTask.service;

public class Parse {
    public String GetComm(String allcomm){
        return allcomm.replaceAll("\"","").split("cmd:")[1].split(",")[0];
    }
    public String[] GetNewOrder(String allcomm){
        String[] ord = new String[2];
        allcomm = allcomm.replaceAll("\"","");
        ord[0] = allcomm.split("id:")[1].split(",")[0];
        ord[1] = Integer.toString(GetSum(allcomm));
        return ord;
    }
    private int GetSum(String item){
        String[] split = item.split("timeToCook:");
        int sum = 0;
        for (int i = 1; i < split.length;i++){
            sum += Integer.parseInt(split[i].split("}")[0]);
        }
        return sum;
    }
    public String GenerateServeOrder(String[] resp){
        return "{\"id\":" + "\"" + resp[0] + "\"," + "\"timeToCook\":" + resp[1] + "}";
    }
    public String GenerateTime(int sum){
        return "{\"total\":" + sum + "}";
    }
}
