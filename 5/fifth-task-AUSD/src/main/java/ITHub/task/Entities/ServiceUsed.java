package ITHub.task.Entities;

import ITHub.task.MyHash.MyHashable;

import java.util.Arrays;
import java.util.Objects;

public class ServiceUsed implements MyHashable {
  private String Service;

  public ServiceUsed (String service) {
    Service = service;
  }

  public String getService () {
    return Service;
  }

  public void setService (String service) {
    Service = service;
  }

  public ServiceUsed getServiceUsed(){
    return this;
  }
  @Override
  public int hashMeDaddy () {
    int result = 17;
    result = 31 * result + (Service != null ? hashString(Service) : 0);
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

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    ServiceUsed other = (ServiceUsed) obj;
    return Objects.equals(Service, other.Service);
  }

  @Override
  public String toString() {
    return getService();
  }
}
