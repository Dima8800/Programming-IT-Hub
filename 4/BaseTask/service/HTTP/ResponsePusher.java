package fifth.BaseTask.Service.HTTP;

import fifth.BaseTask.Models.ServeResponse;
import fifth.BaseTask.Models.TimeResponse;

public interface ResponsePusher {
    public void pushServe(ServeResponse resp);
    public void pushTime(TimeResponse resp);
    public boolean finished();
}
