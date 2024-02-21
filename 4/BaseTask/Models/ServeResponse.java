package fifth.BaseTask.Models;

public class ServeResponse {
    String Response;
    public ServeResponse(String info){
        if (info == "null") {
            this.Response = "null";
            return;
        }
        this.Response = "{\"id\":\""
                + info.split(" ")[0]
                + "\",\"timeToCook\":"
                + info.split(" ")[1] + "}";
        //{"id": string, "timeToCook": int}
    }

    @Override
    public String toString() {
        return Response;
    }

    public ServeResponse getResponse() {
        return this;
    }
}
