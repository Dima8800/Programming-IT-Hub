package ITHub.task;

import ITHub.task.Service.*;

public class Main {
    public static void main(String[] args) {
        HTTPApiService httpApiService = new HTTPApiService("i22s0623","http://10.3.0.96:8000/api/w5/1");
        Parse parse = new Parse();
        Analytics analytics = new Analytics();

        httpApiService.postAnal(analytics.analyze(parse.parseJsonStudents(httpApiService.getActivity())));
    }
}