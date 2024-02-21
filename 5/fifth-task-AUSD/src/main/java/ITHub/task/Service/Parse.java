package ITHub.task.Service;

import ITHub.task.Entities.*;

import ITHub.task.MyHash.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class Parse {
    Gson gson = new Gson();
    public ArrayList<Student> parseJsonStudents(String json){
        return gson.fromJson(json, new TypeToken<ArrayList<Student>>(){}.getType());
    }

    public String toCorrectJson(MyHashMap<id, AnaliticDataResponse> dataResponseMyHashMap, float avgWeight, float avgService){
        String result =
                "{\"avgWeight\":" + "\"" + avgWeight + "\"," +
                        "\"avgServicesUsed\":" + "\"" + avgService + "\"," +
                        "\"byStudent\":{";

        ArrayList keys = getAllKeys(dataResponseMyHashMap.keys());

        for (int i = 0; i < keys.size(); i++){
            id ID = new id(keys.get(i).toString());
            result += "\"" + ID.toString()
                    + "\":{\"servicesUsed\":"
                    + "\"" + dataResponseMyHashMap.mapKey(ID).getServicesUsedSet().size() + "\","
                    + "\"totalWeight\":"
                    + "\"" + dataResponseMyHashMap.mapKey(ID).getWeight() + "\"},";
        }
        result = result.substring(0,result.length()-1);
        result += "}}";

        System.out.println(result);
        return result;
    }

    private ArrayList getAllKeys(MyHashable[] myHashSet1){
        ArrayList<String> result = new ArrayList<>();

        for (MyHashable hashable : myHashSet1) {
            result.add(hashable.toString());
        }
        return result;
    }
}
