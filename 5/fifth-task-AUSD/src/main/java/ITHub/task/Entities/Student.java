package ITHub.task.Entities;

import ITHub.task.MyHash.MyHashable;

public class Student implements MyHashable {
    String studId;
    String service;
    String idInService;
    int activityWeight;

    public Student (String studId, String service, String idInService, int activityWeight) {
        this.activityWeight = activityWeight;
        this.idInService = idInService;
        this.service = service;
        this.studId = studId;
    }

    public String getStudId () {
        return studId;
    }

    public void setStudId (String studId) {
        this.studId = studId;
    }

    public String getService () {
        return service;
    }

    public void setService (String service) {
        this.service = service;
    }

    public String getIdInService () {
        return idInService;
    }

    public void setIdInService (String idInService) {
        this.idInService = idInService;
    }

    public int getActivityWeight () {
        return activityWeight;
    }

    public void setActivityWeight (int activityWeight) {
        this.activityWeight = activityWeight;
    }

    @Override
    public int hashMeDaddy () {
        int result = 17;
        result = 31 * result + (studId != null ? hashString(studId) : 0);
        result = 31 * result + (service != null ? hashString(service) : 0);
        result = 31 * result + (idInService != null ? hashString(idInService) : 0);
        result = 31 * result + activityWeight;
        return result;
    }

    private int hashString (String str) {
        int hash = 0;
        if ( str.isEmpty() )
            return hash;

        for (int i = 0; i < str.length(); i++) {
            hash = 31 * hash + str.charAt(i);
        }
        return hash;
    }
}
