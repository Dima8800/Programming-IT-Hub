package ITHub.task.Service;

import ITHub.task.Entities.*;
import ITHub.task.MyHash.*;

import java.util.ArrayList;

public class Analytics {
  public float totalWeight = 0;
  public float avgWeight = 0;
  public float avgServiceUsed = 0;
  public float totalService = 0;

  Parse parse = new Parse();
  public String analyze (ArrayList<Student> data) {
    MyHashMap<id,AnaliticDataResponse> studentDataMap = new MyHashMap<>();

    for (int i = 0; i < data.size(); i++){
      id Id = new id(data.get(i).getStudId());
      ServiceUsed su = new ServiceUsed(data.get(i).getService());

      if (studentDataMap.mapKey(Id) == null){
        AnaliticDataResponse A = new AnaliticDataResponse(Integer.toString(data.get(i).getActivityWeight()),su);
        studentDataMap.mapKeyVal(Id,A);
      }else {
        AnaliticDataResponse f = studentDataMap.mapKey(Id);
        studentDataMap.delKey(Id);
        f.setServicesUsedSet(su);
        f.setWeight(Integer.toString(Integer.parseInt(f.getWeight()) + data.get(i).getActivityWeight()));
        studentDataMap.mapKeyVal(Id,f);
      }
    }
    ArrayList keys = getAllKeys(studentDataMap.keys());

    for (int i = 0; i < keys.size(); i ++){
      id ID = new id(keys.get(i).toString());
      MyHashable[] f  = studentDataMap.mapKey(ID).getServicesUsedSet().vals();
      ArrayList<String> result = new ArrayList<>();

      for (MyHashable hashable : f) {
        result.add(hashable.toString());
      }
      totalService += result.size();
      totalWeight += Integer.parseInt(studentDataMap.mapKey(ID).getWeight());
    }
    avgServiceUsed = totalService/keys.size();
    avgWeight = totalWeight/keys.size();
    return parse.toCorrectJson(studentDataMap,avgWeight,avgServiceUsed);
  }
  private ArrayList getAllKeys(MyHashable[] myHashSet1){
    ArrayList<String> result = new ArrayList<>();

    for (MyHashable hashable : myHashSet1) {
      result.add(hashable.toString());
    }
    return result;
  }
}
