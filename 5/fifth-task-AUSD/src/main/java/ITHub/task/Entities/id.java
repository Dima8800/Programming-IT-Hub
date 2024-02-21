package ITHub.task.Entities;

import ITHub.task.MyHash.MyHashable;

public class id implements MyHashable {
  private String ID;
  public id(String id){
    this.ID = id;
  }

  public id getId () {
    return this;
  }

  public void setId (String id) {
    this.ID = id;
  }

  @Override
  public int hashMeDaddy() {
    int hash = 0;
    for (int i = 0; i < ID.length(); i++) {
      hash = 31 * hash + ID.charAt(i);
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
    id other = (id) obj;
    return ID.equals(other.ID);
  }

  @Override
  public String toString(){
    return ID;
  }
}
