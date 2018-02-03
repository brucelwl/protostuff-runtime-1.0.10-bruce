package com.test;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class MapKeySortBruce {
	
	public static void main(String[] args) {

		Map<String, String> map = new TreeMap<String, String>();

		//a=23&b=12&c=67&d=48&f=8bbbbb
		map.put("a", "kfc");
		map.put("c", "wnba");
		map.put("b", "nba");
		map.put("d", "cba");

		Map<String, String> resultMap = sortMapByKey(map);	//按Key进行排序

		for (Map.Entry<String, String> entry : resultMap.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}
	
	/**
	 * 使用 Map按key进行排序
	 * @param map
	 * @return
	 */
	public static Map<String, String> sortMapByKey(Map<String, String> map) {
		if (map == null || map.isEmpty()) {
			return null;
		}

		Map<String, String> sortMap = new TreeMap<String, String>(new MapKeyComparator());

		sortMap.putAll(map);

		return sortMap;
	}
	
	static class MapKeyComparator implements Comparator<String>{

		@Override
		public int compare(String str1, String str2) {
			
			return str1.compareTo(str2);
		}
	}

}
