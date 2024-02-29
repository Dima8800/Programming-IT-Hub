package fifth.BaseTask.Models;

public class TimeResponse {
    String response;
    public TimeResponse(int sum){
        this.response = "{\"total\":" + sum + "}";
    }

    @Override
    public String toString() {
        return response;
    }

    public TimeResponse getTimeResponse(){
        return this;
    }
}
