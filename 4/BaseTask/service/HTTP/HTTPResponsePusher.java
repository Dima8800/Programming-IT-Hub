package fifth.BaseTask.Service.HTTP;

import fifth.BaseTask.Models.ServeResponse;
import fifth.BaseTask.Models.TimeResponse;
import fifth.BaseTask.Service.HTTPApiService;

public class HTTPResponsePusher implements ResponsePusher {
    HTTPApiService HAP = new HTTPApiService();
    @Override
    public void pushServe(ServeResponse resp) {
        HAP.pushServe(resp);
    }

    @Override
    public void pushTime(TimeResponse resp) {
        HAP.pushTime(resp);
    }

    @Override
    public boolean finished() {
        return HAP.finished();
    }
}
