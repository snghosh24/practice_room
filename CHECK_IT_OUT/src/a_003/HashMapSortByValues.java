package a_003;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class HashMapSortByValues {

	public static Map sortMapByValues(Map<String, Integer> map) {

		List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				if (o1.getValue() == o2.getValue()) {
					return o1.getKey().compareTo(o2.getKey());
				} else {
					return (o1.getValue()).compareTo(o2.getValue());
				}
			}
		});

		HashMap<String, Integer> result = new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> aa : list) {
			result.put(aa.getKey(), aa.getValue());
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<String, Integer> map = new HashMap<>();

		map.put("Math", 98);
		map.put("Phys", 91);
		map.put("Chem", 89);
		map.put("Hist", 97);
		map.put("Pols", 91);
		map.put("Java", 94);
		map.put("Topic1", 98);
		map.put("Topic2", 98);

		System.out.println(sortMapByValues(map));

	}

}
