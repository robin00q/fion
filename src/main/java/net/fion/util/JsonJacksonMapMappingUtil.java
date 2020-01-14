package net.fion.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import net.fion.hashmap.CommonHashMap;

public class JsonJacksonMapMappingUtil {

	private static JSONParser jsonParser = new JSONParser();

	private static JSONArray readJsonFile(String filePath) {
		InputStream is = JsonJacksonMapMappingUtil.class.getResourceAsStream(filePath);
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		try {
			JSONArray jsonArray = (JSONArray) jsonParser.parse(reader);
			return jsonArray;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private static void generateHashMap(String filePath, String key, String value, HashMap hashMap) {
		JSONArray jsonArray = readJsonFile(filePath);
		
		Iterator<JSONObject> iterator = jsonArray.iterator();
		
		while(iterator.hasNext()) {
			JSONObject jsonObj = iterator.next();
			String keyString = jsonObj.get(key).toString();
			String valueString = (String) jsonObj.get(value);
			if(valueString != null) {
				hashMap.put(keyString, valueString);
			}
		}
	}

	public static void jsonMatchTypetoHashMap() {
		generateHashMap("/matchtype.json", "matchtype", "desc", CommonHashMap.matchTypeHashMap);
	}
	
	public static void jsonDivisiontoHashMap() {
		generateHashMap("/division.json", "divisionId", "divisionName", CommonHashMap.divisionHashMap);
	}
	
	public static void jsonSpidtoHashMap() {
		generateHashMap("/spid.json", "id", "name", CommonHashMap.spidHashMap);
	}


}
