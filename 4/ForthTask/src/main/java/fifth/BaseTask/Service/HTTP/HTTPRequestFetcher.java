package fifth.BaseTask.Service.HTTP;

import fifth.BaseTask.Models.Request;
import fifth.BaseTask.Service.HTTPApiService;

public class HTTPRequestFetcher implements RequestFetcher{
    HTTPApiService HAP = new HTTPApiService();
    @Override
    public Request getNext() {
        return HAP.GetNext();
    }
}
