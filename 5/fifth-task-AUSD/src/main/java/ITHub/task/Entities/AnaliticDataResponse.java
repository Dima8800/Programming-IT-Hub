package ITHub.task.Entities;

import ITHub.task.MyHash.MyHashSet;
import ITHub.task.MyHash.MyHashable;

public class AnaliticDataResponse implements MyHashable {
    private String Weight;
    MyHashSet<ServiceUsed> servicesUsedSet;

    public AnaliticDataResponse(String weight, ServiceUsed service) {
        Weight = weight;
        this.servicesUsedSet = new MyHashSet<>();
        this.servicesUsedSet.add(service);
    }

    public String getWeight() {
        return Weight;
    }

    public void setWeight(String weight) {
        Weight = weight;
    }

    public MyHashSet<ServiceUsed> getServicesUsedSet() {
        return servicesUsedSet;
    }

    public void setServicesUsedSet(ServiceUsed service) {
        this.servicesUsedSet.add(service);
    }

    @Override
    public int hashMeDaddy() {
        int hash = 0;
        for (int i = 0; i < Weight.length(); i++) {
            hash = 31 * hash + Weight.charAt(i);
        }
        return Math.abs(hash);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AnaliticDataResponse other = (AnaliticDataResponse) obj;
        return Weight.equals(other.Weight) && servicesUsedSet.equals(other.servicesUsedSet);
    }

    @Override
    public String toString(){
        return Weight;
    }
}
