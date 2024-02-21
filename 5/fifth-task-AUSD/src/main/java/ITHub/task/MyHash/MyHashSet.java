package ITHub.task.MyHash;

import java.util.ArrayList;
import java.util.List;

public class MyHashSet<V extends MyHashable> {
    private MyHashMap<V, V> map;

    public MyHashSet() {
        map = new MyHashMap<>();
    }

    public void add(V val) {
        map.mapKeyVal(val, val);
    }

    public boolean has(V val) {
        return map.mapKey(val) != null;
    }

    public void del(V val) {
        map.delKey(val);
    }

    public int size() {
        return map.size();
    }

    public V[] vals() {
        List<V> valList = new ArrayList<>();

        for (V key : map.keys()) {
            valList.add(map.mapKey(key));
        }

        @SuppressWarnings("unchecked")
        V[] vals = (V[]) new MyHashable[valList.size()];
        return valList.toArray(vals);
    }
}
