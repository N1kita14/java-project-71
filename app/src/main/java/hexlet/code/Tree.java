package hexlet.code;

import java.util.*;

public class Tree {
    public static List<Map<String, Object>> gDiff(Map<String, Object> map1, Map<String, Object> map2) throws Exception {

        TreeSet<String> keys = new TreeSet<>();
        keys.addAll(map1.keySet());
        keys.addAll(map2.keySet());

        List<Map<String, Object>> maps = new ArrayList<Map<String, Object>>();

        for (String key : keys) {

            Map<String, Object> mapsKeys = new HashMap<String, Object>();
            mapsKeys.put("key", key);

            if (map1.containsKey(key) && map2.containsKey(key)) {
                if (map1.get(key) != null && map2.get(key) != null
                        && map1.get(key).equals(map2.get(key))) {
                    mapsKeys.put("status", "unchanged");
                    mapsKeys.put("value1", map1.get(key));
                    mapsKeys.put("value2", map2.get(key));
                } else {
                    mapsKeys.put("status", "changed");
                    mapsKeys.put("value1", map1.get(key));
                    mapsKeys.put("value2", map2.get(key));
                }
            } else if (map1.containsKey(key) && !map2.containsKey(key)) {
                mapsKeys.put("status", "removed");
                mapsKeys.put("value1", map1.get(key));
                mapsKeys.put("value2", null);
            } else if (!map1.containsKey(key) && map2.containsKey(key)) {
                mapsKeys.put("status", "added");
                mapsKeys.put("value1", null);
                mapsKeys.put("value2", map2.get(key));
            }
            maps.add(mapsKeys);
        }
        return maps;
    }
}
